package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;

@RestController
public class UploadAndDownload {

    @Value("classpath:test.xlsx")
    private Resource resource;
    /**
     * 上传文件，支持上传多个文件
     * @param file 传过来的参数名须和方法形参一样，否则为空
     * @return
     */
    @PostMapping("/upload")
    public String upload(List<MultipartFile> file, HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            System.out.println(nextElement+"====="+request.getHeader(nextElement));
        }
        System.out.println("********************");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String nextElement = parameterNames.nextElement();
            System.out.println(nextElement+"========"+request.getParameter(nextElement));
        }
        //对应的是calsses目录
        String path = this.getClass().getClassLoader().getResource("").getPath();
        try {
            if (file !=null) {

                for (MultipartFile multipartFile : file) {
                    String originalFilename = multipartFile.getOriginalFilename();
                    File localFile = new File(path + originalFilename);
                    multipartFile.transferTo(localFile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "sucess";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        //要下载的服务器上的文件
        File file = resource.getFile();
        //返回给客户端的文件名
        String fileName = "";
        try {
            fileName = URLEncoder.encode("test.xlsx", "UTF-8");
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
