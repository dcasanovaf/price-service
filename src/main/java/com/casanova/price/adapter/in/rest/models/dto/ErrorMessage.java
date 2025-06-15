package com.casanova.price.adapter.in.rest.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The type Error message.
 */
public class ErrorMessage {

  @JsonProperty("apiVersion")
  private String apiVersion;

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("status")
  private String status;

  @JsonProperty("logRef")
  private String logRef;

  @JsonProperty("path")
  private String path;

  @JsonProperty("exception")
  private String exception;

  @JsonProperty("message")
  private String message;

  /**
   * Api version error message.
   *
   * @param apiVersion the api version
   * @return the error message
   */
  public ErrorMessage apiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  /**
   * Gets api version.
   *
   * @return the api version
   */
  @NotNull
  @Schema(name = "apiVersion", example = "1.0.0", description = "API version", required = true)
  public String getApiVersion() {
    return apiVersion;
  }

  /**
   * Sets api version.
   *
   * @param apiVersion the api version
   */
  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  /**
   * Timestamp error message.
   *
   * @param timestamp the timestamp
   * @return the error message
   */
  public ErrorMessage timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Gets timestamp.
   *
   * @return the timestamp
   */
  @NotNull
  @Schema(name = "timestamp",
          example = "2022-07-01T06:57:02.283+00:00",
          description = "Timestamp",
          required = true)
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Sets timestamp.
   *
   * @param timestamp the timestamp
   */
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Status error message.
   *
   * @param status the status
   * @return the error message
   */
  public ErrorMessage status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  @NotNull
  @Schema(name = "status", description = "HTTP code status", required = true)
  public String getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Log ref error message.
   *
   * @param logRef the log ref
   * @return the error message
   */
  public ErrorMessage logRef(String logRef) {
    this.logRef = logRef;
    return this;
  }

  /**
   * Gets log ref.
   *
   * @return the log ref
   */
  @Schema(name = "logRef",
          example = "a6f00445-bcb7-4858-a493-34e982d9b65a",
          description = "Log reference",
          required = false)
  public String getLogRef() {
    return logRef;
  }

  /**
   * Sets log ref.
   *
   * @param logRef the log ref
   */
  public void setLogRef(String logRef) {
    this.logRef = logRef;
  }

  /**
   * Path error message.
   *
   * @param path the path
   * @return the error message
   */
  public ErrorMessage path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Gets path.
   *
   * @return the path
   */
  @NotNull
  @Schema(name = "path", description = "Endpoint path", required = true)
  public String getPath() {
    return path;
  }

  /**
   * Sets path.
   *
   * @param path the path
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * Exception error message.
   *
   * @param exception the exception
   * @return the error message
   */
  public ErrorMessage exception(String exception) {
    this.exception = exception;
    return this;
  }

  /**
   * Gets exception.
   *
   * @return the exception
   */
  @NotNull
  @Schema(name = "exception",
          example = "RuntimeException",
          description = "Exception name",
          required = true)
  public String getException() {
    return exception;
  }

  /**
   * Sets exception.
   *
   * @param exception the exception
   */
  public void setException(String exception) {
    this.exception = exception;
  }

  /**
   * Message error message.
   *
   * @param message the message
   * @return the error message
   */
  public ErrorMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  @NotNull
  @Schema(name = "message", description = "Error description", required = true)
  public String getMessage() {
    return message;
  }

  /**
   * Sets message.
   *
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage errorMessage = (ErrorMessage) o;
    return Objects.equals(this.apiVersion, errorMessage.apiVersion)
      && Objects.equals(this.timestamp, errorMessage.timestamp)
      && Objects.equals(this.status, errorMessage.status)
      && Objects.equals(this.logRef, errorMessage.logRef)
      && Objects.equals(this.path, errorMessage.path)
      && Objects.equals(this.exception, errorMessage.exception)
      && Objects.equals(this.message, errorMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiVersion, timestamp, status, logRef, path, exception, message);
  }

  @Override
  public String toString() {
    String sb = "class ErrorMessage {\n"
                + "    apiVersion: " + toIndentedString(apiVersion) + "\n"
                + "    timestamp: " + toIndentedString(timestamp) + "\n"
                + "    status: " + toIndentedString(status) + "\n"
                + "    logRef: " + toIndentedString(logRef) + "\n"
                + "    path: " + toIndentedString(path) + "\n"
                + "    exception: " + toIndentedString(exception) + "\n"
                + "    message: " + toIndentedString(message) + "\n"
                + "}";
    return sb;
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

