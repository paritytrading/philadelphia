/*
 * Copyright 2022 Philadelphia authors
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
package com.paritytrading.philadelphia.fix40;

/*
 * This file has been automatically generated using Philadelphia Code
 * Generator. For more information on Philadelphia Code Generator, see:
 *
 *   https://github.com/paritytrading/philadelphia
 */

/**
 * Enumerations for FIX 4.0.
 */
public class FIX40Enumerations {

    /**
     * Values for AdvSide(4).
     */
    public static class AdvSideValues {

        public static final char Buy   = 'B';
        public static final char Sell  = 'S';
        public static final char Trade = 'T';
        public static final char Cross = 'X';

        private AdvSideValues() {
        }

    }

    /**
     * Values for AdvTransType(5).
     */
    public static class AdvTransTypeValues {

        public static final char Cancel  = 'C';
        public static final char New     = 'N';
        public static final char Replace = 'R';

        private AdvTransTypeValues() {
        }

    }

    /**
     * Values for CommType(13).
     */
    public static class CommTypeValues {

        public static final char PerUnit  = '1';
        public static final char Percent  = '2';
        public static final char Absolute = '3';

        private CommTypeValues() {
        }

    }

    /**
     * Values for ExecInst(18).
     */
    public static class ExecInstValues {

        public static final char StayOnOfferSide          = '0';
        public static final char NotHeld                  = '1';
        public static final char Work                     = '2';
        public static final char GoAlong                  = '3';
        public static final char OverTheDay               = '4';
        public static final char Held                     = '5';
        public static final char ParticipateDoNotInitiate = '6';
        public static final char StrictScale              = '7';
        public static final char TryToScale               = '8';
        public static final char StayOnBidSide            = '9';
        public static final char NoCross                  = 'A';
        public static final char OKToCross                = 'B';
        public static final char CallFirst                = 'C';
        public static final char PercentOfVolume          = 'D';
        public static final char DoNotIncrease            = 'E';
        public static final char DoNotReduce              = 'F';
        public static final char AllOrNone                = 'G';
        public static final char InstitutionsOnly         = 'I';
        public static final char LastPeg                  = 'L';
        public static final char MidPricePeg              = 'M';
        public static final char NonNegotiable            = 'N';
        public static final char OpeningPeg               = 'O';
        public static final char MarketPeg                = 'P';
        public static final char PrimaryPeg               = 'R';
        public static final char Suspend                  = 'S';

        private ExecInstValues() {
        }

    }

    /**
     * Values for ExecTransType(20).
     */
    public static class ExecTransTypeValues {

        public static final char New     = '0';
        public static final char Cancel  = '1';
        public static final char Correct = '2';
        public static final char Status  = '3';

        private ExecTransTypeValues() {
        }

    }

    /**
     * Values for HandlInst(21).
     */
    public static class HandlInstValues {

        public static final char AutomatedExecutionNoIntervention = '1';
        public static final char AutomatedExecutionInterventionOK = '2';
        public static final char ManualOrder                      = '3';

        private HandlInstValues() {
        }

    }

    /**
     * Values for IDSource(22).
     */
    public static class IDSourceValues {

        public static final char CUSIP      = '1';
        public static final char SEDOL      = '2';
        public static final char QUIK       = '3';
        public static final char ISINNumber = '4';
        public static final char RICCode    = '5';

        private IDSourceValues() {
        }

    }

    /**
     * Values for IOIOthSvc(24).
     */
    public static class IOIOthSvcValues {

        public static final char Autex  = 'A';
        public static final char Bridge = 'B';

        private IOIOthSvcValues() {
        }

    }

    /**
     * Values for IOIQltyInd(25).
     */
    public static class IOIQltyIndValues {

        public static final char High   = 'H';
        public static final char Low    = 'L';
        public static final char Medium = 'M';

        private IOIQltyIndValues() {
        }

    }

    /**
     * Values for IOIShares(27).
     */
    public static class IOISharesValues {

        public static final char Large  = 'L';
        public static final char Medium = 'M';
        public static final char Small  = 'S';

        private IOISharesValues() {
        }

    }

    /**
     * Values for IOITransType(28).
     */
    public static class IOITransTypeValues {

        public static final char Cancel  = 'C';
        public static final char New     = 'N';
        public static final char Replace = 'R';

        private IOITransTypeValues() {
        }

    }

    /**
     * Values for LastCapacity(29).
     */
    public static class LastCapacityValues {

        public static final char Agent            = '1';
        public static final char CrossAsAgent     = '2';
        public static final char CrossAsPrincipal = '3';
        public static final char Principal        = '4';

        private LastCapacityValues() {
        }

    }

    /**
     * Values for OrdStatus(39).
     */
    public static class OrdStatusValues {

