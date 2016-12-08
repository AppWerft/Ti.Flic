/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/fuerst/Documents/APPC_WORKSPACE/Ti.Flic/android/src/io/flic/lib/IFlicLibCallbackInterface.aidl
 */
package io.flic.lib;
public interface IFlicLibCallbackInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements io.flic.lib.IFlicLibCallbackInterface
{
private static final java.lang.String DESCRIPTOR = "io.flic.lib.IFlicLibCallbackInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an io.flic.lib.IFlicLibCallbackInterface interface,
 * generating a proxy if needed.
 */
public static io.flic.lib.IFlicLibCallbackInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof io.flic.lib.IFlicLibCallbackInterface))) {
return ((io.flic.lib.IFlicLibCallbackInterface)iin);
}
return new io.flic.lib.IFlicLibCallbackInterface.Stub.Proxy(obj);
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
case TRANSACTION_onConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onConnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onReady:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onReady(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onDisconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.onDisconnect(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onConnectionFailed:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.onConnectionFailed(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onReadRemoteRSSI:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.onReadRemoteRSSI(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onButtonUpOrDown:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.onButtonUpOrDown(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onButtonClickOrHold:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.onButtonClickOrHold(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onButtonSingleOrDoubleClick:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.onButtonSingleOrDoubleClick(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onButtonSingleOrDoubleClickOrHold:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.onButtonSingleOrDoubleClickOrHold(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_onButtonRemoved:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onButtonRemoved(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements io.flic.lib.IFlicLibCallbackInterface
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
@Override public void onConnect(java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_onConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onReady(java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_onReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onDisconnect(java.lang.String mac, int flicError) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
_data.writeInt(flicError);
mRemote.transact(Stub.TRANSACTION_onDisconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onConnectionFailed(java.lang.String mac, int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_onConnectionFailed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onReadRemoteRSSI(java.lang.String mac, int rssi, int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
_data.writeInt(rssi);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_onReadRemoteRSSI, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onButtonUpOrDown(java.lang.String mac, boolean wasQueued, int timeDiff, int action) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
_data.writeInt(((wasQueued)?(1):(0)));
_data.writeInt(timeDiff);
_data.writeInt(action);
mRemote.transact(Stub.TRANSACTION_onButtonUpOrDown, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onButtonClickOrHold(java.lang.String mac, boolean wasQueued, int timeDiff, int action) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
_data.writeInt(((wasQueued)?(1):(0)));
_data.writeInt(timeDiff);
_data.writeInt(action);
mRemote.transact(Stub.TRANSACTION_onButtonClickOrHold, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onButtonSingleOrDoubleClick(java.lang.String mac, boolean wasQueued, int timeDiff, int action) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
_data.writeInt(((wasQueued)?(1):(0)));
_data.writeInt(timeDiff);
_data.writeInt(action);
mRemote.transact(Stub.TRANSACTION_onButtonSingleOrDoubleClick, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onButtonSingleOrDoubleClickOrHold(java.lang.String mac, boolean wasQueued, int timeDiff, int action) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
_data.writeInt(((wasQueued)?(1):(0)));
_data.writeInt(timeDiff);
_data.writeInt(action);
mRemote.transact(Stub.TRANSACTION_onButtonSingleOrDoubleClickOrHold, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onButtonRemoved(java.lang.String mac) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(mac);
mRemote.transact(Stub.TRANSACTION_onButtonRemoved, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onConnectionFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onReadRemoteRSSI = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_onButtonUpOrDown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onButtonClickOrHold = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_onButtonSingleOrDoubleClick = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_onButtonSingleOrDoubleClickOrHold = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_onButtonRemoved = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
}
public void onConnect(java.lang.String mac) throws android.os.RemoteException;
public void onReady(java.lang.String mac) throws android.os.RemoteException;
public void onDisconnect(java.lang.String mac, int flicError) throws android.os.RemoteException;
public void onConnectionFailed(java.lang.String mac, int status) throws android.os.RemoteException;
public void onReadRemoteRSSI(java.lang.String mac, int rssi, int status) throws android.os.RemoteException;
public void onButtonUpOrDown(java.lang.String mac, boolean wasQueued, int timeDiff, int action) throws android.os.RemoteException;
public void onButtonClickOrHold(java.lang.String mac, boolean wasQueued, int timeDiff, int action) throws android.os.RemoteException;
public void onButtonSingleOrDoubleClick(java.lang.String mac, boolean wasQueued, int timeDiff, int action) throws android.os.RemoteException;
public void onButtonSingleOrDoubleClickOrHold(java.lang.String mac, boolean wasQueued, int timeDiff, int action) throws android.os.RemoteException;
public void onButtonRemoved(java.lang.String mac) throws android.os.RemoteException;
}
