package com.english;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException,
    IOException {
        BufferedReader bufferedReader;
        String[] stringArray = null;
        //文件路径
        String filePath;
        while (true) {
            System.out.println("请您输入你要朗读的文件路径");
            bufferedReader = new BufferedReader(new InputStreamReader(System. in ));
            filePath = bufferedReader.readLine();
            if (filePath == null || "".equals(filePath.trim())) {
                continue;
            } else {
                File file = new File(filePath);
                if (!file.exists()) {
                    System.out.println("该文件不存在，请您重新输入");
                    continue;
                } else {
                    stringArray = filePath.split("/");
                    file = null;
                    break;
                }
            }

        }
        //缓存用
        StringBuilder stringTemp = new StringBuilder();
        for (int i = 0; i < stringArray.length - 1; i++) {
            stringTemp.append(stringArray[i] + "/");
        }

        //文件夹路径
        final String folderPath = stringTemp.toString();
        //监听文件状态
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Thread() {@Override public void run() {
                WatchFiles.watchFiles(folderPath);
            }
        });
        //朗读文件
        ArrangeAndRead arrangement = new ArrangeAndRead();
        arrangement.readFile(filePath);

    }
}