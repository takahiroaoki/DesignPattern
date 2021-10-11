package mediator;

public class ExecuteMediator {
    public static void main(String[] args) {
        /**
         * [以下、未解決。]
         * このDockerコンテナ内ににGUIはないため、GUIを使うFrameをそのまま使用することはできない。
         * そこで、コンテナ内からホストのGUIを使う必要がある。
         * こちらのサイト（https://wisteriahill.sakura.ne.jp/CMS/WordPress/2020/09/02/docker-desktop-for-windows-x-window-gui/）
         * を参考にするも、未解決
         */
        new LoginFrame("Mediator Sample");
    }
}