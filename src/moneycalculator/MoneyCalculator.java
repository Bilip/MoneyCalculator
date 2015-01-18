package moneycalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import moneycalculator.control.CalculateCommand;
import moneycalculator.control.Command;
import moneycalculator.view.ActionListenerFactory;
import moneycalculator.view.ApplicationFrame;

public class MoneyCalculator {

    private HashMap<String, Command> commandMap;

    public static void main(String[] args) {
        new MoneyCalculator().execute();
    }

    private void execute() {
        createCommands(createApplicationFrame());
    }

    private void createCommands(ApplicationFrame frame) {
        commandMap = new HashMap<>();
        commandMap.put("Calculate", new CalculateCommand(
                frame.getMoneyDialog(),
                frame.getCurrencyDialog(),
                frame.getMoneyViewer())
        );

        commandMap.put("Exit", new Command() {

            @Override
            public void execute() {
                System.exit(0);
            }

        });
    }

    private ApplicationFrame createApplicationFrame() {

        return new ApplicationFrame(new ActionListenerFactory() {

            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }

        });

    }
}
