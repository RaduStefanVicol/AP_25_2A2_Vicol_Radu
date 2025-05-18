public static void main(String[] args) {
    try {
        new GameServer();
    } catch (IOException e) {
        System.err.println("Failed to start server: " + e.getMessage());
    }
}

