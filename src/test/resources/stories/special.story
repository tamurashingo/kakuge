Scenario: プレイヤーがRYUのときのHADOKENの確認

Given プレイヤーはRYU
When 0フレーム経過
When レバーを下
When 1フレーム経過
When レバーを右下
When 2フレーム経過
When レバーを右
When 3フレーム経過
When ボタンを弱パンチ
When 4フレーム経過
Then 状態がHADOKEN


Scenario: プレイヤーがRYUのときのSHORYUKENの確認

Given プレイヤーはRYU
When 0フレーム経過
When レバーを右
When 1フレーム経過
When レバーを下
When 2フレーム経過
When レバーを右下
When 3フレーム経過
When ボタンを中パンチ
When 4フレーム経過
Then 状態がSHORYUKEN

