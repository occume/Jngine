// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package org.jngine.net.packet;

public final class Game {
  private Game() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registry.add(org.jngine.net.packet.Game.login);
  }
  public interface PacketOrBuilder extends
      com.google.protobuf.GeneratedMessage.
          ExtendableMessageOrBuilder<Packet> {

    // required int32 cmdId = 1;
    /**
     * <code>required int32 cmdId = 1;</code>
     */
    boolean hasCmdId();
    /**
     * <code>required int32 cmdId = 1;</code>
     */
    int getCmdId();
  }
  /**
   * Protobuf type {@code Game.Packet}
   */
  public static final class Packet extends
      com.google.protobuf.GeneratedMessage.ExtendableMessage<
        Packet> implements PacketOrBuilder {
    // Use Packet.newBuilder() to construct.
    private Packet(com.google.protobuf.GeneratedMessage.ExtendableBuilder<org.jngine.net.packet.Game.Packet, ?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Packet(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Packet defaultInstance;
    public static Packet getDefaultInstance() {
      return defaultInstance;
    }

    public Packet getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Packet(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
//      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              cmdId_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.jngine.net.packet.Game.internal_static_Game_Packet_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.jngine.net.packet.Game.internal_static_Game_Packet_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.jngine.net.packet.Game.Packet.class, org.jngine.net.packet.Game.Packet.Builder.class);
    }

    public static com.google.protobuf.Parser<Packet> PARSER =
        new com.google.protobuf.AbstractParser<Packet>() {
      public Packet parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Packet(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Packet> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 cmdId = 1;
    public static final int CMDID_FIELD_NUMBER = 1;
    private int cmdId_;
    /**
     * <code>required int32 cmdId = 1;</code>
     */
    public boolean hasCmdId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 cmdId = 1;</code>
     */
    public int getCmdId() {
      return cmdId_;
    }

    private void initFields() {
      cmdId_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasCmdId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!extensionsAreInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      com.google.protobuf.GeneratedMessage
        .ExtendableMessage<org.jngine.net.packet.Game.Packet>.ExtensionWriter extensionWriter =
          newExtensionWriter();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, cmdId_);
      }
      extensionWriter.writeUntil(536870912, output);
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, cmdId_);
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static org.jngine.net.packet.Game.Packet parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.jngine.net.packet.Game.Packet parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.jngine.net.packet.Game.Packet parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.jngine.net.packet.Game.Packet parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.jngine.net.packet.Game.Packet parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static org.jngine.net.packet.Game.Packet parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static org.jngine.net.packet.Game.Packet parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static org.jngine.net.packet.Game.Packet parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static org.jngine.net.packet.Game.Packet parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static org.jngine.net.packet.Game.Packet parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(org.jngine.net.packet.Game.Packet prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Game.Packet}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.ExtendableBuilder<
          org.jngine.net.packet.Game.Packet, Builder> implements org.jngine.net.packet.Game.PacketOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.jngine.net.packet.Game.internal_static_Game_Packet_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.jngine.net.packet.Game.internal_static_Game_Packet_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.jngine.net.packet.Game.Packet.class, org.jngine.net.packet.Game.Packet.Builder.class);
      }

      // Construct using org.jngine.net.packet.Game.Packet.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        cmdId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.jngine.net.packet.Game.internal_static_Game_Packet_descriptor;
      }

      public org.jngine.net.packet.Game.Packet getDefaultInstanceForType() {
        return org.jngine.net.packet.Game.Packet.getDefaultInstance();
      }

      public org.jngine.net.packet.Game.Packet build() {
        org.jngine.net.packet.Game.Packet result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public org.jngine.net.packet.Game.Packet buildPartial() {
        org.jngine.net.packet.Game.Packet result = new org.jngine.net.packet.Game.Packet(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.cmdId_ = cmdId_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.jngine.net.packet.Game.Packet) {
          return mergeFrom((org.jngine.net.packet.Game.Packet)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.jngine.net.packet.Game.Packet other) {
        if (other == org.jngine.net.packet.Game.Packet.getDefaultInstance()) return this;
        if (other.hasCmdId()) {
          setCmdId(other.getCmdId());
        }
        this.mergeExtensionFields(other);
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasCmdId()) {
          
          return false;
        }
        if (!extensionsAreInitialized()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        org.jngine.net.packet.Game.Packet parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.jngine.net.packet.Game.Packet) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 cmdId = 1;
      private int cmdId_ ;
      /**
       * <code>required int32 cmdId = 1;</code>
       */
      public boolean hasCmdId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 cmdId = 1;</code>
       */
      public int getCmdId() {
        return cmdId_;
      }
      /**
       * <code>required int32 cmdId = 1;</code>
       */
      public Builder setCmdId(int value) {
        bitField0_ |= 0x00000001;
        cmdId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 cmdId = 1;</code>
       */
      public Builder clearCmdId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        cmdId_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Game.Packet)
    }

    static {
      defaultInstance = new Packet(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Game.Packet)
  }

  public interface LoginOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string user = 1;
    /**
     * <code>required string user = 1;</code>
     */
    boolean hasUser();
    /**
     * <code>required string user = 1;</code>
     */
    java.lang.String getUser();
    /**
     * <code>required string user = 1;</code>
     */
    com.google.protobuf.ByteString
        getUserBytes();

    // required string pswd = 2;
    /**
     * <code>required string pswd = 2;</code>
     */
    boolean hasPswd();
    /**
     * <code>required string pswd = 2;</code>
     */
    java.lang.String getPswd();
    /**
     * <code>required string pswd = 2;</code>
     */
    com.google.protobuf.ByteString
        getPswdBytes();
  }
  /**
   * Protobuf type {@code Game.Login}
   */
  public static final class Login extends
      com.google.protobuf.GeneratedMessage
      implements LoginOrBuilder {
    // Use Login.newBuilder() to construct.
    private Login(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Login(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Login defaultInstance;
    public static Login getDefaultInstance() {
      return defaultInstance;
    }

    public Login getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Login(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
//      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              user_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              pswd_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.jngine.net.packet.Game.internal_static_Game_Login_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.jngine.net.packet.Game.internal_static_Game_Login_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.jngine.net.packet.Game.Login.class, org.jngine.net.packet.Game.Login.Builder.class);
    }

    public static com.google.protobuf.Parser<Login> PARSER =
        new com.google.protobuf.AbstractParser<Login>() {
      public Login parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Login(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Login> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string user = 1;
    public static final int USER_FIELD_NUMBER = 1;
    private java.lang.Object user_;
    /**
     * <code>required string user = 1;</code>
     */
    public boolean hasUser() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string user = 1;</code>
     */
    public java.lang.String getUser() {
      java.lang.Object ref = user_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          user_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string user = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUserBytes() {
      java.lang.Object ref = user_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        user_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string pswd = 2;
    public static final int PSWD_FIELD_NUMBER = 2;
    private java.lang.Object pswd_;
    /**
     * <code>required string pswd = 2;</code>
     */
    public boolean hasPswd() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string pswd = 2;</code>
     */
    public java.lang.String getPswd() {
      java.lang.Object ref = pswd_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          pswd_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string pswd = 2;</code>
     */
    public com.google.protobuf.ByteString
        getPswdBytes() {
      java.lang.Object ref = pswd_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pswd_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      user_ = "";
      pswd_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasUser()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasPswd()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getUserBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getPswdBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getUserBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getPswdBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static org.jngine.net.packet.Game.Login parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.jngine.net.packet.Game.Login parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.jngine.net.packet.Game.Login parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.jngine.net.packet.Game.Login parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.jngine.net.packet.Game.Login parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static org.jngine.net.packet.Game.Login parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static org.jngine.net.packet.Game.Login parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static org.jngine.net.packet.Game.Login parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static org.jngine.net.packet.Game.Login parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static org.jngine.net.packet.Game.Login parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(org.jngine.net.packet.Game.Login prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Game.Login}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements org.jngine.net.packet.Game.LoginOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.jngine.net.packet.Game.internal_static_Game_Login_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.jngine.net.packet.Game.internal_static_Game_Login_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.jngine.net.packet.Game.Login.class, org.jngine.net.packet.Game.Login.Builder.class);
      }

      // Construct using org.jngine.net.packet.Game.Login.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        user_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        pswd_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.jngine.net.packet.Game.internal_static_Game_Login_descriptor;
      }

      public org.jngine.net.packet.Game.Login getDefaultInstanceForType() {
        return org.jngine.net.packet.Game.Login.getDefaultInstance();
      }

      public org.jngine.net.packet.Game.Login build() {
        org.jngine.net.packet.Game.Login result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public org.jngine.net.packet.Game.Login buildPartial() {
        org.jngine.net.packet.Game.Login result = new org.jngine.net.packet.Game.Login(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.user_ = user_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.pswd_ = pswd_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.jngine.net.packet.Game.Login) {
          return mergeFrom((org.jngine.net.packet.Game.Login)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.jngine.net.packet.Game.Login other) {
        if (other == org.jngine.net.packet.Game.Login.getDefaultInstance()) return this;
        if (other.hasUser()) {
          bitField0_ |= 0x00000001;
          user_ = other.user_;
          onChanged();
        }
        if (other.hasPswd()) {
          bitField0_ |= 0x00000002;
          pswd_ = other.pswd_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasUser()) {
          
          return false;
        }
        if (!hasPswd()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        org.jngine.net.packet.Game.Login parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.jngine.net.packet.Game.Login) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string user = 1;
      private java.lang.Object user_ = "";
      /**
       * <code>required string user = 1;</code>
       */
      public boolean hasUser() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string user = 1;</code>
       */
      public java.lang.String getUser() {
        java.lang.Object ref = user_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          user_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string user = 1;</code>
       */
      public com.google.protobuf.ByteString
          getUserBytes() {
        java.lang.Object ref = user_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          user_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string user = 1;</code>
       */
      public Builder setUser(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        user_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string user = 1;</code>
       */
      public Builder clearUser() {
        bitField0_ = (bitField0_ & ~0x00000001);
        user_ = getDefaultInstance().getUser();
        onChanged();
        return this;
      }
      /**
       * <code>required string user = 1;</code>
       */
      public Builder setUserBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        user_ = value;
        onChanged();
        return this;
      }

      // required string pswd = 2;
      private java.lang.Object pswd_ = "";
      /**
       * <code>required string pswd = 2;</code>
       */
      public boolean hasPswd() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string pswd = 2;</code>
       */
      public java.lang.String getPswd() {
        java.lang.Object ref = pswd_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          pswd_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string pswd = 2;</code>
       */
      public com.google.protobuf.ByteString
          getPswdBytes() {
        java.lang.Object ref = pswd_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pswd_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string pswd = 2;</code>
       */
      public Builder setPswd(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        pswd_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string pswd = 2;</code>
       */
      public Builder clearPswd() {
        bitField0_ = (bitField0_ & ~0x00000002);
        pswd_ = getDefaultInstance().getPswd();
        onChanged();
        return this;
      }
      /**
       * <code>required string pswd = 2;</code>
       */
      public Builder setPswdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        pswd_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Game.Login)
    }

    static {
      defaultInstance = new Login(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Game.Login)
  }

  public static final int LOGIN_FIELD_NUMBER = 100;
  /**
   * <code>extend .Game.Packet { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      org.jngine.net.packet.Game.Packet,
      org.jngine.net.packet.Game.Login> login = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        org.jngine.net.packet.Game.Login.class,
        org.jngine.net.packet.Game.Login.getDefaultInstance());
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Game_Packet_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Game_Packet_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Game_Login_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Game_Login_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rmessage.proto\022\004Game\"!\n\006Packet\022\r\n\005cmdId" +
      "\030\001 \002(\005*\010\010d\020\200\200\200\200\002\"#\n\005Login\022\014\n\004user\030\001 \002(\t\022" +
      "\014\n\004pswd\030\002 \002(\t:(\n\005login\022\014.Game.Packet\030d \001" +
      "(\0132\013.Game.LoginB\035\n\025org.jngine.net.packet" +
      "B\004Game"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_Game_Packet_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_Game_Packet_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Game_Packet_descriptor,
              new java.lang.String[] { "CmdId", });
          internal_static_Game_Login_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_Game_Login_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Game_Login_descriptor,
              new java.lang.String[] { "User", "Pswd", });
          login.internalInit(descriptor.getExtensions().get(0));
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
