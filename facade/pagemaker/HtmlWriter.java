package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

class HtmlWriter {// 同パッケージからのみ（今回はPageMakerからのみ）使用可能
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<html>\n<head>\n");
        writer.write("<title>" + title + "</title>\n");
        writer.write("</head>\n<body>\n");
        writer.write("<h1>" + title + "</h1>\n");

    }

    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }

    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    public void mailTo(String mailAddress, String userName) throws IOException {
        link("mailto: " + mailAddress, userName);
    }

    public void close() throws IOException {
        writer.write("</body>\n</html>");
        writer.close();
    }

}
