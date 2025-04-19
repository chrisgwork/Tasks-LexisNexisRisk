package com.actions.drivers.interfaces;

import com.actions.drivers.utils.Driver;

public interface Uploadable<T extends Driver<T>> {
    default T upload(String fileName) {
        return upload(fileName, null);
    }

    @SuppressWarnings("unchecked")
    default T upload(String fileName, Integer index) {
        ClassLoader classLoader = getClass().getClassLoader();
        java.io.File file = new java.io.File(classLoader.getResource("data/uploadFiles/" + fileName).getFile());
        String fileToUpload = file.getAbsolutePath();

        if (!(this instanceof Driver<?> driver)) {
            throw new IllegalStateException("Uploadable must be a Driver");
        }

        driver.waitTillVisible();
        driver.waitTillEnabled();
        driver.getElement(index).sendKeys(fileToUpload);

        return (T) driver;
    }
}
