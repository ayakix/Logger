orhanobut/loggerのリリースバージョンで表示するログレベルの設定方法

## 概要
[orhanobut/logger](https://github.com/orhanobut/logger)は、Androidでログを表示するための便利なライブラリです。
ここでは、リリースバージョンでエラーログのみを表示するように、ログレベルを設定する方法について説明します。

## 設定方法
### 表示するログレベルの定義
LogAdapterを実装したクラスを用意します。BuildConfig.DEBUGは、リリースバージョンではfalseとなるため、ここではエラーレベルのログ以外のものはリリースバージョンでは表示しないようにします。

```java
public class MyLogAdapter implements LogAdapter {
    @Override
    public void v(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, message);
        }
    }

    @Override
    public void d(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }

    @Override
    public void i(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message);
        }
    }

    @Override
    public void w(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, message);
        }
    }

    @Override
    public void e(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    public void wtf(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.wtf(tag, message);
        }
    }
}
```

### Loggerの初期化
Application等において、Loggerを初期化し、MyLogAdapterを設定します。

```java
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Logger.init(getString(R.string.app_name)).logAdapter(new MyLogAdapter());
    }
}
```

### 使ってみる！
```java
Logger.d("Displayed only debug build");
```

下記は、Loggerを使った際の出力例です。
デバッグバージョンのみ出力されます。

![image1](https://github.com/ayakix/Logger/raw/master/images/image1.png)

## サンプル
[Logger@github](https://github.com/ayakix/Logger)に動作するプロジェクトがあります。
