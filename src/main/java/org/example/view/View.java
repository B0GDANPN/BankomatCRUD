package org.example.view;

public class View {
    private SignupPanel signupPanel;
    private LoginPanel loginPanel;
    private TransactionPanel transactionPanel;
    private DepositPanel depositPanel;
    private WithdrawPanel withdrawPanel;
    private BalancePanel balancePanel;
    private HistoryPanel historyPanel;
    private PinPanel pinPanel;

    private final SignupListener signupListener;
    private final LoginListener loginListener;
    private final TransactionListener transactionsListener;
    private final DepositListener depositListener;
    private final HistoryListener historyListener;
    private final WithdrawListener withdrawListener;
    private final BalanceListener balanceListener;
    private final PinListener pinListener;

    public View(SignupListener signupListener, LoginListener loginListener, TransactionListener transactionListener, DepositListener depositListener, HistoryListener historyListener, WithdrawListener withdrawListener, BalanceListener balanceListener, PinListener pinListener) {
        this.depositListener = depositListener;
        this.signupListener = signupListener;
        this.loginListener = loginListener;
        this.transactionsListener = transactionListener;
        this.historyListener = historyListener;
        this.withdrawListener = withdrawListener;
        this.balanceListener = balanceListener;
        this.pinListener = pinListener;
    }

    public void runLogin() {
        loginPanel = new LoginPanel(loginListener);
        loginPanel.runLogin();
        showLoginPanel();
    }

    public void runSignup() {
        signupPanel = new SignupPanel(signupListener);
        signupPanel.runSignUp();
        showSignupPanel();
    }

    public void showSignupPanel() {
        signupPanel.setVisible(true);
    }

    public void hideSignupPanel() {
        signupPanel.setVisible(false);
    }

    public void hideLoginPanel() {
        loginPanel.setVisible(false);
    }

    public void showLoginPanel() {
        loginPanel.setVisible(true);
    }

    public void clearLoginPanel() {
        loginPanel.clear();
    }

    public void runTransactionPanel(String cardNumber) {
        transactionPanel = new TransactionPanel(transactionsListener);
        transactionPanel.runTransaction(cardNumber);
        showTransactionPanel();
    }

    public void showTransactionPanel() {
        transactionPanel.setVisible(true);
    }

    public void hideTransactionPanel() {
        transactionPanel.setVisible(false);
    }

    public void runCashDeposit(String cardNumber) {
        depositPanel = new DepositPanel(depositListener);
        depositPanel.runDeposit(cardNumber);
        showDepositPanel();
    }

    public void showDepositPanel() {
        depositPanel.setVisible(true);
    }

    public void hideDepositPanel() {
        depositPanel.setVisible(false);
    }

    public void runHistory(String cardNumber) {
        historyPanel = new HistoryPanel(historyListener);
        historyPanel.runHistory(cardNumber);
        showHistoryPanel();
    }

    public void showHistoryPanel() {
        historyPanel.setVisible(true);
    }

    public void hideHistoryPanel() {
        historyPanel.setVisible(false);
    }

    public void runCashWithdraw(String cardnumber) {
        withdrawPanel = new WithdrawPanel(withdrawListener);
        withdrawPanel.runWithdraw(cardnumber);
        showWithdrawPanel();
    }

    public void showWithdrawPanel() {
        withdrawPanel.setVisible(true);
    }

    public void hideWithdrawPanel() {
        withdrawPanel.setVisible(false);
    }


    public void runBalance(String cardNumber) {
        balancePanel = new BalancePanel(balanceListener);
        balancePanel.runBalance(cardNumber);
        showBalancePanel();
    }

    public void showBalancePanel() {
        balancePanel.setVisible(true);
    }

    public void hideBalancePanel() {
        balancePanel.setVisible(false);
    }
    public void runChangePin(String cardNumber) {
        pinPanel = new PinPanel(pinListener);
        pinPanel.runChangePin(cardNumber);
        showPinPanel();
    }

    public void showPinPanel() {
        pinPanel.setVisible(true);
    }
    public void hidePinPanel() {
        pinPanel.setVisible(false);
    }
}
