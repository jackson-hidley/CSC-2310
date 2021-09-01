package calculator.MVC;
 
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

 
public class CalculatorModel
{
	private int sum;
	private int number;
	private char opt;

	CalculatorModel()
	{
		sum = 0;
		number = 0;
	}

	public void set(JButton idenifier, JTextField number)
	{
		//this will receive '+' '-' '/' etc
		opt = idenifier.getText().charAt(0);

		//getting value from JTextField and setting it as a integer
		this.number = Integer.parseInt(number.getText());

		calculate(opt);
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public int getSum() {
		return sum;
	}

	private void setSum(int sum) 
	{
		this.sum = sum;
	}

	void calculate(char sign)
	{
		switch(sign)
		{
		case '+':
			sum += number; 
			setSum(sum);
			break;
		case '-':
			sum -= number;
			setSum(sum);
			break;

		case '/':
			sum/= number;
			setSum(sum);
			break;

		case '*':
			sum *= number;
			setSum(sum);
			break;

		case '=':
			setSum(sum);
			break;
		case 'C':
			opt = 0;
			number = 0;
			sum = 0;
			setSum(sum);
			break;
			default: 
		}
	}
}

