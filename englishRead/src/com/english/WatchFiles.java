package com.english;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class WatchFiles {
    public static void watchFiles(String path) {
        // 需要监听的文件目录（只能监听目录）
        System.out.println("开始监听");
        Path p = Paths.get(path);
        WatchService watchService = null;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            p.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,  
                    StandardWatchEventKinds.ENTRY_DELETE,  
                    StandardWatchEventKinds.ENTRY_CREATE);
        } catch (IOException e) {
            System.out.println("发生异常");
            e.printStackTrace();
        }
        try {  
            while(true){  
                WatchKey watchKey = watchService.take();  
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();  
                for(WatchEvent<?> event : watchEvents){  
                    //根据事件类型采取不同的操作。。。。。。。  
                    ArrangeAndRead.implementRead("打断一下，有人修改文件");
                    System.out.println("["+path+"/"+event.context()+"]文件发生了["+event.kind()+"]事件");    
                }  
                watchKey.reset();  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }
    }
}
