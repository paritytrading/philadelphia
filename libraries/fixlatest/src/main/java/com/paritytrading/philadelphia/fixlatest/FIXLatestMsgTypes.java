/*
 * Copyright 2020 Philadelphia authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.philadelphia.fixlatest;

/*
 * This file has been automatically generated using Philadelphia Code
 * Generator. For more information on Philadelphia Code Generator, see:
 *
 *   https://github.com/paritytrading/philadelphia
 */

/**
 * Message types for FIX Latest.
 */
public class FIXLatestMsgTypes {

    public static final char   Heartbeat                               = '0';
    public static final char   TestRequest                             = '1';
    public static final char   ResendRequest                           = '2';
    public static final char   Reject                                  = '3';
    public static final char   SequenceReset                           = '4';
    public static final char   Logout                                  = '5';
    public static final char   IOI                                     = '6';
    public static final char   Advertisement                           = '7';
    public static final char   ExecutionReport                         = '8';
    public static final char   OrderCancelReject                       = '9';
    public static final char   Logon                                   = 'A';
    public static final char   News                                    = 'B';
    public static final char   Email                                   = 'C';
    public static final char   NewOrderSingle                          = 'D';
    public static final char   NewOrderList                            = 'E';
    public static final char   OrderCancelRequest                      = 'F';
    public static final char   OrderCancelReplaceRequest               = 'G';
    public static final char   OrderStatusRequest                      = 'H';
    public static final char   AllocationInstruction                   = 'J';
    public static final char   ListCancelRequest                       = 'K';
    public static final char   ListExecute                             = 'L';
    public static final char   ListStatusRequest                       = 'M';
    public static final char   ListStatus                              = 'N';
    public static final char   AllocationInstructionAck                = 'P';
    public static final char   DontKnowTrade                           = 'Q';
    public static final char   QuoteRequest                            = 'R';
    public static final char   Quote                                   = 'S';
    public static final char   SettlementInstructions                  = 'T';
    public static final char   MarketDataRequest                       = 'V';
    public static final char   MarketDataSnapshotFullRefresh           = 'W';
    public static final char   MarketDataIncrementalRefresh            = 'X';
    public static final char   MarketDataRequestReject                 = 'Y';
    public static final char   QuoteCancel                             = 'Z';
    public static final char   QuoteStatusRequest                      = 'a';
    public static final char   MassQuoteAck                            = 'b';
    public static final char   SecurityDefinitionRequest               = 'c';
    public static final char   SecurityDefinition                      = 'd';
    public static final char   SecurityStatusRequest                   = 'e';
    public static final char   SecurityStatus                          = 'f';
    public static final char   TradingSessionStatusRequest             = 'g';
    public static final char   TradingSessionStatus                    = 'h';
    public static final char   MassQuote                               = 'i';
    public static final char   BusinessMessageReject                   = 'j';
    public static final char   BidRequest                              = 'k';
    public static final char   BidResponse                             = 'l';
    public static final char   ListStrikePrice                         = 'm';
    public static final char   XMLnonFIX                               = 'n';
    public static final char   RegistrationInstructions                = 'o';
    public static final char   RegistrationInstructionsResponse        = 'p';
    public static final char   OrderMassCancelRequest                  = 'q';
    public static final char   OrderMassCancelReport                   = 'r';
    public static final char   NewOrderCross                           = 's';
    public static final char   CrossOrderCancelReplaceRequest          = 't';
    public static final char   CrossOrderCancelRequest                 = 'u';
    public static final char   SecurityTypeRequest                     = 'v';
    public static final char   SecurityTypes                           = 'w';
    public static final char   SecurityListRequest                     = 'x';
    public static final char   SecurityList                            = 'y';
    public static final char   DerivativeSecurityListRequest           = 'z';
    public static final String DerivativeSecurityList                  = "AA";
    public static final String NewOrderMultileg                        = "AB";
    public static final String MultilegOrderCancelReplace              = "AC";
    public static final String TradeCaptureReportRequest               = "AD";
    public static final String TradeCaptureReport                      = "AE";
    public static final String OrderMassStatusRequest                  = "AF";
    public static final String QuoteRequestReject                      = "AG";
    public static final String RFQRequest                              = "AH";
    public static final String QuoteStatusReport                       = "AI";
    public static final String QuoteResponse                           = "AJ";
    public static final String Confirmation                            = "AK";
    public static final String PositionMaintenanceRequest              = "AL";
    public static final String PositionMaintenanceReport               = "AM";
    public static final String RequestForPositions                     = "AN";
    public static final String RequestForPositionsAck                  = "AO";
    public static final String PositionReport                          = "AP";
    public static final String TradeCaptureReportRequestAck            = "AQ";
    public static final String TradeCaptureReportAck                   = "AR";
    public static final String AllocationReport                        = "AS";
    public static final String AllocationReportAck                     = "AT";
    public static final String ConfirmationAck                         = "AU";
    public static final String SettlementInstructionRequest            = "AV";
    public static final String AssignmentReport                        = "AW";
    public static final String CollateralRequest                       = "AX";
    public static final String CollateralAssignment                    = "AY";
    public static final String CollateralResponse                      = "AZ";
    public static final String CollateralReport                        = "BA";
    public static final String CollateralInquiry                       = "BB";
    public static final String NetworkCounterpartySystemStatusRequest  = "BC";
    public static final String NetworkCounterpartySystemStatusResponse = "BD";
    public static final String UserRequest                             = "BE";
    public static final String UserResponse                            = "BF";
    public static final String CollateralInquiryAck                    = "BG";
    public static final String ConfirmationRequest                     = "BH";
    public static final String ContraryIntentionReport                 = "BO";
    public static final String SecurityDefinitionUpdateReport          = "BP";
    public static final String SecurityListUpdateReport                = "BK";
    public static final String AdjustedPositionReport                  = "BL";
    public static final String AllocationInstructionAlert              = "BM";
    public static final String ExecutionAck                            = "BN";
    public static final String TradingSessionList                      = "BJ";
    public static final String TradingSessionListRequest               = "BI";
    public static final String SettlementObligationReport              = "BQ";
    public static final String DerivativeSecurityListUpdateReport      = "BR";
    public static final String TradingSessionListUpdateReport          = "BS";
    public static final String MarketDefinitionRequest                 = "BT";
    public static final String MarketDefinition                        = "BU";
    public static final String MarketDefinitionUpdateReport            = "BV";
    public static final String UserNotification                        = "CB";
    public static final String OrderMassActionReport                   = "BZ";
    public static final String OrderMassActionRequest                  = "CA";
    public static final String ApplicationMessageRequest               = "BW";
    public static final String ApplicationMessageRequestAck            = "BX";
    public static final String ApplicationMessageReport                = "BY";
    public static final String StreamAssignmentRequest                 = "CC";
    public static final String StreamAssignmentReport                  = "CD";
    public static final String StreamAssignmentReportACK               = "CE";
    public static final String MarginRequirementInquiry                = "CH";
    public static final String MarginRequirementInquiryAck             = "CI";
    public static final String MarginRequirementReport                 = "CJ";
    public static final String PartyDetailsListRequest                 = "CF";
    public static final String PartyDetailsListReport                  = "CG";
    public static final String PartyDetailsListUpdateReport            = "CK";
    public static final String PartyRiskLimitsRequest                  = "CL";
    public static final String PartyRiskLimitsReport                   = "CM";
    public static final String SecurityMassStatusRequest               = "CN";
    public static final String SecurityMassStatus                      = "CO";
    public static final String AccountSummaryReport                    = "CQ";
    public static final String PartyRiskLimitsUpdateReport             = "CR";
    public static final String PartyRiskLimitsDefinitionRequest        = "CS";
    public static final String PartyRiskLimitsDefinitionRequestAck     = "CT";
    public static final String PartyEntitlementsRequest                = "CU";
    public static final String PartyEntitlementsReport                 = "CV";
    public static final String QuoteAck                                = "CW";
    public static final String PartyDetailsDefinitionRequest           = "CX";
    public static final String PartyDetailsDefinitionRequestAck        = "CY";
    public static final String PartyEntitlementsUpdateReport           = "CZ";
    public static final String PartyEntitlementsDefinitionRequest      = "DA";
    public static final String PartyEntitlementsDefinitionRequestAck   = "DB";
    public static final String TradeMatchReport                        = "DC";
    public static final String TradeMatchReportAck                     = "DD";
    public static final String PartyRiskLimitsReportAck                = "DE";
    public static final String PartyRiskLimitCheckRequest              = "DF";
    public static final String PartyRiskLimitCheckRequestAck           = "DG";
    public static final String PartyActionRequest                      = "DH";
    public static final String PartyActionReport                       = "DI";
    public static final String MassOrder                               = "DJ";
    public static final String MassOrderAck                            = "DK";
    public static final String PositionTransferInstruction             = "DL";
    public static final String PositionTransferInstructionAck          = "DM";
    public static final String PositionTransferReport                  = "DN";
    public static final String MarketDataStatisticsRequest             = "DO";
    public static final String MarketDataStatisticsReport              = "DP";
    public static final String CollateralReportAck                     = "DQ";
    public static final String MarketDataReport                        = "DR";
    public static final String CrossRequest                            = "DS";
    public static final String CrossRequestAck                         = "DT";
    public static final String AllocationInstructionAlertRequest       = "DU";
    public static final String AllocationInstructionAlertRequestAck    = "DV";
    public static final String TradeAggregationRequest                 = "DW";
    public static final String TradeAggregationReport                  = "DX";
    public static final String PayManagementReport                     = "EA";
    public static final String PayManagementReportAck                  = "EB";
    public static final String PayManagementRequest                    = "DY";
    public static final String PayManagementRequestAck                 = "DZ";

    private FIXLatestMsgTypes() {
    }

}
