/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author FATEC ZONA LESTE
 */
// The component interface defines operations that can be
// altered by decorators.
// The component interface defines operations that can be
// altered by decorators.
// The component interface defines operations that can be
// altered by decorators.
interface DataSource {
    void writeData(String data);
    String readData();
}

// Concrete components provide default implementations for the
// operations. There might be several variations of these
// classes in a program.
class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        // Write data to file (simulated here with a print statement)
        System.out.println("Writing data to " + filename + ": " + data);
    }

    @Override
    public String readData() {
        // Read data from file (simulated here)
        return "Data from " + filename;
    }
}

// The base decorator class follows the same interface as the
// other components. The primary purpose of this class is to
// define the wrapping interface for all concrete decorators.
abstract class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}

// Concrete decorators must call methods on the wrapped object,
// but may add something of their own to the result.
class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        // 1. Encrypt passed data.
        String encryptedData = "Encrypted(" + data + ")";
        // 2. Pass encrypted data to the wrappee's writeData method.
        wrappee.writeData(encryptedData);
    }

    @Override
    public String readData() {
        // 1. Get data from the wrappee's readData method.
        String data = wrappee.readData();
        // 2. Try to decrypt it if it's encrypted.
        return "Decrypted(" + data + ")";
    }
}

class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        // 1. Compress passed data.
        String compressedData = "Compressed(" + data + ")";
        // 2. Pass compressed data to the wrappee's writeData method.
        wrappee.writeData(compressedData);
    }

    @Override
    public String readData() {
        // 1. Get data from the wrappee's readData method.
        String data = wrappee.readData();
        // 2. Try to decompress it if it's compressed.
        return "Decompressed(" + data + ")";
    }
}

// A simple example of a decorator assembly.
class Application {
    public void dumbUsageExample() {
        DataSource source = new FileDataSource("somefile.dat");
        String salaryRecords = "Salary Records";
        source.writeData(salaryRecords);
        // The target file has been written with plain data.

        source = new CompressionDecorator(source);
        source.writeData(salaryRecords);
        // The target file has been written with compressed data.

        source = new EncryptionDecorator(source);
        // The source variable now contains this:
        // Encryption > Compression > FileDataSource
        source.writeData(salaryRecords);
        // The file has been written with compressed and encrypted data.
    }
}

// Client code that uses an external data source.
class SalaryManager {
    private DataSource source;

    public SalaryManager(DataSource source) {
        this.source = source;
    }

    public String load() {
        return source.readData();
    }

    public void save(String salaryRecords) {
        source.writeData(salaryRecords);
    }
    // ...Other useful methods...
}

// The app can assemble different stacks of decorators at
// runtime, depending on the configuration or environment.
class ApplicationConfigurator {
    public void configurationExample(boolean enabledEncryption, boolean enabledCompression) {
        DataSource source = new FileDataSource("salary.dat");
        if (enabledEncryption) {
            source = new EncryptionDecorator(source);
        }
        if (enabledCompression) {
            source = new CompressionDecorator(source);
        }

        SalaryManager manager = new SalaryManager(source);
        String salary = manager.load();
        System.out.println("Loaded: " + salary);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.dumbUsageExample();

        ApplicationConfigurator configurator = new ApplicationConfigurator();
        configurator.configurationExample(true, true);
    }
}
