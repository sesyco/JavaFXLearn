package cn.sxc.jfx

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import java.net.URL
import java.util.*

class MainController : Initializable {

    @FXML
    lateinit var label: Label

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        val javaVersion = System.getProperty("java.version")
        val javafxVersion = System.getProperty("javafx.version")
        label.text = "Hello,JavaFX $javafxVersion \nRunning on Java $javaVersion"
    }
}