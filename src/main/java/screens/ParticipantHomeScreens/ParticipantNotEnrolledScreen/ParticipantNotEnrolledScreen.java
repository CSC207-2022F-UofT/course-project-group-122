package screens.ParticipantHomeScreens.ParticipantNotEnrolledScreen;

import org.jetbrains.annotations.NotNull;
import screens.SetScreenToCenter;
import screens.SetSimpleUserScreenHeader;

import javax.swing.*;
import java.awt.*;

public class ParticipantNotEnrolledScreen extends JFrame {

    public ParticipantNotEnrolledScreen(@NotNull ParticipantNotEnrolledInputData data) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel header = new SetSimpleUserScreenHeader(data.getParticipantID(), data.getViewModel());
        add(header, BorderLayout.NORTH);

        JLabel message = new JLabel("You are not enrolled in a Study", SwingConstants.CENTER);

        add(message, BorderLayout.CENTER);

        setSize(600, 400);
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }

}
