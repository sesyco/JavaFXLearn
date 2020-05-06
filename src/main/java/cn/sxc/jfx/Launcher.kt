/*
 * Copyright (c) 2020. Suo Xuechao. All Rights Reserved.
 */

package cn.sxc.jfx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Screen
import javafx.stage.Stage

/**
 * 自定义Application类 应用入口
 */
class Launcher: Application() {

  override fun init() {
    // init on thread JavaFX-Launcher
    println("init on thread ${Thread.currentThread().name}")
  }

  override fun start(primaryStage: Stage) {
    // start on thread JavaFX Application Thread
    println("start on thread ${Thread.currentThread().name}")

    // 从fxml返回组件容器
    val root = FXMLLoader.load<Parent>(javaClass.getResource("/layout/layout_main.fxml"))
    // 创建一个场景
    val scene = Scene(root)
    // 设置场景的样式
    scene.stylesheets.add(javaClass.getResource("/styles/style_main.css").toExternalForm())
    // Stage 就是一个窗口 可以用primaryStage 也可以自己创建State 调用show显示

    // 设置标题
    primaryStage.title = "JavaFX"
    // 设置icon logo
    primaryStage.icons.add(Image("/image/git-icon.png"))

    // 设置场景 各种组件 内容 都在场景中
    primaryStage.scene = scene

    //    primaryStage.isIconified = true // 设置最小化
    //    primaryStage.isMaximized = true // 设置最大化
    //    primaryStage.isFullScreen = true // 设置全屏
        primaryStage.sizeToScene()  // 根据场景内容 自动调整尺寸
    //    primaryStage.isResizable = true // 设置是否可拉伸
    //    primaryStage.close()  // 关闭

    // 屏幕信息
    val screen = Screen.getPrimary()
    println("screen bounds -> ${screen.bounds}")
    // 可以看到的显示空间
    println("screen visualBounds -> ${screen.visualBounds}")
    println("screen dpi -> ${screen.dpi}")
//    println("screen outputScaleX:${screen.outputScaleX}")

    // 设置宽高  最小 最大 宽高
    //    primaryStage.minWidth = 500.0
    //    primaryStage.minHeight = 500.0
    //    primaryStage.width = 600.0
    //    primaryStage.height = 600.0
    //    primaryStage.maxWidth = 800.0
    //    primaryStage.maxHeight = 800.0

    //    primaryStage.width  // 宽高未设置的话 获取需要放在show之后 否则获取不到有效值

    // 监听高度变化
    //    primaryStage.heightProperty().addListener {_, _, newValue ->
    //      println(newValue.toDouble())
    //    }
    // 监听宽度变化
    //    primaryStage.widthProperty().addListener {_, _, newValue ->
    //      println(newValue.toDouble())
    //    }

    // 设置透明度
    //    primaryStage.opacity = 0.5

    // 设置置顶显示
    //    primaryStage.isAlwaysOnTop = true

    //    primaryStage.owner // 窗口所有者 如果null则为顶级窗口


    //    primaryStage.initOwner() // 传入所属窗口  null为顶级

    //        primaryStage.initStyle(StageStyle.DECORATED) // 白色背景 有装饰 默认
    //    primaryStage.initStyle(StageStyle.TRANSPARENT) // 透明背景 没有装饰
    //    primaryStage.initStyle(StageStyle.UNDECORATED) // 白色背景 没有装饰
    //    primaryStage.initStyle(StageStyle.UNIFIED)
    //    primaryStage.initStyle(StageStyle.UTILITY)



    // 平台相关工具
//    Platform.setImplicitExit(false) // 窗口都关闭后 并不会退出
//    Platform.exit() // 当窗口关闭后 未退出 可调用此方法 退出应用

    primaryStage.show()
    // 送window到后面
    //    primaryStage.toBack()
    // 送window到前面
    //        primaryStage.toFront()


    // 类似Dialog的一种实现  窗口不关闭 所属窗口是无法点击的
//    val stage = Stage(StageStyle.UTILITY)
//    stage.initOwner(primaryStage)
//    stage.initModality(Modality.APPLICATION_MODAL)
//    stage.show()

    // 打开某个网页 使用系统默认浏览器
//    hostServices.showDocument("https://www.baidu.com")

  }

  override fun stop() {
    // stop on thread JavaFX Application Thread
    println("stop on thread ${Thread.currentThread().name}")
  }
}

fun main(args: Array<String>) {
  // 启动应用
  println("call main func")
  Application.launch(Launcher::class.java, *args)
}