/**
 * ATWSCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package com.time2die.autotask;


/**
 *  ATWSCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ATWSCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public ATWSCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public ATWSCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getEntityInfo method
     * override this method for handling normal response from getEntityInfo operation
     */
    public void receiveResultgetEntityInfo(
        com.time2die.autotask.ATWSStub.GetEntityInfoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getEntityInfo operation
     */
    public void receiveErrorgetEntityInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getThresholdAndUsageInfo method
     * override this method for handling normal response from getThresholdAndUsageInfo operation
     */
    public void receiveResultgetThresholdAndUsageInfo(
        com.time2die.autotask.ATWSStub.GetThresholdAndUsageInfoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getThresholdAndUsageInfo operation
     */
    public void receiveErrorgetThresholdAndUsageInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for createAttachment method
     * override this method for handling normal response from createAttachment operation
     */
    public void receiveResultcreateAttachment(
        com.time2die.autotask.ATWSStub.CreateAttachmentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createAttachment operation
     */
    public void receiveErrorcreateAttachment(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getZoneInfo method
     * override this method for handling normal response from getZoneInfo operation
     */
    public void receiveResultgetZoneInfo(
        com.time2die.autotask.ATWSStub.GetZoneInfoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getZoneInfo operation
     */
    public void receiveErrorgetZoneInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for create method
     * override this method for handling normal response from create operation
     */
    public void receiveResultcreate(
        com.time2die.autotask.ATWSStub.CreateResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from create operation
     */
    public void receiveErrorcreate(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for deleteAttachment method
     * override this method for handling normal response from deleteAttachment operation
     */
    public void receiveResultdeleteAttachment(
        com.time2die.autotask.ATWSStub.DeleteAttachmentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deleteAttachment operation
     */
    public void receiveErrordeleteAttachment(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getInvoiceMarkup method
     * override this method for handling normal response from getInvoiceMarkup operation
     */
    public void receiveResultgetInvoiceMarkup(
        com.time2die.autotask.ATWSStub.GetInvoiceMarkupResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getInvoiceMarkup operation
     */
    public void receiveErrorgetInvoiceMarkup(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUDFInfo method
     * override this method for handling normal response from getUDFInfo operation
     */
    public void receiveResultgetUDFInfo(
        com.time2die.autotask.ATWSStub.GetUDFInfoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUDFInfo operation
     */
    public void receiveErrorgetUDFInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for query method
     * override this method for handling normal response from query operation
     */
    public void receiveResultquery(
        com.time2die.autotask.ATWSStub.QueryResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from query operation
     */
    public void receiveErrorquery(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for update method
     * override this method for handling normal response from update operation
     */
    public void receiveResultupdate(
        com.time2die.autotask.ATWSStub.UpdateResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from update operation
     */
    public void receiveErrorupdate(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for delete method
     * override this method for handling normal response from delete operation
     */
    public void receiveResultdelete(
        com.time2die.autotask.ATWSStub.DeleteResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from delete operation
     */
    public void receiveErrordelete(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getFieldInfo method
     * override this method for handling normal response from getFieldInfo operation
     */
    public void receiveResultgetFieldInfo(
        com.time2die.autotask.ATWSStub.GetFieldInfoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getFieldInfo operation
     */
    public void receiveErrorgetFieldInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getWsdlVersion method
     * override this method for handling normal response from getWsdlVersion operation
     */
    public void receiveResultgetWsdlVersion(
        com.time2die.autotask.ATWSStub.GetWsdlVersionResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getWsdlVersion operation
     */
    public void receiveErrorgetWsdlVersion(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getAttachment method
     * override this method for handling normal response from getAttachment operation
     */
    public void receiveResultgetAttachment(
        com.time2die.autotask.ATWSStub.GetAttachmentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getAttachment operation
     */
    public void receiveErrorgetAttachment(java.lang.Exception e) {
    }
}
