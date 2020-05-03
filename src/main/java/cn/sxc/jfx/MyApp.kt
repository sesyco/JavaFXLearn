package cn.sxc.jfx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class MyApp : Application() {

    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("/fxml/scene.fxml"))
        val scene = Scene(root)
        scene.stylesheets.add(javaClass.getResource("/css/styles.css").toExternalForm())

        primaryStage.title = "JavaFX and Gradle"
        primaryStage.scene = scene
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}