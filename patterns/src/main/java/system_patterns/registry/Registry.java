package system_patterns.registry;

import java.sql.Connection;

public class Registry {
    private static Connection connection;
    private final ProductService productService = new ProductService();
    private final BrandService brandService = new BrandService();
    private final UserService userService = new UserService(connection);
    private Registry() {

    }

    public static Registry getInstance(Connection connection) {
        Registry.connection = connection;
        return new Registry();
    }

    public <T> T findService(String name, Class<T> clazz) {
        switch (name) {
            case "productService":
                return clazz.cast(productService);
            case "brandService":
                return clazz.cast(brandService);
            case "userService":
                return clazz.cast(userService);
            default:
                throw new IllegalArgumentException("Unknown service");
        }
    }
}
