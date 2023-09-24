package com.systechafrika.part1.loopingstatements;

import java.util.logging.Logger;

public class LoopingStatement {
    private static final Logger LOGGER = Logger.getLogger(LoopingStatement.class.getName());

    public void forLoopStatement() {
        LOGGER.info("before my loop");
        for (int index = 0; index < 10; index++) {

            LOGGER.info("MY INDEX IS " + index);

        }

    }

    public void whileLoopStatement() {
        int index = 8;
        while (index <= 10) {
            LOGGER.info("MY INDEX IS " + index);
            index++;
        }
    }

    public void doWhileStatement() {
        int index = 0;
        do {
            LOGGER.info("MY INDEX IS " + index);
            index++;
        } while (index <= 10);

    }

    public void breakJumpStatement() {
        LOGGER.info("before my loop");
        for (int index = 0; index < 10; index++) {
            if (index == 5) {
                break;
            }
            LOGGER.info("MY INDEX IS " + index);

        }
        LOGGER.info("After my loop ");

    }

    public void continueJumpStatement() {
        LOGGER.info("before my loop");
        for (int index = 0; index < 10; index++) {
            if (index == 5) {
                continue;
            }
            LOGGER.info("MY INDEX IS " + index);

        }
        LOGGER.info("After my loop ");

    }

    public void returnJumpStatement() {
        LOGGER.info("before my loop");
        for (int index = 0; index < 10; index++) {
            if (index == 4) {
                return;
            }
            LOGGER.info("MY INDEX IS " + index);

        }
        LOGGER.info("After my loop ");

    }

    public static void main(String[] args) {
        LoopingStatement a = new LoopingStatement();
        a.forLoopStatement();
        a.whileLoopStatement();
        a.doWhileStatement();
        a.continueJumpStatement();
        a.breakJumpStatement();
        a.returnJumpStatement();

    }
}
