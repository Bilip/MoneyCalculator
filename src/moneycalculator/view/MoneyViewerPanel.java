package moneycalculator.view;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.model.Money;

public class MoneyViewerPanel extends JPanel implements MoneyViewer {

    private JLabel label;

    public MoneyViewerPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }

    @Override
    public void show(Money money) {
        label.setText(money.toString());
    }

    private void createComponents() {
        this.add(createMoneyDisplay());
    }

    private JLabel createMoneyDisplay() {
        return new JLabel();
    }

}
