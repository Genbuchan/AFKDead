# AFKDead

プレイヤーのAFK (Away From Keyboard)を検知し、指定の時間以降まで放置が続いたら自動的にサーバからKickするプラグインです。

## 導入方法

1. `afkdead-0.1.0.jar`をダウンロードし、お使いのMinecraftサーバの`plugins`フォルダに配置する。
2. サーバを起動する。

## 設定項目 (config.yml)

```yaml
timeLimit: 900 # seconds
kickMessage: "AFKのためキックされました。"
```

## Credits

### Special Thanks (偉大な借金王たち)

- [Pokkuma_JPN](https://www.pokkuma.jp/): 名前のアイデア
- [mune0722](https://munesky.net/@mune0722): プラグインのアイデア
