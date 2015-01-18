package moneycalculator.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.model.Currency;

public class CurrencyViewerPanel extends JPanel implements CurrencyViewer {

    private JLabel label;

    private JLabel createCurrencyDisplay() {
        return new JLabel();
    }

    public void createComponents() {
        this.add(createCurrencyDisplay());
    }

    @Override
    public void show(Currency currency) {
        label.setText(currency.toString());
    }
}
