
package com.lgsi.backend.service;

import com.lgsi.backend.dto.AddHumidityTemperatureRequest;
import com.lgsi.backend.repository.HumidityTemperatureRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class TempAndHumidityReceiveService {

    private final String filePath;
    private final HumidityTemperatureRepository humidityTemperatureRepository;

    public TempAndHumidityReceiveService(@Value("${file.path}") String filePath, HumidityTemperatureRepository humidityTemperatureRepository) {
        this.filePath = filePath;
        this.humidityTemperatureRepository = humidityTemperatureRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void readLastLineAndSave() {
        File file = new File(filePath);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
            StringBuffer lastLine = new StringBuffer();
            long fileLength = randomAccessFile.length();
            int newLineCount = 0;

            for (long pointer = fileLength - 1; pointer >= 0; pointer--){
                randomAccessFile.seek(pointer);
                char c = (char) randomAccessFile.read();

                if(c == '\n'){
                    newLineCount++;
                    if (newLineCount == 2) {
                        break;
                    }
                }

                if (newLineCount == 1) {
                    lastLine.insert(0,c);
                }
            }

            String realLastLine = lastLine.toString();

            String[] data = realLastLine.split(",");
            double humidity = 0;
            double temperature = 0;
            if (data.length >= 2) {
                String[] humidityData = data[0].split("!");
                if (humidityData.length >= 2) {
                    humidity = Double.parseDouble(humidityData[1]);
                } else {
                    System.out.println("Invalid format for humidity data: " + data[0]);
                }

                String[] temperatureData = data[1].split("!");
                if (temperatureData.length >= 2) {
                    temperature = Double.parseDouble(temperatureData[1]);
                } else {
                    System.out.println("Invalid format for temperature data: " + data[1]);
                }
            } else {
                System.out.println("Invalid data format: " + realLastLine);
            }

            System.out.println(humidity + temperature);
            AddHumidityTemperatureRequest request = new AddHumidityTemperatureRequest(humidity, temperature);
            humidityTemperatureRepository.save(request.toEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

