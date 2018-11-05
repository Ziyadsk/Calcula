import javafx.application.Application ; 
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.animation.* ; 

public class Calcula extends Application{

	int actualResult = 0  ; 
	String resultMessage = ""; 
	String operation ;
	String[] arr ; 
	Label resultLabel = new Label(Integer.toString(actualResult)) ;
	@Override
	public void start(Stage window){
		
		BorderPane bp = new BorderPane();
	
		resultLabel.setAlignment(Pos.CENTER);

		resultLabel.setPadding(new Insets(10, 10, 50, 20));
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
   		grid.setVgap(10);
   		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setAlignment(Pos.CENTER);
		Button btnOne = new Button("1");
	
		btnOne.setOnAction(e -> {
			setNumber(1);
		});

		Button btnTwo = new Button("2");
			btnTwo.setOnAction(e -> {
			setNumber(2);
		});

		Button btnThree = new Button("3");
			btnThree.setOnAction(e -> {
			setNumber(3);
		});

		Button btnFour  = new Button("4");
			btnFour.setOnAction(e -> {
			setNumber(4);
			
		});

		Button btnFive = new Button("5");
			btnFive.setOnAction(e -> {
			setNumber(5);
		});

		Button btnSix = new Button("6");
			btnSix.setOnAction(e -> {
			setNumber(6);
		});

		Button btnSeven = new Button("7");
			btnSeven.setOnAction(e -> {
			setNumber(7);
		});

		Button btnEight = new Button("8");
			btnEight.setOnAction(e -> {
			setNumber(8);
		});

		Button btnNine = new Button("9");
			btnNine.setOnAction(e -> {
			setNumber(9);
		});

		Button btnZero = new Button("0");
			btnZero.setOnAction(e -> {
			setNumber(0);
		});

		Button btnAdds = new Button("+ ");
			btnAdds.setOnAction(e -> {
			checkIfPreviousOperation("+");
		});

		Button btnMinus = new Button("- ");
			btnMinus.setOnAction(e -> {
			checkIfPreviousOperation("-");
		});
	
	

		Button btnMuls = new Button("x ");
			btnMuls.setOnAction(e -> {
			checkIfPreviousOperation("*");
		});

		Button btnDivs = new Button("/ ");
			btnDivs.setOnAction(e -> {
				checkIfPreviousOperation("/");
		});

		Button btnEquals = new Button("=");
			btnEquals.setOnAction(e -> {
			operation = String.format("\\%s",operation);
			arr = resultMessage.split(operation);
			actualResult = calculate(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),operation);
			resultMessage = Integer.toString(actualResult) ; 
			resultLabel.setText(resultMessage);

		});

		Button btnDecimal = new Button(".");
			btnDecimal.setOnAction(e -> {
			resultMessage += "."; 
			resultLabel.setText(resultMessage);
		});

		Button btnClear = new Button("clear");
		btnClear.setId("btn-clear");
		btnClear.setOnAction(e -> {
			resultMessage = "";
			actualResult = 0 ; 
			resultLabel.setText(Integer.toString(actualResult));
		});
		Button btnDelete = new Button("C");
		btnDelete.setOnAction(e -> {
			resultMessage = resultMessage.substring(0, resultMessage.length() - 1);
			resultLabel.setText(resultMessage);
		});
		HBox hbCenter = new HBox() ; 
		hbCenter.setSpacing(90); 
		hbCenter.getChildren().addAll(btnDelete,btnClear);
		bp.setMargin(hbCenter,new Insets(5,5,5,5));		

		// add the buttons to the grid 
		grid.add(btnOne,0,0);
		grid.add(btnTwo,1,0);
		grid.add(btnThree,2,0);
		grid.add(btnFour,0,1);
		grid.add(btnFive,1,1);
		grid.add(btnSix,2,1);
		grid.add(btnSeven,0,2);
		grid.add(btnEight,1,2);
		grid.add(btnNine,2,2);
		grid.add(btnZero,1,3);
		grid.add(btnAdds,3,0);
		grid.add(btnMinus,3,1);
		grid.add(btnDivs,3,2);
		grid.add(btnMuls,3,3);
		grid.add(btnEquals,2,3);
		grid.add(btnDecimal,0,3);
		bp.setTop(resultLabel);
		bp.setRight(hbCenter);
		bp.setBottom(grid);
		
		Scene s = new Scene(bp);
		s.getStylesheets().add("style.css");
		window.setScene(s);
		window.setResizable(false);
		window.show() ;
	}

	public void setNumber(int number){
			actualResult = number; 
			resultMessage += Integer.toString(actualResult);
			resultLabel.setText(resultMessage);
	}

	public int calculate(int firstOperand,int secondOperand,String operation){
		int result = 0 ; 
		switch(operation){
			case "\\+":
				result = firstOperand + secondOperand;
				break ; 
			case "\\-":
				result = firstOperand - secondOperand;
				break ; 	
			case "\\*":
				result = firstOperand * secondOperand;
				break ; 
			case "\\/":
				result = firstOperand / secondOperand; 
				break ; 
		}

		return result; 
	}

	public void checkIfPreviousOperation(String op){
		if (resultMessage.contains(op)) {
				arr = resultMessage.split("\\"+op);
				actualResult = calculate(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),"\\" + op);
				resultMessage = Integer.toString(actualResult) + op;
				resultLabel.setText(resultMessage);
		}
		else {
				resultMessage += op;
				resultLabel.setText(resultMessage);
				operation = op;
		}
	}
	

}