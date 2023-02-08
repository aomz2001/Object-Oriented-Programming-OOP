import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Exam1 {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;


	public static void main(String[] args) {
		try {
			Exam1 window = new Exam1();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private double GrandTO(double grandTotal) {
		return (grandTotal*100)/107;
	}

	private double GrandTO(double Price1, double Price2) {
			
		return Price1 + Price2;
	}
	
	protected void createContents() {
		shell = new Shell();
		shell.setSize(468, 470);
		shell.setText("SWT Application");
		
		Label Calculator = new Label(shell, SWT.NONE);
		Calculator.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		Calculator.setBounds(151, 22, 154, 30);
		Calculator.setText("VAT 7% CALCULATOR ");
		
		Label price1 = new Label(shell, SWT.NONE);
		price1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		price1.setBounds(86, 74, 114, 30);
		price1.setText("ราคาสินค้าชิ้นที่ 1 :");
		
		Label price2 = new Label(shell, SWT.NONE);
		price2.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		price2.setBounds(88, 124, 119, 30);
		price2.setText("ราคาสินค้าชิ้นที่ 2 :");
		
		Label grandtotal = new Label(shell, SWT.NONE);
		grandtotal.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		grandtotal.setBounds(117, 170, 95, 30);
		grandtotal.setText("ราคารวมสุทธิ :");
		
		Label pricebefore = new Label(shell, SWT.NONE);
		pricebefore.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		pricebefore.setBounds(88, 219, 119, 30);
		pricebefore.setText("ราคาก่อนรวมภาษี :");
		
		Label vat = new Label(shell, SWT.NONE);
		vat.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		vat.setBounds(44, 267, 163, 30);
		vat.setText("ภาษีมูลค่าเพิ่ม (VAT 7%) :");
		
		//=====================================================================================
		
		text = new Text(shell, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text.setBounds(212, 71, 154, 35);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text_1.setBounds(212, 119, 154, 35);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text_2.setBounds(212, 165, 154, 35);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text_3.setBounds(212, 214, 154, 35);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text_4.setBounds(213, 262, 154, 35);
		
		//=====================================================================================
		
		
		
		Button Buttoncal = new Button(shell, SWT.NONE);
		Buttoncal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double Price1 = Double.parseDouble(text.getText());
				double Price2 = Double.parseDouble(text_1.getText());

				double GrandTotal = GrandTO(Price1,Price2);
				double PriceBefore = GrandTO(GrandTotal);
				double Vat = GrandTotal - PriceBefore;//GrandTO(GrandTotal,PriceBefore);
				
				String CalGrandTotal = String.format("%.2f", Math.abs(GrandTotal));
				String CalPriceBefore = String.format("%.2f", Math.abs(PriceBefore));
				String CalVat = String.format("%.2f", Math.abs(Vat));
				text_2.setText(CalGrandTotal);
				text_3.setText(CalPriceBefore);
				text_4.setText(CalVat);
			}

			
		});
		Buttoncal.setText("คำนวณ");
		Buttoncal.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		Buttoncal.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		Buttoncal.setBounds(131, 326, 70, 70);
		
		Button Buttonreset = new Button(shell, SWT.NONE);
		Buttonreset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
				text_2.setText("");
				text_3.setText("");
				text_4.setText("");
			}
		});
		Buttonreset.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		Buttonreset.setText("รีเซ็ทค่า");
		Buttonreset.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		Buttonreset.setBounds(245, 326, 70, 70);
		
		//=====================================================================================
		
		Label bath1 = new Label(shell, SWT.NONE);
		bath1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		bath1.setBounds(374, 74, 31, 30);
		bath1.setText("บาท");
		
		Label bath2 = new Label(shell, SWT.NONE);
		bath2.setText("บาท");
		bath2.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		bath2.setBounds(374, 124, 31, 30);
		
		Label bath3 = new Label(shell, SWT.NONE);
		bath3.setText("บาท");
		bath3.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		bath3.setBounds(374, 170, 31, 30);
		
		Label bath4 = new Label(shell, SWT.NONE);
		bath4.setText("บาท");
		bath4.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		bath4.setBounds(374, 219, 31, 30);
		
		Label bath5 = new Label(shell, SWT.NONE);
		bath5.setText("บาท");
		bath5.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		bath5.setBounds(374, 267, 31, 30);
		
		

	}
	
}
