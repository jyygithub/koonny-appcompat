<h2 align="center">
  Android通用Core
</h2>
<p align="center">
  <a href="https://github.com/jyygithub/koonny-appcompat" target="_blank">
    <img src="https://img.shields.io/badge/min--sdk-21+-%23A97BFF" alt="minSdk">
    <img alt="Maven Central" src="https://img.shields.io/maven-central/v/jyygithub/koonny-appcompat">
    <img alt="GitHub" src="https://img.shields.io/github/license/jyygithub/koonny-appcompat">
    <img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/jyygithub/koonny-appcompat">
    <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/jyygithub/koonny-appcompat">
  </a>
</p>

## Gradle

```groovy
implementation 'com.koonny.appcompat:appcompat:LATEST_VERSION'
```

## 用法

### BaseActivity/BaseFragment/BaseDialogFragment

```kotlin
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO
    }

}
```

```kotlin
class FirstFragment : BaseFragment<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO
    }

}
```

```kotlin
class DoneDialog : BaseDialogFragment<DialogDoneBinding>(DialogDoneBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO
    }

}
```

### 点击事件

```kotlin
class MainActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button.click {
            // 点击间隔3秒
            // TODO
        }
        button.click(200) {
            // 点击间隔200毫秒
            // TODO
        }
    }
}
```

### 日期工具

```kotlin
// Date、String、Long的格式转换
class MainActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nowMill = NOW_MILLS
        val nowDate = NOW_DATE
        val nowString = NOW_STRING
        val result = NOW_MILLS.toDate().time.formatString("yyyy-MM-dd")
    }
}
```

### 版本号

```kotlin
class MainActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val versionCode = appVersion.versionCode
        val versionName = appVersion.versionName
    }
}
```

### Intent封装

```kotlin
class FirstActivity {
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                putExtra("result", "abc")
            })
    }
}
```

```kotlin
class MainActivity {
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val result by intentString("result")
    }
}
```

### 正则表达式

```kotlin
class MainActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val result = "2132133".isPassword
        val result1 = "sdasd".isPhoneNumber
    }
}
```

### FlowEventBus

```kotlin
FlowEventBus.post("action1", "success")
```

```kotlin
FlowEventBus.subscribe<String>("action1") {
    Log.d("event", it)
}
```

## License

```
Copyright 2023 jyygithub

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