        public static final char New             = '0';
        public static final char PartiallyFilled = '1';
        public static final char Filled          = '2';
        public static final char DoneForDay      = '3';
        public static final char Canceled        = '4';
        public static final char Replaced        = '5';
        public static final char PendingCancel   = '6';
        public static final char Stopped         = '7';
        public static final char Rejected        = '8';
        public static final char Suspended       = '9';
        public static final char PendingNew      = 'A';
        public static final char Calculated      = 'B';
        public static final char Expired         = 'C';

        private OrdStatusValues() {
        }

    }

    /**
     * Values for OrdType(40).
     */
    public static class OrdTypeValues {

        public static final char Market              = '1';
        public static final char Limit               = '2';
        public static final char Stop                = '3';
        public static final char StopLimit           = '4';
        public static final char MarketOnClose       = '5';
        public static final char WithOrWithout       = '6';
        public static final char LimitOrBetter       = '7';
        public static final char LimitWithOrWithout  = '8';
        public static final char OnBasis             = '9';
        public static final char OnClose             = 'A';
        public static final char LimitOnClose        = 'B';
        public static final char ForexMarket         = 'C';
        public static final char PreviouslyQuoted    = 'D';
        public static final char PreviouslyIndicated = 'E';
        public static final char Pegged              = 'P';

        private OrdTypeValues() {
        }

    }

    /**
     * Values for PossDupFlag(43).
     */
    public static class PossDupFlagValues {

        public static final char OriginalTransmission = 'N';
        public static final char PossibleDuplicate    = 'Y';

        private PossDupFlagValues() {
        }

    }

    /**
     * Values for Rule80A(47).
     */
    public static class Rule80AValues {

        public static final char AgencySingleOrder                   = 'A';
        public static final char ProprietaryNonAlgo                  = 'C';
        public static final char ProgramOrderMember                  = 'D';
        public static final char IndividualInvestor                  = 'I';
        public static final char ProprietaryAlgo                     = 'J';
        public static final char AgencyAlgo                          = 'K';
        public static final char ProgramOrderOtherMember             = 'M';
        public static final char AgentForOtherMember                 = 'N';
        public static final char AgencyIndexArb                      = 'U';
        public static final char AllOtherOrdersAsAgentForOtherMember = 'W';
        public static final char AgencyNonAlgo                       = 'Y';

        private Rule80AValues() {
        }

    }

    /**
     * Values for Side(54).
     */
    public static class SideValues {

        public static final char Buy             = '1';
        public static final char Sell            = '2';
        public static final char BuyMinus        = '3';
        public static final char SellPlus        = '4';
        public static final char SellShort       = '5';
        public static final char SellShortExempt = '6';

        private SideValues() {
        }

    }

    /**
     * Values for TimeInForce(59).
     */
    public static class TimeInForceValues {

        public static final char Day               = '0';
        public static final char GoodTillCancel    = '1';
        public static final char AtTheOpening      = '2';
        public static final char ImmediateOrCancel = '3';
        public static final char FillOrKill        = '4';
        public static final char GoodTillCrossing  = '5';
        public static final char GoodTillDate      = '6';

        private TimeInForceValues() {
        }

    }

    /**
     * Values for Urgency(61).
     */
    public static class UrgencyValues {

        public static final char Normal     = '0';
        public static final char Flash      = '1';
        public static final char Background = '2';

        private UrgencyValues() {
        }

    }

    /**
     * Values for SettlmntTyp(63).
     */
    public static class SettlmntTypValues {

        public static final char Regular         = '0';
        public static final char Cash            = '1';
        public static final char NextDay         = '2';
        public static final char TPlus2          = '3';
        public static final char TPlus3          = '4';
        public static final char TPlus4          = '5';
        public static final char Future          = '6';
        public static final char WhenAndIfIssued = '7';
        public static final char SellersOption   = '8';
        public static final char TPlus5          = '9';

        private SettlmntTypValues() {
        }

    }

    /**
     * Values for AllocTransType(71).
     */
    public static class AllocTransTypeValues {

        public static final char New     = '0';
        public static final char Replace = '1';
        public static final char Cancel  = '2';

        private AllocTransTypeValues() {
        }

    }

    /**
     * Values for ProcessCode(81).
     */
    public static class ProcessCodeValues {

        public static final char Regular           = '0';
        public static final char SoftDollar        = '1';
        public static final char StepIn            = '2';
        public static final char StepOut           = '3';
        public static final char SoftDollarStepIn  = '4';
        public static final char SoftDollarStepOut = '5';
        public static final char PlanSponsor       = '6';

        private ProcessCodeValues() {
        }

    }

    /**
     * Values for AllocStatus(87).
     */
    public static class AllocStatusValues {

        public static final int Accepted           = 0;
        public static final int BlockLevelReject   = 1;
        public static final int AccountLevelReject = 2;
        public static final int Received           = 3;

        private AllocStatusValues() {
        }

    }

    /**
     * Values for AllocRejCode(88).
     */
    public static class AllocRejCodeValues {

