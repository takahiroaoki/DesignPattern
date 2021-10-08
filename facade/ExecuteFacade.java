package facade;

import facade.pagemaker.PageMaker;

public class ExecuteFacade {
    public static void main(String[] args) {
        PageMaker.makeWelcomPage("taro@example.com", "facade/welcome.html");
        PageMaker.makeLinkPage("facade/linkpage.html");
    }
}
