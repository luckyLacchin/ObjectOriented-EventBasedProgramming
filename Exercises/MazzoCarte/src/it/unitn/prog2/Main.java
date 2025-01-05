package it.unitn.prog2;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Button button = new Button("Say Hello World!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane(button);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
