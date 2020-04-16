package com.atguigu.gmall.manage;


import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;


import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.PostVMInitHook;

import java.io.IOException;

@SpringBootTest
class GmallManageWebApplicationTests {

//    public static void main(String[] args) throws IOException, MyException {
//        contextLoads();
//    }



   public static void contextLoads() throws IOException, MyException {
        String path = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();

         ClientGlobal.init(path);

        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer=trackerClient.getTrackerServer();
        StorageClient storageClient=new StorageClient(trackerServer,null);
        String orginalFilename="d://2.jpg";
        String[] upload_file = storageClient.upload_file(orginalFilename, "jpg", null);
        String url="http://192.168.11.128";
        for (int i = 0; i < upload_file.length; i++) {
            String s = upload_file[i];
            System.out.println("s = " + s);
           url +="/"+s;
            System.out.println(url);
        }

    }

}
