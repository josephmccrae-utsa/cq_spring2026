module edu.utsa.cs3443.codequantumspring2026 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utsa.cs3443.codequantumspring2026 to javafx.fxml;
    exports edu.utsa.cs3443.codequantumspring2026;
    opens model to javafx.fxml;
}