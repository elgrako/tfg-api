package com.api.tfg.exception;

public class ResourceNotFoundException extends CustomException {
  public ResourceNotFoundException(String resourceName, Long id) {
    super(String.format("%s no encontrado/a con ID: %d", resourceName, id));
  }
  public ResourceNotFoundException(String resourceName, String nombre) {
    super(String.format("%s no encontrado/a con ID: %d", resourceName, nombre));
  }
}
