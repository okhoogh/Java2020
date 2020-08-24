package download;

import utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        // 2.使用字节输入流将文件加载进内存
        // 2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        // 2.2使用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        // 3.设置response响应头
        /***************************************************/
        // 3.0解决下载时文件名乱码问题
        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);
        /***************************************************/
        // 3.1设置响应头类型
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
        // 3.2设置响应头打开方式
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        // 4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            sos.write(bytes, 0, len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
