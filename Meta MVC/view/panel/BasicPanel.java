package view.panel;

import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class BasicPanel extends JPanel { // 이거 아래로 내려야 했는데 ㅠㅠ
	
	// Initialize Time Use
	public abstract void addComponent(JComponent comp);
	public abstract void addBackButton(ActionListener actionListener);
	public abstract void addEmptyToolSpace();
}
