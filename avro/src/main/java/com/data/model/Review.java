/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.data.model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Review extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Review\",\"namespace\":\"com.data.model\",\"fields\":[{\"name\":\"listingId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"date\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"reviewId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"reviewName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String listingId;
  @Deprecated public java.lang.String id;
  @Deprecated public java.lang.String date;
  @Deprecated public java.lang.String reviewId;
  @Deprecated public java.lang.String reviewName;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Review() {}

  /**
   * All-args constructor.
   */
  public Review(java.lang.String listingId, java.lang.String id, java.lang.String date, java.lang.String reviewId, java.lang.String reviewName) {
    this.listingId = listingId;
    this.id = id;
    this.date = date;
    this.reviewId = reviewId;
    this.reviewName = reviewName;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return listingId;
    case 1: return id;
    case 2: return date;
    case 3: return reviewId;
    case 4: return reviewName;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: listingId = (java.lang.String)value$; break;
    case 1: id = (java.lang.String)value$; break;
    case 2: date = (java.lang.String)value$; break;
    case 3: reviewId = (java.lang.String)value$; break;
    case 4: reviewName = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'listingId' field.
   */
  public java.lang.String getListingId() {
    return listingId;
  }

  /**
   * Sets the value of the 'listingId' field.
   * @param value the value to set.
   */
  public void setListingId(java.lang.String value) {
    this.listingId = value;
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'date' field.
   */
  public java.lang.String getDate() {
    return date;
  }

  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(java.lang.String value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'reviewId' field.
   */
  public java.lang.String getReviewId() {
    return reviewId;
  }

  /**
   * Sets the value of the 'reviewId' field.
   * @param value the value to set.
   */
  public void setReviewId(java.lang.String value) {
    this.reviewId = value;
  }

  /**
   * Gets the value of the 'reviewName' field.
   */
  public java.lang.String getReviewName() {
    return reviewName;
  }

  /**
   * Sets the value of the 'reviewName' field.
   * @param value the value to set.
   */
  public void setReviewName(java.lang.String value) {
    this.reviewName = value;
  }

  /** Creates a new Review RecordBuilder */
  public static com.data.model.Review.Builder newBuilder() {
    return new com.data.model.Review.Builder();
  }
  
  /** Creates a new Review RecordBuilder by copying an existing Builder */
  public static com.data.model.Review.Builder newBuilder(com.data.model.Review.Builder other) {
    return new com.data.model.Review.Builder(other);
  }
  
  /** Creates a new Review RecordBuilder by copying an existing Review instance */
  public static com.data.model.Review.Builder newBuilder(com.data.model.Review other) {
    return new com.data.model.Review.Builder(other);
  }
  
  /**
   * RecordBuilder for Review instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Review>
    implements org.apache.avro.data.RecordBuilder<Review> {

    private java.lang.String listingId;
    private java.lang.String id;
    private java.lang.String date;
    private java.lang.String reviewId;
    private java.lang.String reviewName;

    /** Creates a new Builder */
    private Builder() {
      super(com.data.model.Review.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.data.model.Review.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.listingId)) {
        this.listingId = data().deepCopy(fields()[0].schema(), other.listingId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.date)) {
        this.date = data().deepCopy(fields()[2].schema(), other.date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.reviewId)) {
        this.reviewId = data().deepCopy(fields()[3].schema(), other.reviewId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.reviewName)) {
        this.reviewName = data().deepCopy(fields()[4].schema(), other.reviewName);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Review instance */
    private Builder(com.data.model.Review other) {
            super(com.data.model.Review.SCHEMA$);
      if (isValidValue(fields()[0], other.listingId)) {
        this.listingId = data().deepCopy(fields()[0].schema(), other.listingId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.date)) {
        this.date = data().deepCopy(fields()[2].schema(), other.date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.reviewId)) {
        this.reviewId = data().deepCopy(fields()[3].schema(), other.reviewId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.reviewName)) {
        this.reviewName = data().deepCopy(fields()[4].schema(), other.reviewName);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'listingId' field */
    public java.lang.String getListingId() {
      return listingId;
    }
    
    /** Sets the value of the 'listingId' field */
    public com.data.model.Review.Builder setListingId(java.lang.String value) {
      validate(fields()[0], value);
      this.listingId = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'listingId' field has been set */
    public boolean hasListingId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'listingId' field */
    public com.data.model.Review.Builder clearListingId() {
      listingId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'id' field */
    public java.lang.String getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.data.model.Review.Builder setId(java.lang.String value) {
      validate(fields()[1], value);
      this.id = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'id' field */
    public com.data.model.Review.Builder clearId() {
      id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'date' field */
    public java.lang.String getDate() {
      return date;
    }
    
    /** Sets the value of the 'date' field */
    public com.data.model.Review.Builder setDate(java.lang.String value) {
      validate(fields()[2], value);
      this.date = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'date' field has been set */
    public boolean hasDate() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'date' field */
    public com.data.model.Review.Builder clearDate() {
      date = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'reviewId' field */
    public java.lang.String getReviewId() {
      return reviewId;
    }
    
    /** Sets the value of the 'reviewId' field */
    public com.data.model.Review.Builder setReviewId(java.lang.String value) {
      validate(fields()[3], value);
      this.reviewId = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'reviewId' field has been set */
    public boolean hasReviewId() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'reviewId' field */
    public com.data.model.Review.Builder clearReviewId() {
      reviewId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'reviewName' field */
    public java.lang.String getReviewName() {
      return reviewName;
    }
    
    /** Sets the value of the 'reviewName' field */
    public com.data.model.Review.Builder setReviewName(java.lang.String value) {
      validate(fields()[4], value);
      this.reviewName = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'reviewName' field has been set */
    public boolean hasReviewName() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'reviewName' field */
    public com.data.model.Review.Builder clearReviewName() {
      reviewName = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public Review build() {
      try {
        Review record = new Review();
        record.listingId = fieldSetFlags()[0] ? this.listingId : (java.lang.String) defaultValue(fields()[0]);
        record.id = fieldSetFlags()[1] ? this.id : (java.lang.String) defaultValue(fields()[1]);
        record.date = fieldSetFlags()[2] ? this.date : (java.lang.String) defaultValue(fields()[2]);
        record.reviewId = fieldSetFlags()[3] ? this.reviewId : (java.lang.String) defaultValue(fields()[3]);
        record.reviewName = fieldSetFlags()[4] ? this.reviewName : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}