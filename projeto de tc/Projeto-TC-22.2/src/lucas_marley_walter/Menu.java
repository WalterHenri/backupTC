package lucas_marley_walter;

import javax.swing.JFileChooser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Menu extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindowControllerInterface.fxml"));
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("JFlap volume 2");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("../images/tittleApp.png")));
        ((MainWindowController)loader.getController()).init(stage);
        stage.show();
    }

    public void run(){
        launch();
    }


    public void minimizar(){
        JFileChooser fileChooser = new JFileChooser("../MinimizadorDeAutomato");
        
        Automato automato = Automato.loadFromJff(getPath(fileChooser));
        //Minimizador.minimizar(automato);
        Automato.saveInJff(getSavePath(fileChooser), automato);
    }

    public void intersectar(){
        JFileChooser fileChooser = new JFileChooser("../MinimizadorDeAutomato");

        Automato automato1 = Automato.loadFromJff(getPath(fileChooser));
        Automato automato2 = Automato.loadFromJff(getPath(fileChooser));
        Automato.saveInJff(getSavePath(fileChooser), Intersecionador.Intersecionar(automato1, automato2));
    }

    public void converter(){

        JFileChooser fileChooser = new JFileChooser("../MinimizadorDeAutomato");
        Automato afn = Automato.loadFromJff(getPath(fileChooser));
        Automato afd = Conversor.converter(afn);
        Automato.saveInJff(getSavePath(fileChooser), afd);

    }

    public void sair(){
        System.out.println("SAINDO");
    }

    static String getPath(JFileChooser fileChooser) {
        if (fileChooser.showOpenDialog(fileChooser) != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        return fileChooser.getSelectedFile().getAbsolutePath();
    }

    static String getSavePath(JFileChooser fileChooser) {
        if (fileChooser.showSaveDialog(fileChooser) != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        return fileChooser.getSelectedFile().getAbsolutePath();
    }


}
