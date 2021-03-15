package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

@RestController
public class UploadAndDownload {

    /**
     * @param uploadFile 传过来的参数名须和方法形参一样，否则为空
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile) {
        //对应的是calsses目录
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String originalFilename = uploadFile.getOriginalFilename();
        File file = new File(path + originalFilename);
        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "sucess";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) {
        //当前项目路径
        String path = this.getClass().getClassLoader().getResource("").getPath();
        //要下载的服务器上的文件
        File file = new File(path + "新楼盘.xlsx");
        //返回给客户端的文件名
        String fileName = "";
        try {
            fileName = URLEncoder.encode("新楼盘.xlsx", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";filename*=utf-8''" + fileName);
        response.setContentType("application/octet-stream");
        response.setContentLength((int) file.length());
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();
            int len; //每次读取的长度
            byte[] flush = new byte[1024]; //缓冲容器，一次读写1k
            while ((len = fileInputStream.read(flush)) != -1) {
                outputStream.write(flush, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