        public static final int UnknownAccount                 = 0;
        public static final int IncorrectQuantity              = 1;
        public static final int IncorrectAveragegPrice         = 2;
        public static final int UnknownExecutingBrokerMnemonic = 3;
        public static final int CommissionDifference           = 4;
        public static final int UnknownOrderID                 = 5;
        public static final int UnknownListID                  = 6;
        public static final int OtherSeeText                   = 7;

        private AllocRejCodeValues() {
        }

    }

    /**
     * Values for EmailType(94).
     */
    public static class EmailTypeValues {

        public static final char New        = '0';
        public static final char Reply      = '1';
        public static final char AdminReply = '2';

        private EmailTypeValues() {
        }

    }

    /**
     * Values for EncryptMethod(98).
     */
    public static class EncryptMethodValues {

        public static final int None      = 0;
        public static final int PKCS      = 1;
        public static final int DES       = 2;
        public static final int PKCSDES   = 3;
        public static final int PGPDES    = 4;
        public static final int PGPDESMD5 = 5;
        public static final int PEM       = 6;

        private EncryptMethodValues() {
        }

    }

    /**
     * Values for ExDestination(100).
     */
    public static class ExDestinationValues {

        public static final char None  = '0';
        public static final char POSIT = '4';

        private ExDestinationValues() {
        }

    }

    /**
     * Values for CxlRejReason(102).
     */
    public static class CxlRejReasonValues {

        public static final int TooLateToCancel = 0;
        public static final int UnknownOrder    = 1;

        private CxlRejReasonValues() {
        }

    }

    /**
     * Values for OrdRejReason(103).
     */
    public static class OrdRejReasonValues {

        public static final int BrokerCredit      = 0;
        public static final int UnknownSymbol     = 1;
        public static final int ExchangeClosed    = 2;
        public static final int OrderExceedsLimit = 3;
        public static final int TooLateToEnter    = 4;

        private OrdRejReasonValues() {
        }

    }

    /**
     * Values for IOIQualifier(104).
     */
    public static class IOIQualifierValues {

        public static final char AllOrNone           = 'A';
        public static final char AtTheClose          = 'C';
        public static final char InTouchWith         = 'I';
        public static final char Limit               = 'L';
        public static final char MoreBehind          = 'M';
        public static final char AtTheOpen           = 'O';
        public static final char TakingAPosition     = 'P';
        public static final char AtTheMarket         = 'Q';
        public static final char PortfolioShown      = 'S';
        public static final char ThroughTheDay       = 'T';
        public static final char Versus              = 'V';
        public static final char Indication          = 'W';
        public static final char CrossingOpportunity = 'X';

        private IOIQualifierValues() {
        }

    }

    /**
     * Values for ReportToExch(113).
     */
    public static class ReportToExchValues {

        public static final char SenderReports   = 'N';
        public static final char ReceiverReports = 'Y';

        private ReportToExchValues() {
        }

    }

    /**
     * Values for LocateReqd(114).
     */
    public static class LocateReqdValues {

        public static final char No  = 'N';
        public static final char Yes = 'Y';

        private LocateReqdValues() {
        }

    }

    /**
     * Values for ForexReq(121).
     */
    public static class ForexReqValues {

        public static final char DoNotExecuteForexAfterSecurityTrade = 'N';
        public static final char ExecuteForexAfterSecurityTrade      = 'Y';

        private ForexReqValues() {
        }

    }

    /**
     * Values for GapFillFlag(123).
     */
    public static class GapFillFlagValues {

        public static final char SequenceReset  = 'N';
        public static final char GapFillMessage = 'Y';

        private GapFillFlagValues() {
        }

    }

    /**
     * Values for CxlType(125).
     */
    public static class CxlTypeValues {

        public static final char FullRemainingQuantity = 'F';
        public static final char PartialCancel         = 'P';

        private CxlTypeValues() {
        }

    }

    /**
     * Values for DKReason(127).
     */
    public static class DKReasonValues {

        public static final char UnknownSymbol        = 'A';
        public static final char WrongSide            = 'B';
        public static final char QuantityExceedsOrder = 'C';
        public static final char NoMatchingOrder      = 'D';
        public static final char PriceExceedsLimit    = 'E';
        public static final char Other                = 'Z';

        private DKReasonValues() {
        }

    }

    /**
     * Values for IOINaturalFlag(130).
     */
    public static class IOINaturalFlagValues {

        public static final char NotNatural = 'N';
        public static final char Natural    = 'Y';

        private IOINaturalFlagValues() {
        }

    }

    /**
     * Values for MiscFeeType(139).
     */
    public static class MiscFeeTypeValues {

        public static final char Regulatory      = '1';
        public static final char Tax             = '2';
        public static final char LocalCommission = '3';
        public static final char ExchangeFees    = '4';
        public static final char Stamp           = '5';
        public static final char Levy            = '6';
        public static final char Other           = '7';

        private MiscFeeTypeValues() {
        }

    }

    private FIX40Enumerations() {
    }

}
