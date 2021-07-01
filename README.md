 
# What is StepProgressBar?
- `StepProgressBar` is progressBar for easy display steps
- You can display your step progressbar
- For example, You can show customer's current trade step.
<img src="https://github.com/PRNDcompany/StepProgressBar/blob/master/arts/heydealer_example.png" width="360">
<br/><br/>



## Demo
<img src="https://github.com/PRNDcompany/StepProgressBar/blob/master/arts/screenshot_1.png" width="500">
           
## Setup


### Gradle
[ ![Download](https://api.bintray.com/packages/prnd/maven/stepprogressbar/images/download.svg) ](https://bintray.com/prnd/maven/stepprogressbar/_latestVersion)
[![Maven Central](https://img.shields.io/maven-central/v/kr.co.prnd/stepprogressbar.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22kr.co.prnd%22%20AND%20a:%stepprogressbar%22)
```gradle
dependencies {
    implementation 'kr.co.prnd:stepprogressbar:x.x.x'
    //implementation 'kr.co.prnd:stepprogressbar:1.0.0-alpha1'    
}

```

If you think this library is useful, please press star button at upside. 
<br/>
<img src="https://phaser.io/content/news/2015/09/10000-stars.png" width="200">
<br/><br/>



## How to use
```xml
 <kr.co.prnd.StepProgressBar
        android:layout_width="match_parent"
        android:layout_height="8dp"
        android:layout_marginTop="24dp"
        app:max="10"
        app:step="6"
        app:stepDoneColor="#ff0000"
        app:stepMargin="8dp"
        app:stepUndoneColor="#dedede" />
```
<br/>


## Customize
You can change your `StepProgressBar` attribute programmatically
- `setMax()`
- `setStep()`
- `setStepDoneColor()`
- `setStepUndoneColor()`
- `setStepMargin()`


## License 
 ```code
Copyright 2019 PRNDcompany

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
