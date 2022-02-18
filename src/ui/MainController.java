package ui;

import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {
	
		private boolean toRestart=false;
	
		@FXML
	    private TextArea historialTA;

	    @FXML
	    private TextArea operationTA;

	    @FXML
	    private Button sevenBTN;

	    @FXML
	    private Button fourBTN;

	    @FXML
	    private Button oneBTN;

	    @FXML
	    private Button zeroBTN;

	    @FXML
	    private TextArea solutionTA;

	    @FXML
	    private Button eightBTN;

	    @FXML
	    private Button fiveBTN;

	    @FXML
	    private Button twoBTN;

	    @FXML
	    private Button solutionBTN;

	    @FXML
	    private Button nineBTN;

	    @FXML
	    private Button sixBTN;

	    @FXML
	    private Button threeBTN;

	    @FXML
	    private Button sumBTN;

	    @FXML
	    private Button substBTN;

	    @FXML
	    private Button multBTN;
	    
	    @FXML
	    void delete(ActionEvent event) {
	    	
	    	String problem=operationTA.getText();
	    	String nwProblem="";
	    	if(problem.length()!=0)
	    	{
	    		for(int i=0;i<problem.length()-1;i++) {
	    			nwProblem+=problem.charAt(i);
	    		}
	    	}
	    	operationTA.setText(nwProblem);
	    }
	    
	    @FXML
	    void solveBTN(ActionEvent event) {
	    	
	    	String problem=operationTA.getText();
	    	String historial=problem+"=";
	    	int total=0, x=0, y=0;
	    	StringTokenizer sum=new StringTokenizer(problem,"+");
	    	StringTokenizer subs=new StringTokenizer(problem,"-");
	    	StringTokenizer mult=new StringTokenizer(problem,"*");
	    	if(sum.countTokens()!=1) {
	    		x=Integer.parseInt(sum.nextToken());
	    		y=Integer.parseInt(sum.nextToken());
	    		total=x+y;
	    		historial+=total+"\n\n";
		    	solutionTA.setText(""+total);
		    	historialTA.appendText(historial);
		    	toRestart=true;
	    	}else if(subs.countTokens()!=1) {
	    		x=Integer.parseInt(subs.nextToken());
	    		y=Integer.parseInt(subs.nextToken());
	    		total=x-y;
	    		historial+=total+"\n\n";
		    	solutionTA.setText(""+total);
		    	historialTA.appendText(historial);
		    	toRestart=true;
	    	}else if(mult.countTokens()!=1) {
	    		x=Integer.parseInt(mult.nextToken());
	    		y=Integer.parseInt(mult.nextToken());
	    		total=x*y;
	    		historial+=total+"\n\n";
		    	solutionTA.setText(""+total);
		    	historialTA.appendText(historial);
		    	toRestart=true;
	    	}
	    }

	    @FXML
	    void writeSymbol(ActionEvent event){
	    	
	    	Button pressedBTN=(Button)event.getSource();
	    	String problem=operationTA.getText();
	    	
	    	if(toRestart) {
	    		solutionTA.clear();
	    		operationTA.clear();
	    		toRestart=false;
	    	}
	    	
	    	if(pressedBTN==sumBTN || pressedBTN==substBTN || pressedBTN==multBTN)
	    	{
	    		if(problem.length()!=0) {
	    			boolean repeated=false;
	    			for(int i=0;i<problem.length();i++) {
	    				if(!(problem.charAt(i)>='0' && problem.charAt(i)<='9')) {
	    					repeated=true;
	    					break;
	    				}
	    			}
	    			if(!repeated) {
	    				operationTA.appendText(pressedBTN.getText());
	    			}
	    		}
	    	}else {
	    		operationTA.appendText(pressedBTN.getText());
	    	}
	    	
	    }
}
