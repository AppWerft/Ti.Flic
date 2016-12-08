/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/fuerst/Documents/APPC_WORKSPACE/Ti.Flic/android/src/io/flic/lib/IFlicLibInterface.aidl
 */
package io.flic.lib;
public interface IFlicLibInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements io.flic.lib.IFlicLibInterface
{
private static final java.lang.String DESCRIPTOR = "io.flic.lib.IFlicLibInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an io.flic.lib.IFlicLibInterface interface,
 * generating a proxy if needed.
 */
public static io.flic.lib.IFlicLibInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof io.flic.lib.IFlicLibInterface))) {
return ((io.flic.lib.IFlicLibInterface)iin);
}
return new io.flic.lib.IFlicLibInterface.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
io.flic.lib.IFlicLibCallbackInterface _arg0;
_arg0 = io.flic.lib.IFlicLibCallbackInterface.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
long _result = this.registerCallback(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_unregisterCallback:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
this.unregisterCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_listenForConnectionCallbacks:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
this.listenForConnectionCallbacks(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_unListenForConnectionCallbacks:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
this.unListenForConnectionCallbacks(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setButtonCallbacks:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.setButtonCallbacks(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getConnectionStatus:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.getConnectionStatus(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getColor:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _result = this.getColor(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_readRemoteRSSI:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.readRemoteRSSI(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setActiveMode:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.setActiveMode(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_grabExclusivity:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
this.grabExclusivity(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_releaseExclusivity:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
this.releaseExclusivity(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_validateIntent:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
android.os.Bundle _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _result = this.validateIntent(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_listButtons:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.util.List<java.lang.String> _result = this.listButtons(_arg0);
reply.writeNoException();
reply.writeStringList(_result);
return true;
}
case TRANSACTION_removeButton:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
this.removeButton(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_registerListenForBroadcast:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.registerListenForBroadcast(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getName:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _result = this.getName(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements io.flic.lib.IFlicLibInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public long registerCallback(io.flic.lib.IFlicLibCallbackInterface cb, java.lang.String appId, java.lang.String appSecret, java.lang.String appName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
_data.writeString(appId);
_data.writeString(appSecret);
_data.writeString(appName);
mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void unregisterCallback(long id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void listenForConnectionCallbacks(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_listenForConnectionCallbacks, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void unListenForConnectionCallbacks(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_unListenForConnectionCallbacks, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setButtonCallbacks(long id, java.lang.String mac, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_setButtonCallbacks, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getConnectionStatus(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_getConnectionStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getColor(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_getColor, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean readRemoteRSSI(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_readRemoteRSSI, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setActiveMode(long id, java.lang.String mac, boolean activeMode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
_data.writeInt(((activeMode)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setActiveMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void grabExclusivity(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_grabExclusivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void releaseExclusivity(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_releaseExclusivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean validateIntent(long id, android.os.Bundle bundle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
if ((bundle!=null)) {
_data.writeInt(1);
bundle.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_validateIntent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<java.lang.String> listButtons(long id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<java.lang.String> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
mRemote.transact(Stub.TRANSACTION_listButtons, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void removeButton(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_removeButton, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void registerListenForBroadcast(long id, java.lang.String mac, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_registerListenForBroadcast, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getName(long id, java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(id);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_getName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_listenForConnectionCallbacks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_unListenForConnectionCallbacks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setButtonCallbacks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getConnectionStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getColor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_readRemoteRSSI = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_setActiveMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_grabExclusivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_releaseExclusivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_validateIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_listButtons = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_removeButton = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_registerListenForBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
}
public long registerCallback(io.flic.lib.IFlicLibCallbackInterface cb, java.lang.String appId, java.lang.String appSecret, java.lang.String appName) throws android.os.RemoteException;
public void unregisterCallback(long id) throws android.os.RemoteException;
public void listenForConnectionCallbacks(long id, java.lang.String mac) throws android.os.RemoteException;
public void unListenForConnectionCallbacks(long id, java.lang.String mac) throws android.os.RemoteException;
public void setButtonCallbacks(long id, java.lang.String mac, int flags) throws android.os.RemoteException;
public int getConnectionStatus(long id, java.lang.String mac) throws android.os.RemoteException;
public java.lang.String getColor(long id, java.lang.String mac) throws android.os.RemoteException;
public boolean readRemoteRSSI(long id, java.lang.String mac) throws android.os.RemoteException;
public void setActiveMode(long id, java.lang.String mac, boolean activeMode) throws android.os.RemoteException;
public void grabExclusivity(long id, java.lang.String mac) throws android.os.RemoteException;
public void releaseExclusivity(long id, java.lang.String mac) throws android.os.RemoteException;
public boolean validateIntent(long id, android.os.Bundle bundle) throws android.os.RemoteException;
public java.util.List<java.lang.String> listButtons(long id) throws android.os.RemoteException;
public void removeButton(long id, java.lang.String mac) throws android.os.RemoteException;
public void registerListenForBroadcast(long id, java.lang.String mac, int flags) throws android.os.RemoteException;
public java.lang.String getName(long id, java.lang.String mac) throws android.os.RemoteException;
}
