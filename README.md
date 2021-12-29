# design-pattern

本レポジトリのコードは基本的に[増補改訂版 Java言語で学ぶデザインパターン入門](https://www.amazon.co.jp/%E5%A2%97%E8%A3%9C%E6%94%B9%E8%A8%82%E7%89%88-Java%E8%A8%80%E8%AA%9E%E3%81%A7%E5%AD%A6%E3%81%B6%E3%83%87%E3%82%B6%E3%82%A4%E3%83%B3%E3%83%91%E3%82%BF%E3%83%BC%E3%83%B3%E5%85%A5%E9%96%80-%E7%B5%90%E5%9F%8E-%E6%B5%A9-ebook/dp/B00I8ATHGW/ref=pd_sbs_1/357-3813772-7623335?pd_rd_w=38s08&pf_rd_p=4e34a507-1281-42ae-953a-93a761caa89c&pf_rd_r=RGM2E8CPX41ETJHWJV98&pd_rd_r=1a0c6eb1-76b8-49fe-971a-98d7510a0775&pd_rd_wg=9654E&pd_rd_i=B00I8ATHGW&psc=1)に基づいています。

Javaのバージョンの関係や学習のために、配布されたコードと異なる箇所が複数あります。元のコードは[SBクリエイティブの商品ページ](https://www.sbcr.jp/product/4797327030/)からダウンロードすることができます。また著者の方の公式サイトは[コチラ](https://www.hyuki.com/)です。


## 実行環境

本レポジトリのコードの実行環境は以下です。

- Windows 10
- [Docker Desktop for Windows](https://www.docker.com/products/docker-desktop) 4.2.0
- VSCode + Remote Development 0.21.0（拡張機能）
- [VcXsrv](https://sourceforge.net/projects/vcxsrv/)

## 動作確認
動作確認をする際は以下の手順で行ってください。

1. Docker Desktopを起動する。
2. design-patternフォルダ（つまりこのプロジェクト）をRemote Development拡張機能をインストールしたVSCodeで開く
3. コマンドパレットから"Reopen in Container"を実行する。
4. 各パッケージのExecuteXXX.javaを実行する。

なお.devcontainerディレクトリと同一階層にある各パッケージ内で依存関係は簡潔しており、各パッケージ内のExecuteXXX.javaを実行することができます。一部、コマンドライン引数などを使用するコードについてはExecuteXXX.javaコード内に実行方法を記載しているのでそれを参考にしてください。

GUIツールを必要とするjava.awt.Frameクラスなどの表示についてはX Window System (X11)を使用して、ホストコンピュータの画面に表示しています。

こうしたコードの実行手順は以下です。

1. [VcXsrv](https://sourceforge.net/projects/vcxsrv/)をインストール。
2. VcXsrvを起動して適宜設定を行う（[参考リンク](https://wisteriahill.sakura.ne.jp/CMS/WordPress/2020/09/02/docker-desktop-for-windows-x-window-gui/)）。
3. .devcontainer/devcontainer.jsonファイル内にある以下の設定を環境に応じて変更し、コマンドパレットからRebuild

```
"remoteEnv": {
	"DISPLAY": "YourIPAddress:DisplayNumber.ScreenNumber"
}
```
4. 該当のExecuteXXX.javaを実行
## 参考文献
- [増補改訂版 Java言語で学ぶデザインパターン入門](https://www.amazon.co.jp/%E5%A2%97%E8%A3%9C%E6%94%B9%E8%A8%82%E7%89%88-Java%E8%A8%80%E8%AA%9E%E3%81%A7%E5%AD%A6%E3%81%B6%E3%83%87%E3%82%B6%E3%82%A4%E3%83%B3%E3%83%91%E3%82%BF%E3%83%BC%E3%83%B3%E5%85%A5%E9%96%80-%E7%B5%90%E5%9F%8E-%E6%B5%A9-ebook/dp/B00I8ATHGW/ref=pd_sbs_1/357-3813772-7623335?pd_rd_w=38s08&pf_rd_p=4e34a507-1281-42ae-953a-93a761caa89c&pf_rd_r=RGM2E8CPX41ETJHWJV98&pd_rd_r=1a0c6eb1-76b8-49fe-971a-98d7510a0775&pd_rd_wg=9654E&pd_rd_i=B00I8ATHGW&psc=1)
