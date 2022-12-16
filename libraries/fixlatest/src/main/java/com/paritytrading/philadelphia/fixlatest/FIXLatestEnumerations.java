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
package com.paritytrading.philadelphia.fixlatest;

/*
 * This file has been automatically generated using Philadelphia Code
 * Generator. For more information on Philadelphia Code Generator, see:
 *
 *   https://github.com/paritytrading/philadelphia
 */

/**
 * Enumerations for FIX Latest.
 */
public class FIXLatestEnumerations {

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

        public static final String New     = "N";
        public static final String Cancel  = "C";
        public static final String Replace = "R";

        private AdvTransTypeValues() {
        }

    }

    /**
     * Values for BeginString(8).
     */
    public static class BeginStringValues {

        public static final String FIX42  = "FIX.4.2";
        public static final String FIX44  = "FIX.4.4";
        public static final String FIXT11 = "FIXT.1.1";

        private BeginStringValues() {
        }

    }

    /**
     * Values for CommType(13).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>CommissionBasis(2642)</li>
     *   <li>AllocCommissionBasis(2656)</li>
     *   <li>LegReturnRateCommissionBasis(42536)</li>
     *   <li>ReturnRateCommissionBasis(42737)</li>
     *   <li>UnderlyingReturnRateCommissionBasis(43036)</li>
     * </ul>
     */
    public static class CommTypeValues {

        public static final char PerUnit                       = '1';
        public static final char Percent                       = '2';
        public static final char Absolute                      = '3';
        public static final char PercentageWaivedCashDiscount  = '4';
        public static final char PercentageWaivedEnhancedUnits = '5';
        public static final char PointsPerBondOrContract       = '6';
        public static final char BasisPoints                   = '7';
        public static final char AmountPerContract             = '8';

        private CommTypeValues() {
        }

    }

    /**
     * Values for ExecInst(18).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ExecInstValue(1308)</li>
     *   <li>LegExecInst(1384)</li>
     * </ul>
     */
    public static class ExecInstValues {

        public static final char StayOnOfferSide                            = '0';
        public static final char NotHeld                                    = '1';
        public static final char Work                                       = '2';
        public static final char GoAlong                                    = '3';
        public static final char OverTheDay                                 = '4';
        public static final char Held                                       = '5';
        public static final char ParticipateDoNotInitiate                   = '6';
        public static final char StrictScale                                = '7';
        public static final char TryToScale                                 = '8';
        public static final char StayOnBidSide                              = '9';
        public static final char NoCross                                    = 'A';
        public static final char OKToCross                                  = 'B';
        public static final char CallFirst                                  = 'C';
        public static final char PercentOfVolume                            = 'D';
        public static final char DoNotIncrease                              = 'E';
        public static final char DoNotReduce                                = 'F';
        public static final char AllOrNone                                  = 'G';
        public static final char ReinstateOnSystemFailure                   = 'H';
        public static final char InstitutionsOnly                           = 'I';
        public static final char ReinstateOnTradingHalt                     = 'J';
        public static final char CancelOnTradingHalt                        = 'K';
        public static final char LastPeg                                    = 'L';
        public static final char MidPricePeg                                = 'M';
        public static final char NonNegotiable                              = 'N';
        public static final char OpeningPeg                                 = 'O';
        public static final char MarketPeg                                  = 'P';
        public static final char CancelOnSystemFailure                      = 'Q';
        public static final char PrimaryPeg                                 = 'R';
        public static final char Suspend                                    = 'S';
        public static final char FixedPegToLocalBestBidOrOfferAtTimeOfOrder = 'T';
        public static final char CustomerDisplayInstruction                 = 'U';
        public static final char Netting                                    = 'V';
        public static final char PegToVWAP                                  = 'W';
        public static final char TradeAlong                                 = 'X';
        public static final char TryToStop                                  = 'Y';
        public static final char CancelIfNotBest                            = 'Z';
        public static final char TrailingStopPeg                            = 'a';
        public static final char StrictLimit                                = 'b';
        public static final char IgnorePriceValidityChecks                  = 'c';
        public static final char PegToLimitPrice                            = 'd';
        public static final char WorkToTargetStrategy                       = 'e';
        public static final char IntermarketSweep                           = 'f';
        public static final char ExternalRoutingAllowed                     = 'g';
        public static final char ExternalRoutingNotAllowed                  = 'h';
        public static final char ImbalanceOnly                              = 'i';
        public static final char SingleExecutionRequestedForBlockTrade      = 'j';
        public static final char BestExecution                              = 'k';
        public static final char SuspendOnSystemFailure                     = 'l';
        public static final char SuspendOnTradingHalt                       = 'm';
        public static final char ReinstateOnConnectionLoss                  = 'n';
        public static final char CancelOnConnectionLoss                     = 'o';
        public static final char SuspendOnConnectionLoss                    = 'p';
        public static final char Release                                    = 'q';
        public static final char ExecuteAsDeltaNeutral                      = 'r';
        public static final char ExecuteAsDurationNeutral                   = 's';
        public static final char ExecuteAsFXNeutral                         = 't';
        public static final char MinGuaranteedFillEligible                  = 'u';
        public static final char BypassNonDisplayLiquidity                  = 'v';
        public static final char Lock                                       = 'w';
        public static final char IgnoreNotionalValueChecks                  = 'x';
        public static final char TrdAtRefPx                                 = 'y';
        public static final char AllowFacilitation                          = 'z';

        private ExecInstValues() {
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
     * Values for SecurityIDSource(22).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingSecurityIDSource(305)</li>
     *   <li>SecurityAltIDSource(456)</li>
     *   <li>UnderlyingSecurityAltIDSource(459)</li>
     *   <li>LegSecurityIDSource(603)</li>
     *   <li>LegSecurityAltIDSource(606)</li>
     *   <li>BenchmarkSecurityIDSource(761)</li>
     *   <li>PegSecurityIDSource(1096)</li>
     *   <li>TriggerSecurityIDSource(1105)</li>
     *   <li>DerivativeSecurityIDSource(1217)</li>
     *   <li>DerivativeSecurityAltIDSource(1220)</li>
     *   <li>InstrumentScopeSecurityIDSource(1539)</li>
     *   <li>InstrumentScopeSecurityAltIDSource(1542)</li>
     *   <li>RelatedSecurityIDSource(1651)</li>
     *   <li>ConvertibleBondEquityIDSource(1952)</li>
     *   <li>UnderlyingObligationIDSource(1995)</li>
     *   <li>UnderlyingEquityIDSource(1997)</li>
     *   <li>LegConvertibleBondEquityIDSource(2167)</li>
     *   <li>RelatedToSecurityIDSource(2414)</li>
     *   <li>UnderlyingFutureIDSource(2621)</li>
     *   <li>FloatingRateIndexIDSource(2732)</li>
     *   <li>AdditionalTermBondSecurityIDSource(40002)</li>
     *   <li>MarketDisruptionFallbackUnderlierSecurityIDSource(41099)</li>
     *   <li>StreamCommoditySecurityIDSource(41254)</li>
     *   <li>LegAdditionalTermBondSecurityIDSource(41318)</li>
     *   <li>LegMarketDisruptionFallbackUnderlierSecurityIDSource(41474)</li>
     *   <li>LegStreamCommoditySecurityIDSource(41651)</li>
     *   <li>UnderlyingAdditionalTermBondSecurityIDSource(41701)</li>
     *   <li>UnderlyingMarketDisruptionFallbackUnderlierSecurityIDSource(41871)</li>
     *   <li>UnderlyingStreamCommoditySecurityIDSource(41967)</li>
     *   <li>LegPaymentStreamRateIndexIDSource(43089)</li>
     *   <li>PaymentStreamRateIndexIDSource(43091)</li>
     *   <li>UnderlyingPaymentStreamRateIndexIDSource(43093)</li>
     *   <li>PaymentStreamRateIndex2IDSource(43115)</li>
     *   <li>LegPaymentStreamRateIndex2IDSource(43119)</li>
     *   <li>UnderlyingPaymentStreamRateIndex2IDSource(43123)</li>
     * </ul>
     */
    public static class SecurityIDSourceValues {

        public static final String CUSIP                               = "1";
        public static final String SEDOL                               = "2";
        public static final String QUIK                                = "3";
        public static final String ISINNumber                          = "4";
        public static final String RICCode                             = "5";
        public static final String ISOCurrencyCode                     = "6";
        public static final String ISOCountryCode                      = "7";
        public static final String ExchangeSymbol                      = "8";
        public static final String ConsolidatedTapeAssociation         = "9";
        public static final String BloombergSymbol                     = "A";
        public static final String Wertpapier                          = "B";
        public static final String Dutch                               = "C";
        public static final String Valoren                             = "D";
        public static final String Sicovam                             = "E";
        public static final String Belgian                             = "F";
        public static final String Common                              = "G";
        public static final String ClearingHouse                       = "H";
        public static final String ISDAFpMLSpecification               = "I";
        public static final String OptionPriceReportingAuthority       = "J";
        public static final String ISDAFpMLURL                         = "K";
        public static final String LetterOfCredit                      = "L";
        public static final String MarketplaceAssignedIdentifier       = "M";
        public static final String MarkitREDEntityCLIP                 = "N";
        public static final String MarkitREDPairCLIP                   = "P";
        public static final String CFTCCommodityCode                   = "Q";
        public static final String ISDACommodityReferencePrice         = "R";
        public static final String FinancialInstrumentGlobalIdentifier = "S";
        public static final String LegalEntityIdentifier               = "T";
        public static final String Synthetic                           = "U";
        public static final String FidessaInstrumentMnemonic           = "V";
        public static final String IndexName                           = "W";
        public static final String UniformSymbol                       = "X";
        public static final String DigitalTokenIdentifier              = "Y";

        private SecurityIDSourceValues() {
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
     * Values for IOIQty(27).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegIOIQty(682)</li>
     * </ul>
     */
    public static class IOIQtyValues {

        public static final String Small               = "S";
        public static final String Medium              = "M";
        public static final String Large               = "L";
        public static final String UndisclosedQuantity = "U";

        private IOIQtyValues() {
        }

    }

    /**
     * Values for IOITransType(28).
     */
    public static class IOITransTypeValues {

        public static final char New     = 'N';
        public static final char Cancel  = 'C';
        public static final char Replace = 'R';

        private IOITransTypeValues() {
        }

    }

    /**
     * Values for LastCapacity(29).
     */
    public static class LastCapacityValues {

        public static final char Agent             = '1';
        public static final char CrossAsAgent      = '2';
        public static final char CrossAsPrincipal  = '3';
        public static final char Principal         = '4';
        public static final char RisklessPrincipal = '5';

        private LastCapacityValues() {
        }

    }

    /**
     * Values for OrdStatus(39).
     */
    public static class OrdStatusValues {

        public static final char New                = '0';
        public static final char PartiallyFilled    = '1';
        public static final char Filled             = '2';
        public static final char DoneForDay         = '3';
        public static final char Canceled           = '4';
        public static final char Replaced           = '5';
        public static final char PendingCancel      = '6';
        public static final char Stopped            = '7';
        public static final char Rejected           = '8';
        public static final char Suspended          = '9';
        public static final char PendingNew         = 'A';
        public static final char Calculated         = 'B';
        public static final char Expired            = 'C';
        public static final char AcceptedForBidding = 'D';
        public static final char PendingReplace     = 'E';

        private OrdStatusValues() {
        }

    }

    /**
     * Values for OrdType(40).
     */
    public static class OrdTypeValues {

        public static final char Market                     = '1';
        public static final char Limit                      = '2';
        public static final char Stop                       = '3';
        public static final char StopLimit                  = '4';
        public static final char MarketOnClose              = '5';
        public static final char WithOrWithout              = '6';
        public static final char LimitOrBetter              = '7';
        public static final char LimitWithOrWithout         = '8';
        public static final char OnBasis                    = '9';
        public static final char OnClose                    = 'A';
        public static final char LimitOnClose               = 'B';
        public static final char ForexMarket                = 'C';
        public static final char PreviouslyQuoted           = 'D';
        public static final char PreviouslyIndicated        = 'E';
        public static final char ForexLimit                 = 'F';
        public static final char ForexSwap                  = 'G';
        public static final char ForexPreviouslyQuoted      = 'H';
        public static final char Funari                     = 'I';
        public static final char MarketIfTouched            = 'J';
        public static final char MarketWithLeftOverAsLimit  = 'K';
        public static final char PreviousFundValuationPoint = 'L';
        public static final char NextFundValuationPoint     = 'M';
        public static final char Pegged                     = 'P';
        public static final char CounterOrderSelection      = 'Q';
        public static final char StopOnBidOrOffer           = 'R';
        public static final char StopLimitOnBidOrOffer      = 'S';

        private OrdTypeValues() {
        }

    }

    /**
     * Values for Side(54).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegSide(624)</li>
     *   <li>AggressorSide(2446)</li>
     * </ul>
     */
    public static class SideValues {

        public static final char Buy              = '1';
        public static final char Sell             = '2';
        public static final char BuyMinus         = '3';
        public static final char SellPlus         = '4';
        public static final char SellShort        = '5';
        public static final char SellShortExempt  = '6';
        public static final char Undisclosed      = '7';
        public static final char Cross            = '8';
        public static final char CrossShort       = '9';
        public static final char CrossShortExempt = 'A';
        public static final char AsDefined        = 'B';
        public static final char Opposite         = 'C';
        public static final char Subscribe        = 'D';
        public static final char Redeem           = 'E';
        public static final char Lend             = 'F';
        public static final char Borrow           = 'G';
        public static final char SellUndisclosed  = 'H';

        private SideValues() {
        }

    }

    /**
     * Values for TimeInForce(59).
     */
    public static class TimeInForceValues {

        public static final char Day                 = '0';
        public static final char GoodTillCancel      = '1';
        public static final char AtTheOpening        = '2';
        public static final char ImmediateOrCancel   = '3';
        public static final char FillOrKill          = '4';
        public static final char GoodTillCrossing    = '5';
        public static final char GoodTillDate        = '6';
        public static final char AtTheClose          = '7';
        public static final char GoodThroughCrossing = '8';
        public static final char AtCrossing          = '9';
        public static final char GoodForTime         = 'A';
        public static final char GoodForAuction      = 'B';
        public static final char GoodForMonth        = 'C';

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
     * Values for SettlType(63).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegSettlType(587)</li>
     *   <li>InstrumentScopeSettlType(1557)</li>
     * </ul>
     */
    public static class SettlTypeValues {

        public static final String Regular              = "0";
        public static final String Cash                 = "1";
        public static final String NextDay              = "2";
        public static final String TPlus2               = "3";
        public static final String TPlus3               = "4";
        public static final String TPlus4               = "5";
        public static final String Future               = "6";
        public static final String WhenAndIfIssued      = "7";
        public static final String SellersOption        = "8";
        public static final String TPlus5               = "9";
        public static final String BrokenDate           = "B";
        public static final String FXSpotNextSettlement = "C";

        private SettlTypeValues() {
        }

    }

    /**
     * Values for SymbolSfx(65).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingSymbolSfx(312)</li>
     *   <li>LegSymbolSfx(601)</li>
     *   <li>DerivativeSymbolSfx(1215)</li>
     * </ul>
     */
    public static class SymbolSfxValues {

        public static final String EUCPWithLumpSumInterest = "CD";
        public static final String WhenIssued              = "WI";

        private SymbolSfxValues() {
        }

    }

    /**
     * Values for AllocTransType(71).
     */
    public static class AllocTransTypeValues {

        public static final char New                          = '0';
        public static final char Replace                      = '1';
        public static final char Cancel                       = '2';
        public static final char Preliminary                  = '3';
        public static final char Calculated                   = '4';
        public static final char CalculatedWithoutPreliminary = '5';
        public static final char Reversal                     = '6';

        private AllocTransTypeValues() {
        }

    }

    /**
     * Values for PositionEffect(77).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPositionEffect(564)</li>
     * </ul>
     */
    public static class PositionEffectValues {

        public static final char Close                = 'C';
        public static final char FIFO                 = 'F';
        public static final char Open                 = 'O';
        public static final char Rolled               = 'R';
        public static final char CloseButNotifyOnOpen = 'N';
        public static final char Default              = 'D';

        private PositionEffectValues() {
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

        public static final int Accepted                = 0;
        public static final int BlockLevelReject        = 1;
        public static final int AccountLevelReject      = 2;
        public static final int Received                = 3;
        public static final int Incomplete              = 4;
        public static final int RejectedByIntermediary  = 5;
        public static final int AllocationPending       = 6;
        public static final int Reversed                = 7;
        public static final int CancelledByIntermediary = 8;
        public static final int Claimed                 = 9;
        public static final int Refused                 = 10;
        public static final int PendingGiveUpApproval   = 11;
        public static final int Cancelled               = 12;
        public static final int PendingTakeUpApproval   = 13;
        public static final int ReversalPending         = 14;

        private AllocStatusValues() {
        }

    }

    /**
     * Values for AllocRejCode(88).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>IndividualAllocRejCode(776)</li>
     * </ul>
     */
    public static class AllocRejCodeValues {

        public static final int UnknownAccount                         = 0;
        public static final int IncorrectQuantity                      = 1;
        public static final int IncorrectAveragePrice                  = 2;
        public static final int UnknownExecutingBrokerMnemonic         = 3;
        public static final int CommissionDifference                   = 4;
        public static final int UnknownOrderID                         = 5;
        public static final int UnknownListID                          = 6;
        public static final int OtherSeeText                           = 7;
        public static final int IncorrectAllocatedQuantity             = 8;
        public static final int CalculationDifference                  = 9;
        public static final int UnknownOrStaleExecID                   = 10;
        public static final int MismatchedData                         = 11;
        public static final int UnknownClOrdID                         = 12;
        public static final int WarehouseRequestRejected               = 13;
        public static final int DuplicateOrMissingIndividualAllocID    = 14;
        public static final int TradeNotRecognized                     = 15;
        public static final int DuplicateTrade                         = 16;
        public static final int IncorrectOrMissingInstrument           = 17;
        public static final int IncorrectOrMissingSettlDate            = 18;
        public static final int IncorrectOrMissingFundIDOrFundName     = 19;
        public static final int IncorrectOrMissingSettlInstructions    = 20;
        public static final int IncorrectOrMissingFees                 = 21;
        public static final int IncorrectOrMissingTax                  = 22;
        public static final int UnknownOrMissingParty                  = 23;
        public static final int IncorrectOrMissingSide                 = 24;
        public static final int IncorrectOrMissingNetMoney             = 25;
        public static final int IncorrectOrMissingTradeDate            = 26;
        public static final int IncorrectOrMissingSettlCcyInstructions = 27;
        public static final int IncorrectOrMissingProcessCode          = 28;
        public static final int Other                                  = 99;

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
     * Values for CxlRejReason(102).
     */
    public static class CxlRejReasonValues {

        public static final int TooLateToCancel                       = 0;
        public static final int UnknownOrder                          = 1;
        public static final int BrokerCredit                          = 2;
        public static final int OrderAlreadyInPendingStatus           = 3;
        public static final int UnableToProcessOrderMassCancelRequest = 4;
        public static final int OrigOrdModTime                        = 5;
        public static final int DuplicateClOrdID                      = 6;
        public static final int PriceExceedsCurrentPrice              = 7;
        public static final int PriceExceedsCurrentPriceBand          = 8;
        public static final int InvalidPriceIncrement                 = 18;
        public static final int Other                                 = 99;

        private CxlRejReasonValues() {
        }

    }

    /**
     * Values for OrdRejReason(103).
     */
    public static class OrdRejReasonValues {

        public static final int BrokerCredit                          = 0;
        public static final int UnknownSymbol                         = 1;
        public static final int ExchangeClosed                        = 2;
        public static final int OrderExceedsLimit                     = 3;
        public static final int TooLateToEnter                        = 4;
        public static final int UnknownOrder                          = 5;
        public static final int DuplicateOrder                        = 6;
        public static final int DuplicateOfAVerballyCommunicatedOrder = 7;
        public static final int StaleOrder                            = 8;
        public static final int TradeAlongRequired                    = 9;
        public static final int InvalidInvestorID                     = 10;
        public static final int UnsupportedOrderCharacteristic        = 11;
        public static final int SurveillanceOption                    = 12;
        public static final int IncorrectQuantity                     = 13;
        public static final int IncorrectAllocatedQuantity            = 14;
        public static final int UnknownAccount                        = 15;
        public static final int PriceExceedsCurrentPriceBand          = 16;
        public static final int InvalidPriceIncrement                 = 18;
        public static final int ReferencePriceNotAvailable            = 19;
        public static final int NotionalValueExceedsThreshold         = 20;
        public static final int AlgorithmRiskThresholdBreached        = 21;
        public static final int ShortSellNotPermitted                 = 22;
        public static final int ShortSellSecurityPreBorrowRestriction = 23;
        public static final int ShortSellAccountPreBorrowRestriction  = 24;
        public static final int InsufficientCreditLimit               = 25;
        public static final int ExceededClipSizeLimit                 = 26;
        public static final int ExceededMaxNotionalOrderAmt           = 27;
        public static final int ExceededDV01PV01Limit                 = 28;
        public static final int ExceededCS01Limit                     = 29;
        public static final int Other                                 = 99;

        private OrdRejReasonValues() {
        }

    }

    /**
     * Values for IOIQualifier(104).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>QuoteQualifier(695)</li>
     * </ul>
     */
    public static class IOIQualifierValues {

        public static final char AllOrNone              = 'A';
        public static final char MarketOnClose          = 'B';
        public static final char AtTheClose             = 'C';
        public static final char VWAP                   = 'D';
        public static final char Axe                    = 'E';
        public static final char AxeOnBid               = 'F';
        public static final char AxeOnOffer             = 'G';
        public static final char ClientNaturalWorking   = 'H';
        public static final char InTouchWith            = 'I';
        public static final char PositionWanted         = 'J';
        public static final char MarketMaking           = 'K';
        public static final char Limit                  = 'L';
        public static final char MoreBehind             = 'M';
        public static final char ClientNaturalBlock     = 'N';
        public static final char AtTheOpen              = 'O';
        public static final char TakingAPosition        = 'P';
        public static final char AtTheMarket            = 'Q';
        public static final char ReadyToTrade           = 'R';
        public static final char PortfolioShown         = 'S';
        public static final char ThroughTheDay          = 'T';
        public static final char Unwind                 = 'U';
        public static final char Versus                 = 'V';
        public static final char Indication             = 'W';
        public static final char CrossingOpportunity    = 'X';
        public static final char AtTheMidpoint          = 'Y';
        public static final char PreOpen                = 'Z';
        public static final char QuantityNegotiable     = '1';
        public static final char AllowLateBids          = '2';
        public static final char ImmediateOrCounter     = '3';
        public static final char AutoTrade              = '4';
        public static final char AutomaticSpot          = 'a';
        public static final char PlatformCalculatedSpot = 'b';
        public static final char OutsideSpread          = 'c';
        public static final char DeferredSpot           = 'd';
        public static final char NegotiatedSpot         = 'n';

        private IOIQualifierValues() {
        }

    }

    /**
     * Values for DKReason(127).
     */
    public static class DKReasonValues {

        public static final char UnknownSymbol             = 'A';
        public static final char WrongSide                 = 'B';
        public static final char QuantityExceedsOrder      = 'C';
        public static final char NoMatchingOrder           = 'D';
        public static final char PriceExceedsLimit         = 'E';
        public static final char CalculationDifference     = 'F';
        public static final char NoMatchingExecutionReport = 'G';
        public static final char Other                     = 'Z';

        private DKReasonValues() {
        }

    }

    /**
     * Values for MiscFeeType(139).
     */
    public static class MiscFeeTypeValues {

        public static final String Regulatory                 = "1";
        public static final String Tax                        = "2";
        public static final String LocalCommission            = "3";
        public static final String ExchangeFees               = "4";
        public static final String Stamp                      = "5";
        public static final String Levy                       = "6";
        public static final String Other                      = "7";
        public static final String Markup                     = "8";
        public static final String ConsumptionTax             = "9";
        public static final String PerTransaction             = "10";
        public static final String Conversion                 = "11";
        public static final String Agent                      = "12";
        public static final String TransferFee                = "13";
        public static final String SecurityLending            = "14";
        public static final String TradeReporting             = "15";
        public static final String TaxOnPrincipalAmount       = "16";
        public static final String TaxOnAccruedInterestAmount = "17";
        public static final String NewIssuanceFee             = "18";
        public static final String ServiceFee                 = "19";
        public static final String OddLotFee                  = "20";
        public static final String AuctionFee                 = "21";
        public static final String ValueAddedTax              = "22";
        public static final String SalesTax                   = "23";
        public static final String ExecutionFee               = "24";
        public static final String OrderEntryFee              = "25";
        public static final String OrderModificationFee       = "26";
        public static final String OrdersCancellationFee      = "27";
        public static final String MarketDataAccessFee        = "28";
        public static final String MarketDataTerminalFee      = "29";
        public static final String MarketDataVolumeFee        = "30";
        public static final String ClearingFee                = "31";
        public static final String SettlementFee              = "32";
        public static final String Rebates                    = "33";
        public static final String Discounts                  = "34";
        public static final String Payments                   = "35";
        public static final String NonMonetaryPayments        = "36";

        private MiscFeeTypeValues() {
        }

    }

    /**
     * Values for ExecType(150).
     */
    public static class ExecTypeValues {

        public static final char New                            = '0';
        public static final char DoneForDay                     = '3';
        public static final char Canceled                       = '4';
        public static final char Replaced                       = '5';
        public static final char PendingCancel                  = '6';
        public static final char Stopped                        = '7';
        public static final char Rejected                       = '8';
        public static final char Suspended                      = '9';
        public static final char PendingNew                     = 'A';
        public static final char Calculated                     = 'B';
        public static final char Expired                        = 'C';
        public static final char Restated                       = 'D';
        public static final char PendingReplace                 = 'E';
        public static final char Trade                          = 'F';
        public static final char TradeCorrect                   = 'G';
        public static final char TradeCancel                    = 'H';
        public static final char OrderStatus                    = 'I';
        public static final char TradeInAClearingHold           = 'J';
        public static final char TradeHasBeenReleasedToClearing = 'K';
        public static final char TriggeredOrActivatedBySystem   = 'L';
        public static final char Locked                         = 'M';
        public static final char Released                       = 'N';

        private ExecTypeValues() {
        }

    }

    /**
     * Values for SettlCurrFxRateCalc(156).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SettlPriceFxRateCalc(2366)</li>
     *   <li>LegReturnRateFXRateCalc(42533)</li>
     *   <li>ReturnRateFXRateCalc(42734)</li>
     *   <li>UnderlyingReturnRateFXRateCalc(43033)</li>
     * </ul>
     */
    public static class SettlCurrFxRateCalcValues {

        public static final char Multiply = 'M';
        public static final char Divide   = 'D';

        private SettlCurrFxRateCalcValues() {
        }

    }

    /**
     * Values for SettlInstMode(160).
     */
    public static class SettlInstModeValues {

        public static final char Default                             = '0';
        public static final char StandingInstructionsProvided        = '1';
        public static final char SpecificAllocationAccountOverriding = '2';
        public static final char SpecificAllocationAccountStanding   = '3';
        public static final char SpecificOrderForASingleAccount      = '4';
        public static final char RequestReject                       = '5';

        private SettlInstModeValues() {
        }

    }

    /**
     * Values for SettlInstTransType(163).
     */
    public static class SettlInstTransTypeValues {

        public static final char New     = 'N';
        public static final char Cancel  = 'C';
        public static final char Replace = 'R';
        public static final char Restate = 'T';

        private SettlInstTransTypeValues() {
        }

    }

    /**
     * Values for SettlInstSource(165).
     */
    public static class SettlInstSourceValues {

        public static final char BrokerCredit = '1';
        public static final char Institution  = '2';
        public static final char Investor     = '3';

        private SettlInstSourceValues() {
        }

    }

    /**
     * Values for SecurityType(167).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingSecurityType(310)</li>
     *   <li>LegSecurityType(609)</li>
     *   <li>DerivativeSecurityType(1249)</li>
     *   <li>InstrumentScopeSecurityType(1547)</li>
     *   <li>RelatedSecurityType(1652)</li>
     * </ul>
     */
    public static class SecurityTypeValues {

        public static final String EuroSupranationalCoupons                 = "EUSUPRA";
        public static final String CorporateBond                            = "CORP";
        public static final String ForeignExchangeContract                  = "FOR";
        public static final String CommonStock                              = "CS";
        public static final String Repurchase                               = "REPO";
        public static final String BradyBond                                = "BRADY";
        public static final String TermLoan                                 = "TERM";
        public static final String BankersAcceptance                        = "BA";
        public static final String AssetBackedSecurities                    = "ABS";
        public static final String OtherAnticipationNotes                   = "AN";
        public static final String MutualFund                               = "MF";
        public static final String FederalAgencyCoupon                      = "FAC";
        public static final String CorporatePrivatePlacement                = "CPP";
        public static final String NonDeliverableForward                    = "FXNDF";
        public static final String Cap                                      = "CAP";
        public static final String PreferredStock                           = "PS";
        public static final String Forward                                  = "FORWARD";
        public static final String CanadianTreasuryNotes                    = "CAN";
        public static final String RevolverLoan                             = "RVLV";
        public static final String BankDepositoryNote                       = "BDN";
        public static final String CanadianMortgageBonds                    = "CMB";
        public static final String CertificateOfObligation                  = "COFO";
        public static final String MultilegInstrument                       = "MLEG";
        public static final String FederalAgencyDiscountNote                = "FADN";
        public static final String ConvertibleBond                          = "CB";
        public static final String FXSpot                                   = "FXSPOT";
        public static final String CreditDefaultSwap                        = "CDS";
        public static final String DepositoryReceipts                       = "DR";
        public static final String BuySellback                              = "BUYSELL";
        public static final String CanadianTreasuryBills                    = "CTB";
        public static final String Revolver                                 = "RVLVTRM";
        public static final String BankNotes                                = "BN";
        public static final String Corp                                     = "CMBS";
        public static final String CertificateOfParticipation               = "COFP";
        public static final String NoSecurityType                           = "NONE";
        public static final String USTreasuryNoteOld                        = "UST";
        public static final String PrivateExportFunding                     = "PEF";
        public static final String DualCurrency                             = "DUAL";
        public static final String FXForward                                = "FXFWD";
        public static final String Collar                                   = "CLLR";
        public static final String SecuritiesLoan                           = "SECLOAN";
        public static final String EuroSovereigns                           = "EUSOV";
        public static final String BridgeLoan                               = "BRIDGE";
        public static final String BillOfExchanges                          = "BOX";
        public static final String CollateralizedMortgageObligation         = "CMO";
        public static final String GeneralObligationBonds                   = "GO";
        public static final String USTreasuryBillOld                        = "USTB";
        public static final String USDSupranationalCoupons                  = "SUPRA";
        public static final String EuroCorporateBond                        = "EUCORP";
        public static final String FXSwap                                   = "FXSWAP";
        public static final String CommoditySwap                            = "CMDTYSWAP";
        public static final String SecuritiesPledge                         = "SECPLEDGE";
        public static final String CanadianProvincialBonds                  = "PROV";
        public static final String LetterOfCredit                           = "LOFC";
        public static final String CanadianMoneyMarkets                     = "CAMM";
        public static final String IOETTEMortgage                           = "IET";
        public static final String MandatoryTender                          = "MT";
        public static final String EuroCorporateFloatingRateNotes           = "EUFRN";
        public static final String NonDeliverableSwap                       = "FXNDS";
        public static final String Exotic                                   = "EXOTIC";
        public static final String DeliveryVersusPledge                     = "DVPLDG";
        public static final String TreasuryBill                             = "TB";
        public static final String SwingLineFacility                        = "SWING";
        public static final String CertificateOfDeposit                     = "CD";
        public static final String MortgageBackedSecurities                 = "MBS";
        public static final String RevenueAnticipationNote                  = "RAN";
        public static final String Wildcard                                 = "?";
        public static final String USCorporateFloatingRateNotes             = "FRN";
        public static final String FXBankNote                               = "FXBN";
        public static final String OptionsOnCombo                           = "OOC";
        public static final String Floor                                    = "FLR";
        public static final String CollateralBasket                         = "COLLBSKT";
        public static final String USTreasuryBond                           = "TBOND";
        public static final String DebtorInPossession                       = "DINP";
        public static final String CallLoans                                = "CL";
        public static final String MortgageInterestOnly                     = "MIO";
        public static final String RevenueBonds                             = "REV";
        public static final String Cash                                     = "CASH";
        public static final String IndexedLinked                            = "XLINKD";
        public static final String ForeignCurrencyDiscountNote              = "FXDN";
        public static final String FRA                                      = "FRA";
        public static final String StructuredFinanceProduct                 = "SFP";
        public static final String InterestStripFromAnyBondOrNote           = "TINT";
        public static final String Defaulted                                = "DEFLTED";
        public static final String CommercialPaper                          = "CP";
        public static final String MortgagePrincipalOnly                    = "MPO";
        public static final String SpecialAssessment                        = "SPCLA";
        public static final String Other                                    = "Other";
        public static final String StructuredNotes                          = "STRUCT";
        public static final String Future                                   = "FUT";
        public static final String USTreasuryBill                           = "TBILL";
        public static final String TreasuryInflationProtectedSecurities     = "TIPS";
        public static final String Withdrawn                                = "WITHDRN";
        public static final String DepositNotes                             = "DN";
        public static final String MortgagePrivatePlacement                 = "MPP";
        public static final String SpecialObligation                        = "SPCLO";
        public static final String ExchangeTradedNote                       = "ETN";
        public static final String YankeeCorporateBond                      = "YANK";
        public static final String DerivativeForward                        = "FWD";
        public static final String MarginLoan                               = "MRGNLOAN";
        public static final String PrincipalStripOfACallableBondOrNote      = "TCAL";
        public static final String Replaced                                 = "REPLACD";
        public static final String EuroCertificateOfDeposit                 = "EUCD";
        public static final String MiscellaneousPassThrough                 = "MPT";
        public static final String SpecialTax                               = "SPCLT";
        public static final String OffshoreIssuedChineseYuanCorporateBond   = "DIMSUMCORP";
        public static final String InterestRateSwap                         = "IRS";
        public static final String TotalReturnSwap                          = "TRS";
        public static final String PrincipalStripFromANonCallableBondOrNote = "TPRN";
        public static final String Matured                                  = "MATURED";
        public static final String EuroCommercialPaper                      = "EUCP";
        public static final String Pfandbrief                               = "PFAND";
        public static final String TaxAnticipationNote                      = "TAN";
        public static final String SecuritizedDerivative                    = "SECDERIV";
        public static final String PreferredCorporateBond                   = "PRCORP";
        public static final String LoanLease                                = "LOANLEASE";
        public static final String USTreasuryNote                           = "TNOTE";
        public static final String Amended                                  = "AMENDED";
        public static final String LiquidityNote                            = "LQN";
        public static final String ToBeAnnounced                            = "TBA";
        public static final String TaxAllocation                            = "TAXA";
        public static final String ExchangeTradedFund                       = "ETF";
        public static final String OffshoreIssuedChineseYuanSovereignBond   = "DIMSUMSOV";
        public static final String Retired                                  = "RETIRED";
        public static final String MediumTermNotes                          = "MTN";
        public static final String TaxExemptCommercialPaper                 = "TECP";
        public static final String DigitalAsset                             = "DIGITAL";
        public static final String OptionsOnFutures                         = "OOF";
        public static final String SovereignBond                            = "SOV";
        public static final String Overnight                                = "ONITE";
        public static final String TaxableMunicipalCP                       = "TMCP";
        public static final String OptionsOnPhysical                        = "OOP";
        public static final String USTreasuryFloatingRateNote               = "TFRN";
        public static final String PromissoryNote                           = "PN";
        public static final String ShortTermLoanNote                        = "STN";
        public static final String TaxRevenueAnticipationNote               = "TRAN";
        public static final String Option                                   = "OPT";
        public static final String PlazosFijos                              = "PZFJ";
        public static final String VariableRateDemandNote                   = "VRDN";
        public static final String SpotForward                              = "SPOTFWD";
        public static final String SecuredLiquidityNote                     = "SLQN";
        public static final String Warrant                                  = "WAR";
        public static final String SwapOption                               = "SWAPTION";
        public static final String TimeDeposit                              = "TD";
        public static final String MunicipalInterestBearingCommercialPaper  = "MCPIB";
        public static final String Transmission                             = "XMISSION";
        public static final String TaxableMunicipalBond                     = "TMB";
        public static final String Index                                    = "INDEX";
        public static final String TermLiquidityNote                        = "TLQN";
        public static final String VariableRateDemandObligation             = "VRDO";
        public static final String BondBasket                               = "BDBSKT";
        public static final String ExtendedCommNote                         = "XCN";
        public static final String ContractForDifference                    = "CFD";
        public static final String YankeeCertificateOfDeposit               = "YCD";
        public static final String CorrelationSwap                          = "CRLTNSWAP";
        public static final String BankAcceptedBill                         = "BAB";
        public static final String DiviendSwap                              = "DVDNDSWAP";
        public static final String ShortTermBankNote                        = "BNST";
        public static final String EquityBasket                             = "EQBSKT";
        public static final String CallableCommercialPaper                  = "CLCP";
        public static final String EquityForward                            = "EQFWD";
        public static final String CommercialNote                           = "CN";
        public static final String ReturnSwap                               = "RTRNSWAP";
        public static final String InterestBearingCommercialPaper           = "CPIB";
        public static final String VarianceSwap                             = "VARSWAP";
        public static final String EuroMediumTermNote                       = "EUMTN";
        public static final String PortfolioSwaps                           = "PRTFLIOSWAP";
        public static final String EuroNegotiableCommercialPaper            = "EUNCP";
        public static final String FuturesOnASwap                           = "FUTSWAP";
        public static final String EuroStructuredLiquidityNote              = "EUSTLQN";
        public static final String ForwardsOnASwap                          = "FWDSWAP";
        public static final String EuroTimeDeposit                          = "EUTD";
        public static final String ForwardFreightAgreement                  = "FWDFRTAGMT";
        public static final String JumboCertificateOfDeposit                = "JCD";
        public static final String SpreadBetting                            = "SPREADBET";
        public static final String MoneyMarketFund                          = "MMF";
        public static final String ExchangeTradedCommodity                  = "ETC";
        public static final String MasterNote                               = "MN";
        public static final String NegotiableCertificateOfDeposit           = "NCD";
        public static final String NegotiableCommercialPaper                = "NCP";
        public static final String RetailCertificateOfDeposit               = "RCD";
        public static final String TermDepositReceipt                       = "TDR";

        private SecurityTypeValues() {
        }

    }

    /**
     * Values for StandInstDbType(169).
     */
    public static class StandInstDbTypeValues {

        public static final int Other            = 0;
        public static final int DTCSID           = 1;
        public static final int ThomsonALERT     = 2;
        public static final int AGlobalCustodian = 3;
        public static final int AccountNet       = 4;

        private StandInstDbTypeValues() {
        }

    }

    /**
     * Values for SettlDeliveryType(172).
     */
    public static class SettlDeliveryTypeValues {

        public static final int Versus        = 0;
        public static final int Free          = 1;
        public static final int TriParty      = 2;
        public static final int HoldInCustody = 3;

        private SettlDeliveryTypeValues() {
        }

    }

    /**
     * Values for AllocLinkType(197).
     */
    public static class AllocLinkTypeValues {

        public static final int FXNetting = 0;
        public static final int FXSwap    = 1;

        private AllocLinkTypeValues() {
        }

    }

    /**
     * Values for PutOrCall(201).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingPutOrCall(315)</li>
     *   <li>DerivativePutOrCall(1323)</li>
     *   <li>LegPutOrCall(1358)</li>
     *   <li>InstrumentScopePutOrCall(1553)</li>
     * </ul>
     */
    public static class PutOrCallValues {

        public static final int Put     = 0;
        public static final int Call    = 1;
        public static final int Other   = 2;
        public static final int Chooser = 3;

        private PutOrCallValues() {
        }

    }

    /**
     * Values for CoveredOrUncovered(203).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegCoveredOrUncovered(565)</li>
     * </ul>
     */
    public static class CoveredOrUncoveredValues {

        public static final int Covered   = 0;
        public static final int Uncovered = 1;

        private CoveredOrUncoveredValues() {
        }

    }

    /**
     * Values for AllocHandlInst(209).
     */
    public static class AllocHandlInstValues {

        public static final int Match           = 1;
        public static final int Forward         = 2;
        public static final int ForwardAndMatch = 3;
        public static final int AutoClaimGiveUp = 4;

        private AllocHandlInstValues() {
        }

    }

    /**
     * Values for RoutingType(216).
     */
    public static class RoutingTypeValues {

        public static final int TargetFirm   = 1;
        public static final int TargetList   = 2;
        public static final int BlockFirm    = 3;
        public static final int BlockList    = 4;
        public static final int TargetPerson = 5;
        public static final int BlockPerson  = 6;

        private RoutingTypeValues() {
        }

    }

    /**
     * Values for BenchmarkCurveName(221).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegBenchmarkCurveName(677)</li>
     * </ul>
     */
    public static class BenchmarkCurveNameValues {

        public static final String EONIA                = "EONIA";
        public static final String EUREPO               = "EUREPO";
        public static final String Euribor              = "Euribor";
        public static final String FutureSWAP           = "FutureSWAP";
        public static final String LIBID                = "LIBID";
        public static final String LIBOR                = "LIBOR";
        public static final String MuniAAA              = "MuniAAA";
        public static final String OTHER                = "OTHER";
        public static final String Pfandbriefe          = "Pfandbriefe";
        public static final String SONIA                = "SONIA";
        public static final String SWAP                 = "SWAP";
        public static final String Treasury             = "Treasury";
        public static final String FedFundRateEffective = "FEDEFF";
        public static final String FedOpen              = "FEDOPEN";
        public static final String EURIBOR              = "EURIBOR";
        public static final String AUBSW                = "AUBSW";
        public static final String BUBOR                = "BUBOR";
        public static final String CDOR                 = "CDOR";
        public static final String CIBOR                = "CIBOR";
        public static final String EONIASWAP            = "EONIASWAP";
        public static final String ESTR                 = "ESTR";
        public static final String EURODOLLAR           = "EURODOLLAR";
        public static final String EUROSWISS            = "EUROSWISS";
        public static final String GCFREPO              = "GCFREPO";
        public static final String ISDAFIX              = "ISDAFIX";
        public static final String JIBAR                = "JIBAR";
        public static final String MOSPRIM              = "MOSPRIM";
        public static final String NIBOR                = "NIBOR";
        public static final String PRIBOR               = "PRIBOR";
        public static final String SOFR                 = "SOFR";
        public static final String STIBOR               = "STIBOR";
        public static final String TELBOR               = "TELBOR";
        public static final String TIBOR                = "TIBOR";
        public static final String WIBOR                = "WIBOR";
        public static final String AONIA                = "AONIA";
        public static final String AONIAR               = "AONIA-R";
        public static final String BKBM                 = "BKBM";
        public static final String CD19D                = "CD91D";
        public static final String CORRA                = "CORRA";
        public static final String DIRRTN               = "DIRR-TN";
        public static final String EIBOR                = "EIBOR";
        public static final String FixingRepoRate       = "FixingRepoRate";
        public static final String HIBOR                = "HIBOR";
        public static final String IBR                  = "IBR";
        public static final String KLIBOR               = "KLIBOR";
        public static final String MIBOR                = "MIBOR";
        public static final String NZONIA               = "NZONIA";
        public static final String PHIREF               = "PHIREF";
        public static final String REIBOR               = "REIBOR";
        public static final String SAIBOR               = "SAIBOR";
        public static final String SARON                = "SARON";
        public static final String SORA                 = "SORA";
        public static final String TLREF                = "TLREF";
        public static final String TIIE                 = "TIIE";
        public static final String THBFIX               = "THBFIX";
        public static final String TONAR                = "TONAR";

        private BenchmarkCurveNameValues() {
        }

    }

    /**
     * Values for StipulationType(233).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegStipulationType(688)</li>
     *   <li>UnderlyingStipType(888)</li>
     * </ul>
     */
    public static class StipulationTypeValues {

        public static final String AlternativeMinimumTax                       = "AMT";
        public static final String IncurredRecovery                            = "INCURRCVY";
        public static final String AbsolutePrepaymentSpeed                     = "ABS";
        public static final String AutoReinvestment                            = "AUTOREINV";
        public static final String AdditionalTerm                              = "ADDTRM";
        public static final String ConstantPrepaymentPenalty                   = "CPP";
        public static final String BankQualified                               = "BANKQUAL";
        public static final String ModifiedEquityDelivery                      = "MODEQTYDLVY";
        public static final String ConstantPrepaymentRate                      = "CPR";
        public static final String BargainConditions                           = "BGNCON";
        public static final String NoReferenceOblication                       = "NOREFOBLIG";
        public static final String ConstantPrepaymentYield                     = "CPY";
        public static final String CouponRange                                 = "COUPON";
        public static final String UnknownReferenceObligation                  = "UNKREFOBLIG";
        public static final String FinalCPROfHomeEquityPrepaymentCurve         = "HEP";
        public static final String ISOCurrencyCode                             = "CURRENCY";
        public static final String AllGuarantees                               = "ALLGUARANTEES";
        public static final String PercentOfManufacturedHousingPrepaymentCurve = "MHP";
        public static final String CustomStart                                 = "CUSTOMDATE";
        public static final String ReferencePrice                              = "REFPX";
        public static final String MonthlyPrepaymentRate                       = "MPR";
        public static final String Geographics                                 = "GEOG";
        public static final String ReferencePolicy                             = "REFPOLICY";
        public static final String PercentOfProspectusPrepaymentCurve          = "PPC";
        public static final String ValuationDiscount                           = "HAIRCUT";
        public static final String SecuredList                                 = "SECRDLIST";
        public static final String PercentOfBMAPrepaymentCurve                 = "PSA";
        public static final String Insured                                     = "INSURED";
        public static final String SingleMonthlyMortality                      = "SMM";
        public static final String IssueDate                                   = "ISSUE";
        public static final String Issuer                                      = "ISSUER";
        public static final String IssueSizeRange                              = "ISSUESIZE";
        public static final String LookbackDays                                = "LOOKBACK";
        public static final String ExplicitLotIdentifier                       = "LOT";
        public static final String LotVariance                                 = "LOTVAR";
        public static final String MaturityYearAndMonth                        = "MAT";
        public static final String MaturityRange                               = "MATURITY";
        public static final String MaximumSubstitutions                        = "MAXSUBS";
        public static final String MinimumDenomination                         = "MINDNOM";
        public static final String MinimumIncrement                            = "MININCR";
        public static final String MinimumQuantity                             = "MINQTY";
        public static final String PaymentFrequency                            = "PAYFREQ";
        public static final String NumberOfPieces                              = "PIECES";
        public static final String PoolsMaximum                                = "PMAX";
        public static final String PoolsPerLot                                 = "PPL";
        public static final String PoolsPerMillion                             = "PPM";
        public static final String PoolsPerTrade                               = "PPT";
        public static final String PriceRange                                  = "PRICE";
        public static final String PricingFrequency                            = "PRICEFREQ";
        public static final String ProductionYear                              = "PROD";
        public static final String CallProtection                              = "PROTECT";
        public static final String Purpose                                     = "PURPOSE";
        public static final String BenchmarkPriceSource                        = "PXSOURCE";
        public static final String RatingSourceAndRange                        = "RATING";
        public static final String TypeOfRedemption                            = "REDEMPTION";
        public static final String Restricted                                  = "RESTRICTED";
        public static final String MarketSector                                = "SECTOR";
        public static final String SecurityTypeIncludedOrExcluded              = "SECTYPE";
        public static final String Structure                                   = "STRUCT";
        public static final String SubstitutionsFrequency                      = "SUBSFREQ";
        public static final String SubstitutionsLeft                           = "SUBSLEFT";
        public static final String FreeformText                                = "TEXT";
        public static final String TradeVariance                               = "TRDVAR";
        public static final String WeightedAverageCoupon                       = "WAC";
        public static final String WeightedAverageLifeCoupon                   = "WAL";
        public static final String WeightedAverageLoanAge                      = "WALA";
        public static final String WeightedAverageMaturity                     = "WAM";
        public static final String WholePool                                   = "WHOLE";
        public static final String YieldRange                                  = "YIELD";
        public static final String OriginalAmount                              = "ORIGAMT";
        public static final String AverageFICOScore                            = "AVFICO";
        public static final String PoolEffectiveDate                           = "POOLEFFDT";
        public static final String AverageLoanSize                             = "AVSIZE";
        public static final String PoolInitialFactor                           = "POOLINITFCTR";
        public static final String MaximumLoanBalance                          = "MAXBAL";
        public static final String Tranche                                     = "TRANCHE";
        public static final String PoolIdentifier                              = "POOL";
        public static final String Substitution                                = "SUBSTITUTION";
        public static final String TypeOfRollTrade                             = "ROLLTYPE";
        public static final String MULTEXCHFLLBCK                              = "MULTEXCHFLLBCK";
        public static final String ReferenceToRollingOrClosingTrade            = "REFTRADE";
        public static final String COMPSECFLLBCK                               = "COMPSECFLLBCK";
        public static final String PrincipalOfRollingOrClosingTrade            = "REFPRIN";
        public static final String LOCLJRSDCTN                                 = "LOCLJRSDCTN";
        public static final String InterestOfRollingOrClosingTrade             = "REFINT";
        public static final String RELVJRSDCTN                                 = "RELVJRSDCTN";
        public static final String AvailableOfferQuantityToBeShownToTheStreet  = "AVAILQTY";
        public static final String BrokerCredit                                = "BROKERCREDIT";
        public static final String OfferPriceToBeShownToInternalBrokers        = "INTERNALPX";
        public static final String OfferQuantityToBeShownToInternalBrokers     = "INTERNALQTY";
        public static final String TheMinimumResidualOfferQuantity             = "LEAVEQTY";
        public static final String MaximumOrderSize                            = "MAXORDQTY";
        public static final String OrderQuantityIncrement                      = "ORDRINCR";
        public static final String PrimaryOrSecondaryMarketIndicator           = "PRIMARY";
        public static final String BrokerSalesCreditOverride                   = "SALESCREDITOVR";
        public static final String TraderCredit                                = "TRADERCREDIT";
        public static final String DiscountRate                                = "DISCOUNT";
        public static final String YieldToMaturity                             = "YTM";
        public static final String InterestPayoffOfRollingOrAmendingTrade      = "PAYOFF";

        private StipulationTypeValues() {
        }

    }

    /**
     * Values for YieldType(235).
     */
    public static class YieldTypeValues {

        public static final String AfterTaxYield                 = "AFTERTAX";
        public static final String AnnualYield                   = "ANNUAL";
        public static final String YieldAtIssue                  = "ATISSUE";
        public static final String YieldToAverageMaturity        = "AVGMATURITY";
        public static final String BookYield                     = "BOOK";
        public static final String YieldToNextCall               = "CALL";
        public static final String YieldChangeSinceClose         = "CHANGE";
        public static final String ClosingYield                  = "CLOSE";
        public static final String CompoundYield                 = "COMPOUND";
        public static final String CurrentYield                  = "CURRENT";
        public static final String GvntEquivalentYield           = "GOVTEQUIV";
        public static final String TrueGrossYield                = "GROSS";
        public static final String YieldWithInflationAssumption  = "INFLATION";
        public static final String InverseFloaterBondYield       = "INVERSEFLOATER";
        public static final String MostRecentClosingYield        = "LASTCLOSE";
        public static final String ClosingYieldMostRecentMonth   = "LASTMONTH";
        public static final String ClosingYieldMostRecentQuarter = "LASTQUARTER";
        public static final String ClosingYieldMostRecentYear    = "LASTYEAR";
        public static final String YieldToLongestAverageLife     = "LONGAVGLIFE";
        public static final String MarkToMarketYield             = "MARK";
        public static final String YieldToMaturity               = "MATURITY";
        public static final String YieldToNextRefund             = "NEXTREFUND";
        public static final String OpenAverageYield              = "OPENAVG";
        public static final String PreviousCloseYield            = "PREVCLOSE";
        public static final String ProceedsYield                 = "PROCEEDS";
        public static final String YieldToNextPut                = "PUT";
        public static final String SemiAnnualYield               = "SEMIANNUAL";
        public static final String YieldToShortestAverageLife    = "SHORTAVGLIFE";
        public static final String SimpleYield                   = "SIMPLE";
        public static final String TaxEquivalentYield            = "TAXEQUIV";
        public static final String YieldToTenderDate             = "TENDER";
        public static final String TrueYield                     = "TRUE";
        public static final String YieldValueOf32nds             = "VALUE1_32";
        public static final String YieldToWorst                  = "WORST";

        private YieldTypeValues() {
        }

    }

    /**
     * Values for SubscriptionRequestType(263).
     */
    public static class SubscriptionRequestTypeValues {

        public static final char Snapshot                = '0';
        public static final char SnapshotAndUpdates      = '1';
        public static final char DisablePreviousSnapshot = '2';

        private SubscriptionRequestTypeValues() {
        }

    }

    /**
     * Values for MDUpdateType(265).
     */
    public static class MDUpdateTypeValues {

        public static final int FullRefresh        = 0;
        public static final int IncrementalRefresh = 1;

        private MDUpdateTypeValues() {
        }

    }

    /**
     * Values for MDEntryType(269).
     */
    public static class MDEntryTypeValues {

        public static final char Bid                                        = '0';
        public static final char Offer                                      = '1';
        public static final char Trade                                      = '2';
        public static final char IndexValue                                 = '3';
        public static final char OpeningPrice                               = '4';
        public static final char ClosingPrice                               = '5';
        public static final char SettlementPrice                            = '6';
        public static final char TradingSessionHighPrice                    = '7';
        public static final char TradingSessionLowPrice                     = '8';
        public static final char VWAP                                       = '9';
        public static final char Imbalance                                  = 'A';
        public static final char TradeVolume                                = 'B';
        public static final char OpenInterest                               = 'C';
        public static final char CompositeUnderlyingPrice                   = 'D';
        public static final char SimulatedSellPrice                         = 'E';
        public static final char SimulatedBuyPrice                          = 'F';
        public static final char MarginRate                                 = 'G';
        public static final char MidPrice                                   = 'H';
        public static final char EmptyBook                                  = 'J';
        public static final char SettleHighPrice                            = 'K';
        public static final char SettleLowPrice                             = 'L';
        public static final char PriorSettlePrice                           = 'M';
        public static final char SessionHighBid                             = 'N';
        public static final char SessionLowOffer                            = 'O';
        public static final char EarlyPrices                                = 'P';
        public static final char AuctionClearingPrice                       = 'Q';
        public static final char SwapValueFactor                            = 'S';
        public static final char DailyValueAdjustmentForLongPositions       = 'R';
        public static final char CumulativeValueAdjustmentForLongPositions  = 'T';
        public static final char DailyValueAdjustmentForShortPositions      = 'U';
        public static final char CumulativeValueAdjustmentForShortPositions = 'V';
        public static final char FixingPrice                                = 'W';
        public static final char CashRate                                   = 'X';
        public static final char RecoveryRate                               = 'Y';
        public static final char RecoveryRateForLong                        = 'Z';
        public static final char RecoveryRateForShort                       = 'a';
        public static final char MarketBid                                  = 'b';
        public static final char MarketOffer                                = 'c';
        public static final char ShortSaleMinPrice                          = 'd';
        public static final char PreviousClosingPrice                       = 'e';
        public static final char ThresholdLimitPriceBanding                 = 'g';
        public static final char DailyFinancingValue                        = 'h';
        public static final char AccruedFinancingValue                      = 'i';
        public static final char TWAP                                       = 't';

        private MDEntryTypeValues() {
        }

    }

    /**
     * Values for TickDirection(274).
     */
    public static class TickDirectionValues {

        public static final char PlusTick      = '0';
        public static final char ZeroPlusTick  = '1';
        public static final char MinusTick     = '2';
        public static final char ZeroMinusTick = '3';

        private TickDirectionValues() {
        }

    }

    /**
     * Values for QuoteCondition(276).
     */
    public static class QuoteConditionValues {

        public static final String Open                            = "A";
        public static final String Closed                          = "B";
        public static final String ExchangeBest                    = "C";
        public static final String ConsolidatedBest                = "D";
        public static final String Locked                          = "E";
        public static final String Crossed                         = "F";
        public static final String Depth                           = "G";
        public static final String FastTrading                     = "H";
        public static final String NonFirm                         = "I";
        public static final String Manual                          = "L";
        public static final String OutrightPrice                   = "J";
        public static final String ImpliedPrice                    = "K";
        public static final String DepthOnOffer                    = "M";
        public static final String DepthOnBid                      = "N";
        public static final String Closing                         = "O";
        public static final String NewsDissemination               = "P";
        public static final String TradingRange                    = "Q";
        public static final String OrderInflux                     = "R";
        public static final String DueToRelated                    = "S";
        public static final String NewsPending                     = "T";
        public static final String AdditionalInfo                  = "U";
        public static final String AdditionalInfoDueToRelated      = "V";
        public static final String Resume                          = "W";
        public static final String ViewOfCommon                    = "X";
        public static final String VolumeAlert                     = "Y";
        public static final String OrderImbalance                  = "Z";
        public static final String EquipmentChangeover             = "a";
        public static final String NoOpen                          = "b";
        public static final String RegularETH                      = "c";
        public static final String AutomaticExecution              = "d";
        public static final String AutomaticExecutionETH           = "e";
        public static final String FastMarketETH                   = "f";
        public static final String InactiveETH                     = "g";
        public static final String Rotation                        = "h";
        public static final String RotationETH                     = "i";
        public static final String Halt                            = "j";
        public static final String HaltETH                         = "k";
        public static final String DueToNewsDissemination          = "l";
        public static final String DueToNewsPending                = "m";
        public static final String TradingResume                   = "n";
        public static final String OutOfSequence                   = "o";
        public static final String BidSpecialist                   = "p";
        public static final String OfferSpecialist                 = "q";
        public static final String BidOfferSpecialist              = "r";
        public static final String EndOfDaySAM                     = "s";
        public static final String ForbiddenSAM                    = "t";
        public static final String FrozenSAM                       = "u";
        public static final String PreOpeningSAM                   = "v";
        public static final String OpeningSAM                      = "w";
        public static final String OpenSAM                         = "x";
        public static final String SurveillanceSAM                 = "y";
        public static final String SuspendedSAM                    = "z";
        public static final String ReservedSAM                     = "0";
        public static final String NoActiveSAM                     = "1";
        public static final String Restricted                      = "2";
        public static final String RestOfBookVWAP                  = "3";
        public static final String BetterPricesInConditionalOrders = "4";
        public static final String MedianPrice                     = "5";
        public static final String FullCurve                       = "6";
        public static final String FlatCurve                       = "7";

        private QuoteConditionValues() {
        }

    }

    /**
     * Values for TradeCondition(277).
     */
    public static class TradeConditionValues {

        public static final String Cash                                = "A";
        public static final String AveragePriceTrade                   = "B";
        public static final String CashTrade                           = "C";
        public static final String NextDay                             = "D";
        public static final String Opening                             = "E";
        public static final String IntradayTradeDetail                 = "F";
        public static final String Rule127Trade                        = "G";
        public static final String Rule155Trade                        = "H";
        public static final String SoldLast                            = "I";
        public static final String NextDayTrade                        = "J";
        public static final String Opened                              = "K";
        public static final String Seller                              = "L";
        public static final String Sold                                = "M";
        public static final String StoppedStock                        = "N";
        public static final String ImbalanceMoreBuyers                 = "P";
        public static final String ImbalanceMoreSellers                = "Q";
        public static final String OpeningPrice                        = "R";
        public static final String BargainCondition                    = "S";
        public static final String ConvertedPriceIndicator             = "T";
        public static final String ExchangeLast                        = "U";
        public static final String FinalPriceOfSession                 = "V";
        public static final String ExPit                               = "W";
        public static final String Crossed                             = "X";
        public static final String TradesResultingFromManual           = "Y";
        public static final String TradesResultingFromIntermarketSweep = "Z";
        public static final String VolumeOnly                          = "a";
        public static final String DirectPlus                          = "b";
        public static final String Acquisition                         = "c";
        public static final String Bunched                             = "d";
        public static final String Distribution                        = "e";
        public static final String BunchedSale                         = "f";
        public static final String SplitTrade                          = "g";
        public static final String CancelStopped                       = "h";
        public static final String CancelETH                           = "i";
        public static final String CancelStoppedETH                    = "j";
        public static final String OutOfSequenceETH                    = "k";
        public static final String CancelLastETH                       = "l";
        public static final String SoldLastSaleETH                     = "m";
        public static final String CancelLast                          = "n";
        public static final String SoldLastSale                        = "o";
        public static final String CancelOpen                          = "p";
        public static final String CancelOpenETH                       = "q";
        public static final String OpenedSaleETH                       = "r";
        public static final String CancelOnly                          = "s";
        public static final String CancelOnlyETH                       = "t";
        public static final String LateOpenETH                         = "u";
        public static final String AutoExecutionETH                    = "v";
        public static final String Reopen                              = "w";
        public static final String ReopenETH                           = "x";
        public static final String Adjusted                            = "y";
        public static final String AdjustedETH                         = "z";
        public static final String Spread                              = "AA";
        public static final String SpreadETH                           = "AB";
        public static final String Straddle                            = "AC";
        public static final String StraddleETH                         = "AD";
        public static final String Stopped                             = "AE";
        public static final String StoppedETH                          = "AF";
        public static final String RegularETH                          = "AG";
        public static final String Combo                               = "AH";
        public static final String ComboETH                            = "AI";
        public static final String OfficialClosingPrice                = "AJ";
        public static final String PriorReferencePrice                 = "AK";
        public static final String Cancel                              = "0";
        public static final String StoppedSoldLast                     = "AL";
        public static final String StoppedOutOfSequence                = "AM";
        public static final String OfficialClosingPriceDup             = "AN";
        public static final String CrossedOld                          = "AO";
        public static final String FastMarket                          = "AP";
        public static final String AutomaticExecution                  = "AQ";
        public static final String FormT                               = "AR";
        public static final String BasketIndex                         = "AS";
        public static final String BurstBasket                         = "AT";
        public static final String TradeThroughExempt                  = "AU";
        public static final String QuoteSpread                         = "AV";
        public static final String LastAuctionPrice                    = "AW";
        public static final String HighPrice                           = "AX";
        public static final String LowPrice                            = "AY";
        public static final String SystematicInternaliser              = "AZ";
        public static final String AwayMarket                          = "BA";
        public static final String MidpointPrice                       = "BB";
        public static final String TradedBeforeIssueDate               = "BC";
        public static final String PreviousClosingPrice                = "BD";
        public static final String NationalBestBidOffer                = "BE";
        public static final String ImpliedTrade                        = "1";
        public static final String MarketplaceEnteredTrade             = "2";
        public static final String MultiAssetClassMultilegTrade        = "3";
        public static final String MultilegToMultilegTrade             = "4";
        public static final String ShortSaleMinPrice                   = "5";
        public static final String Benchmark                           = "6";

        private TradeConditionValues() {
        }

    }

    /**
     * Values for MDUpdateAction(279).
     */
    public static class MDUpdateActionValues {

        public static final char New        = '0';
        public static final char Change     = '1';
        public static final char Delete     = '2';
        public static final char DeleteThru = '3';
        public static final char DeleteFrom = '4';
        public static final char Overlay    = '5';

        private MDUpdateActionValues() {
        }

    }

    /**
     * Values for MDReqRejReason(281).
     */
    public static class MDReqRejReasonValues {

        public static final char UnknownSymbol                      = '0';
        public static final char DuplicateMDReqID                   = '1';
        public static final char InsufficientBandwidth              = '2';
        public static final char InsufficientPermissions            = '3';
        public static final char UnsupportedSubscriptionRequestType = '4';
        public static final char UnsupportedMarketDepth             = '5';
        public static final char UnsupportedMDUpdateType            = '6';
        public static final char UnsupportedAggregatedBook          = '7';
        public static final char UnsupportedMDEntryType             = '8';
        public static final char UnsupportedTradingSessionID        = '9';
        public static final char UnsupportedScope                   = 'A';
        public static final char UnsupportedOpenCloseSettleFlag     = 'B';
        public static final char UnsupportedMDImplicitDelete        = 'C';
        public static final char InsufficientCredit                 = 'D';

        private MDReqRejReasonValues() {
        }

    }

    /**
     * Values for DeleteReason(285).
     */
    public static class DeleteReasonValues {

        public static final char Cancellation = '0';
        public static final char Error        = '1';

        private DeleteReasonValues() {
        }

    }

    /**
     * Values for OpenCloseSettlFlag(286).
     */
    public static class OpenCloseSettlFlagValues {

        public static final char DailyOpen                    = '0';
        public static final char SessionOpen                  = '1';
        public static final char DeliverySettlementEntry      = '2';
        public static final char ExpectedEntry                = '3';
        public static final char EntryFromPreviousBusinessDay = '4';
        public static final char TheoreticalPriceValue        = '5';

        private OpenCloseSettlFlagValues() {
        }

    }

    /**
     * Values for FinancialStatus(291).
     */
    public static class FinancialStatusValues {

        public static final char Bankrupt         = '1';
        public static final char PendingDelisting = '2';
        public static final char Restricted       = '3';

        private FinancialStatusValues() {
        }

    }

    /**
     * Values for CorporateAction(292).
     */
    public static class CorporateActionValues {

        public static final char ExDividend                = 'A';
        public static final char ExDistribution            = 'B';
        public static final char ExRights                  = 'C';
        public static final char New                       = 'D';
        public static final char ExInterest                = 'E';
        public static final char CashDividend              = 'F';
        public static final char StockDividend             = 'G';
        public static final char NonIntegerStockSplit      = 'H';
        public static final char ReverseStockSplit         = 'I';
        public static final char StandardIntegerStockSplit = 'J';
        public static final char PositionConsolidation     = 'K';
        public static final char LiquidationReorganization = 'L';
        public static final char MergerReorganization      = 'M';
        public static final char RightsOffering            = 'N';
        public static final char ShareholderMeeting        = 'O';
        public static final char Spinoff                   = 'P';
        public static final char TenderOffer               = 'Q';
        public static final char Warrant                   = 'R';
        public static final char SpecialAction             = 'S';
        public static final char SymbolConversion          = 'T';
        public static final char CUSIP                     = 'U';
        public static final char LeapRollover              = 'V';
        public static final char SuccessionEvent           = 'W';

        private CorporateActionValues() {
        }

    }

    /**
     * Values for QuoteStatus(297).
     */
    public static class QuoteStatusValues {

        public static final int Accepted                      = 0;
        public static final int CancelForSymbol               = 1;
        public static final int CanceledForSecurityType       = 2;
        public static final int CanceledForUnderlying         = 3;
        public static final int CanceledAll                   = 4;
        public static final int Rejected                      = 5;
        public static final int RemovedFromMarket             = 6;
        public static final int Expired                       = 7;
        public static final int Query                         = 8;
        public static final int QuoteNotFound                 = 9;
        public static final int Pending                       = 10;
        public static final int Pass                          = 11;
        public static final int LockedMarketWarning           = 12;
        public static final int CrossMarketWarning            = 13;
        public static final int CanceledDueToLockMarket       = 14;
        public static final int CanceledDueToCrossMarket      = 15;
        public static final int Active                        = 16;
        public static final int Canceled                      = 17;
        public static final int UnsolicitedQuoteReplenishment = 18;
        public static final int PendingEndTrade               = 19;
        public static final int TooLateToEnd                  = 20;
        public static final int Traded                        = 21;
        public static final int TradedAndRemoved              = 22;
        public static final int ContractTerminates            = 23;

        private QuoteStatusValues() {
        }

    }

    /**
     * Values for QuoteCancelType(298).
     */
    public static class QuoteCancelTypeValues {

        public static final int CancelForOneOrMoreSecurities        = 1;
        public static final int CancelForSecurityType               = 2;
        public static final int CancelForUnderlyingSecurity         = 3;
        public static final int CancelAllQuotes                     = 4;
        public static final int CancelSpecifiedSingleQuote          = 5;
        public static final int CancelByTypeOfQuote                 = 6;
        public static final int CancelForSecurityIssuer             = 7;
        public static final int CancelForIssuerOfUnderlyingSecurity = 8;

        private QuoteCancelTypeValues() {
        }

    }

    /**
     * Values for QuoteRejectReason(300).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>QuoteEntryRejectReason(368)</li>
     * </ul>
     */
    public static class QuoteRejectReasonValues {

        public static final int UnknownSymbol                              = 1;
        public static final int Exchange                                   = 2;
        public static final int QuoteRequestExceedsLimit                   = 3;
        public static final int TooLateToEnter                             = 4;
        public static final int UnknownQuote                               = 5;
        public static final int DuplicateQuote                             = 6;
        public static final int InvalidBid                                 = 7;
        public static final int InvalidPrice                               = 8;
        public static final int NotAuthorizedToQuoteSecurity               = 9;
        public static final int PriceExceedsCurrentPriceBand               = 10;
        public static final int QuoteLocked                                = 11;
        public static final int InvalidOrUnknownSecurityIssuer             = 12;
        public static final int InvalidOrUnknownIssuerOfUnderlyingSecurity = 13;
        public static final int NotionalValueExceedsThreshold              = 14;
        public static final int PriceExceedsCurrentPriceBandDepr           = 15;
        public static final int ReferencePriceNotAvailable                 = 16;
        public static final int InsufficientCreditLimit                    = 17;
        public static final int ExceededClipSizeLimit                      = 18;
        public static final int ExceededMaxNotionalOrderAmt                = 19;
        public static final int ExceededDV01PV01Limit                      = 20;
        public static final int ExceededCS01Limit                          = 21;
        public static final int Other                                      = 99;

        private QuoteRejectReasonValues() {
        }

    }

    /**
     * Values for QuoteResponseLevel(301).
     */
    public static class QuoteResponseLevelValues {

        public static final int NoAcknowledgement                        = 0;
        public static final int AcknowledgeOnlyNegativeOrErroneousQuotes = 1;
        public static final int AcknowledgeEachQuoteMessage              = 2;
        public static final int SummaryAcknowledgement                   = 3;

        private QuoteResponseLevelValues() {
        }

    }

    /**
     * Values for QuoteRequestType(303).
     */
    public static class QuoteRequestTypeValues {

        public static final int Manual       = 1;
        public static final int Automatic    = 2;
        public static final int ConfirmQuote = 3;

        private QuoteRequestTypeValues() {
        }

    }

    /**
     * Values for SecurityRequestType(321).
     */
    public static class SecurityRequestTypeValues {

        public static final int RequestSecurityIdentityAndSpecifications = 0;
        public static final int RequestSecurityIdentityForSpecifications = 1;
        public static final int RequestListSecurityTypes                 = 2;
        public static final int RequestListSecurities                    = 3;
        public static final int Symbol                                   = 4;
        public static final int SecurityTypeAndOrCFICode                 = 5;
        public static final int Product                                  = 6;
        public static final int TradingSessionID                         = 7;
        public static final int AllSecurities                            = 8;
        public static final int MarketIDOrMarketID                       = 9;

        private SecurityRequestTypeValues() {
        }

    }

    /**
     * Values for SecurityResponseType(323).
     */
    public static class SecurityResponseTypeValues {

        public static final int AcceptAsIs                            = 1;
        public static final int AcceptWithRevisions                   = 2;
        public static final int ListOfSecurityTypesReturnedPerRequest = 3;
        public static final int ListOfSecuritiesReturnedPerRequest    = 4;
        public static final int RejectSecurityProposal                = 5;
        public static final int CannotMatchSelectionCriteria          = 6;

        private SecurityResponseTypeValues() {
        }

    }

    /**
     * Values for SecurityTradingStatus(326).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SecurityMassTradingStatus(1679)</li>
     *   <li>MDSecurityTradingStatus(1682)</li>
     * </ul>
     */
    public static class SecurityTradingStatusValues {

        public static final int OpeningDelay               = 1;
        public static final int TradingHalt                = 2;
        public static final int Resume                     = 3;
        public static final int NoOpen                     = 4;
        public static final int PriceIndication            = 5;
        public static final int TradingRangeIndication     = 6;
        public static final int MarketImbalanceBuy         = 7;
        public static final int MarketImbalanceSell        = 8;
        public static final int MarketOnCloseImbalanceBuy  = 9;
        public static final int MarketOnCloseImbalanceSell = 10;
        public static final int NoMarketImbalance          = 12;
        public static final int NoMarketOnCloseImbalance   = 13;
        public static final int ITSPreOpening              = 14;
        public static final int NewPriceIndication         = 15;
        public static final int TradeDisseminationTime     = 16;
        public static final int ReadyToTrade               = 17;
        public static final int NotAvailableForTrading     = 18;
        public static final int NotTradedOnThisMarket      = 19;
        public static final int UnknownOrInvalid           = 20;
        public static final int PreOpen                    = 21;
        public static final int OpeningRotation            = 22;
        public static final int FastMarket                 = 23;
        public static final int PreCross                   = 24;
        public static final int Cross                      = 25;
        public static final int PostClose                  = 26;
        public static final int NoCancel                   = 27;

        private SecurityTradingStatusValues() {
        }

    }

    /**
     * Values for HaltReason(327).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>MassHaltReason(1681)</li>
     *   <li>MDHaltReason(1684)</li>
     * </ul>
     */
    public static class HaltReasonValues {

        public static final int NewsDissemination     = 0;
        public static final int OrderInflux           = 1;
        public static final int OrderImbalance        = 2;
        public static final int AdditionalInformation = 3;
        public static final int NewsPending           = 4;
        public static final int EquipmentChangeover   = 5;

        private HaltReasonValues() {
        }

    }

    /**
     * Values for Adjustment(334).
     */
    public static class AdjustmentValues {

        public static final int Cancel     = 1;
        public static final int Error      = 2;
        public static final int Correction = 3;

        private AdjustmentValues() {
        }

    }

    /**
     * Values for TradingSessionID(336).
     */
    public static class TradingSessionIDValues {

        public static final String Day        = "1";
        public static final String HalfDay    = "2";
        public static final String Morning    = "3";
        public static final String Afternoon  = "4";
        public static final String Evening    = "5";
        public static final String AfterHours = "6";
        public static final String Holiday    = "7";

        private TradingSessionIDValues() {
        }

    }

    /**
     * Values for TradSesMethod(338).
     */
    public static class TradSesMethodValues {

        public static final int Electronic = 1;
        public static final int OpenOutcry = 2;
        public static final int TwoParty   = 3;
        public static final int Voice      = 4;

        private TradSesMethodValues() {
        }

    }

    /**
     * Values for TradSesMode(339).
     */
    public static class TradSesModeValues {

        public static final int Testing    = 1;
        public static final int Simulated  = 2;
        public static final int Production = 3;

        private TradSesModeValues() {
        }

    }

    /**
     * Values for TradSesStatus(340).
     */
    public static class TradSesStatusValues {

        public static final int Unknown         = 0;
        public static final int Halted          = 1;
        public static final int Open            = 2;
        public static final int Closed          = 3;
        public static final int PreOpen         = 4;
        public static final int PreClose        = 5;
        public static final int RequestRejected = 6;

        private TradSesStatusValues() {
        }

    }

    /**
     * Values for SessionRejectReason(373).
     */
    public static class SessionRejectReasonValues {

        public static final int InvalidTagNumber                          = 0;
        public static final int RequiredTagMissing                        = 1;
        public static final int TagNotDefinedForThisMessageType           = 2;
        public static final int UndefinedTag                              = 3;
        public static final int TagSpecifiedWithoutAValue                 = 4;
        public static final int ValueIsIncorrect                          = 5;
        public static final int IncorrectDataFormatForValue               = 6;
        public static final int DecryptionProblem                         = 7;
        public static final int SignatureProblem                          = 8;
        public static final int CompIDProblem                             = 9;
        public static final int SendingTimeAccuracyProblem                = 10;
        public static final int InvalidMsgType                            = 11;
        public static final int XMLValidationError                        = 12;
        public static final int TagAppearsMoreThanOnce                    = 13;
        public static final int TagSpecifiedOutOfRequiredOrder            = 14;
        public static final int RepeatingGroupFieldsOutOfOrder            = 15;
        public static final int IncorrectNumInGroupCountForRepeatingGroup = 16;
        public static final int NonDataValueIncludesFieldDelimiter        = 17;
        public static final int InvalidUnsupportedApplVer                 = 18;
        public static final int Other                                     = 99;

        private SessionRejectReasonValues() {
        }

    }

    /**
     * Values for BidRequestTransType(374).
     */
    public static class BidRequestTransTypeValues {

        public static final char Cancel = 'C';
        public static final char New    = 'N';

        private BidRequestTransTypeValues() {
        }

    }

    /**
     * Values for ExecRestatementReason(378).
     */
    public static class ExecRestatementReasonValues {

        public static final int GTCorporateAction               = 0;
        public static final int GTRenewal                       = 1;
        public static final int VerbalChange                    = 2;
        public static final int RepricingOfOrder                = 3;
        public static final int BrokerOption                    = 4;
        public static final int PartialDeclineOfOrderQty        = 5;
        public static final int CancelOnTradingHalt             = 6;
        public static final int CancelOnSystemFailure           = 7;
        public static final int Market                          = 8;
        public static final int Canceled                        = 9;
        public static final int WarehouseRecap                  = 10;
        public static final int PegRefresh                      = 11;
        public static final int CancelOnConnectionLoss          = 12;
        public static final int CancelOnLogout                  = 13;
        public static final int AssignTimePriority              = 14;
        public static final int CancelledForTradePriceViolation = 15;
        public static final int CancelledForCrossImbalance      = 16;
        public static final int Other                           = 99;

        private ExecRestatementReasonValues() {
        }

    }

    /**
     * Values for BusinessRejectReason(380).
     */
    public static class BusinessRejectReasonValues {

        public static final int Other                                    = 0;
        public static final int UnknownID                                = 1;
        public static final int UnknownSecurity                          = 2;
        public static final int UnsupportedMessageType                   = 3;
        public static final int ApplicationNotAvailable                  = 4;
        public static final int ConditionallyRequiredFieldMissing        = 5;
        public static final int NotAuthorized                            = 6;
        public static final int DeliverToFirmNotAvailableAtThisTime      = 7;
        public static final int ThrottleLimitExceeded                    = 8;
        public static final int ThrottleLimitExceededSessionDisconnected = 9;
        public static final int ThrottledMessagesRejectedOnRequest       = 10;
        public static final int InvalidPriceIncrement                    = 18;

        private BusinessRejectReasonValues() {
        }

    }

    /**
     * Values for MsgDirection(385).
     */
    public static class MsgDirectionValues {

        public static final char Receive = 'R';
        public static final char Send    = 'S';

        private MsgDirectionValues() {
        }

    }

    /**
     * Values for DiscretionInst(388).
     */
    public static class DiscretionInstValues {

        public static final char RelatedToDisplayedPrice    = '0';
        public static final char RelatedToMarketPrice       = '1';
        public static final char RelatedToPrimaryPrice      = '2';
        public static final char RelatedToLocalPrimaryPrice = '3';
        public static final char RelatedToMidpointPrice     = '4';
        public static final char RelatedToLastTradePrice    = '5';
        public static final char RelatedToVWAP              = '6';
        public static final char AveragePriceGuarantee      = '7';

        private DiscretionInstValues() {
        }

    }

    /**
     * Values for BidType(394).
     */
    public static class BidTypeValues {

        public static final int NonDisclosed     = 1;
        public static final int Disclosed        = 2;
        public static final int NoBiddingProcess = 3;

        private BidTypeValues() {
        }

    }

    /**
     * Values for BidDescriptorType(399).
     */
    public static class BidDescriptorTypeValues {

        public static final int Sector  = 1;
        public static final int Country = 2;
        public static final int Index   = 3;

        private BidDescriptorTypeValues() {
        }

    }

    /**
     * Values for SideValueInd(401).
     */
    public static class SideValueIndValues {

        public static final int SideValue1 = 1;
        public static final int SideValue2 = 2;

        private SideValueIndValues() {
        }

    }

    /**
     * Values for LiquidityIndType(409).
     */
    public static class LiquidityIndTypeValues {

        public static final int FiveDayMovingAverage   = 1;
        public static final int TwentyDayMovingAverage = 2;
        public static final int NormalMarketSize       = 3;
        public static final int Other                  = 4;

        private LiquidityIndTypeValues() {
        }

    }

    /**
     * Values for ProgRptReqs(414).
     */
    public static class ProgRptReqsValues {

        public static final int BuySideRequests          = 1;
        public static final int SellSideSends            = 2;
        public static final int RealTimeExecutionReports = 3;

        private ProgRptReqsValues() {
        }

    }

    /**
     * Values for IncTaxInd(416).
     */
    public static class IncTaxIndValues {

        public static final int Net   = 1;
        public static final int Gross = 2;

        private IncTaxIndValues() {
        }

    }

    /**
     * Values for BidTradeType(418).
     */
    public static class BidTradeTypeValues {

        public static final char Agency          = 'A';
        public static final char VWAPGuarantee   = 'G';
        public static final char GuaranteedClose = 'J';
        public static final char RiskTrade       = 'R';

        private BidTradeTypeValues() {
        }

    }

    /**
     * Values for BasisPxType(419).
     */
    public static class BasisPxTypeValues {

        public static final char ClosingPriceAtMorningSession        = '2';
        public static final char ClosingPrice                        = '3';
        public static final char CurrentPrice                        = '4';
        public static final char SQ                                  = '5';
        public static final char VWAPThroughADay                     = '6';
        public static final char VWAPThroughAMorningSession          = '7';
        public static final char VWAPThroughAnAfternoonSession       = '8';
        public static final char VWAPThroughADayExcept               = '9';
        public static final char VWAPThroughAMorningSessionExcept    = 'A';
        public static final char VWAPThroughAnAfternoonSessionExcept = 'B';
        public static final char Strike                              = 'C';
        public static final char Open                                = 'D';
        public static final char Others                              = 'Z';

        private BasisPxTypeValues() {
        }

    }

    /**
     * Values for PriceType(423).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>BenchmarkPriceType(663)</li>
     *   <li>LegBenchmarkPriceType(680)</li>
     *   <li>LegPriceType(686)</li>
     *   <li>YieldRedemptionPriceType(698)</li>
     *   <li>PosAmtPriceType(2877)</li>
     *   <li>PaymentPriceType(40919)</li>
     * </ul>
     */
    public static class PriceTypeValues {

        public static final int Percentage                     = 1;
        public static final int PerUnit                        = 2;
        public static final int FixedAmount                    = 3;
        public static final int Discount                       = 4;
        public static final int Premium                        = 5;
        public static final int Spread                         = 6;
        public static final int TEDPrice                       = 7;
        public static final int TEDYield                       = 8;
        public static final int Yield                          = 9;
        public static final int FixedCabinetTradePrice         = 10;
        public static final int VariableCabinetTradePrice      = 11;
        public static final int PriceSpread                    = 12;
        public static final int ProductTicksInHalves           = 13;
        public static final int ProductTicksInFourths          = 14;
        public static final int ProductTicksInEighths          = 15;
        public static final int ProductTicksInSixteenths       = 16;
        public static final int ProductTicksInThirtySeconds    = 17;
        public static final int ProductTicksInSixtyFourths     = 18;
        public static final int ProductTicksInOneTwentyEighths = 19;
        public static final int NormalRateRepresentation       = 20;
        public static final int InverseRateRepresentation      = 21;
        public static final int BasisPoints                    = 22;
        public static final int UpfrontPoints                  = 23;
        public static final int InterestRate                   = 24;
        public static final int PercentageNotional             = 25;

        private PriceTypeValues() {
        }

    }

    /**
     * Values for GTBookingInst(427).
     */
    public static class GTBookingInstValues {

        public static final int BookOutAllTradesOnDayOfExecution         = 0;
        public static final int AccumulateUntilFilledOrExpired           = 1;
        public static final int AccumulateUntilVerballyNotifiedOtherwise = 2;

        private GTBookingInstValues() {
        }

    }

    /**
     * Values for ListStatusType(429).
     */
    public static class ListStatusTypeValues {

        public static final int Ack         = 1;
        public static final int Response    = 2;
        public static final int Timed       = 3;
        public static final int ExecStarted = 4;
        public static final int AllDone     = 5;
        public static final int Alert       = 6;

        private ListStatusTypeValues() {
        }

    }

    /**
     * Values for NetGrossInd(430).
     */
    public static class NetGrossIndValues {

        public static final int Net   = 1;
        public static final int Gross = 2;

        private NetGrossIndValues() {
        }

    }

    /**
     * Values for ListOrderStatus(431).
     */
    public static class ListOrderStatusValues {

        public static final int InBiddingProcess     = 1;
        public static final int ReceivedForExecution = 2;
        public static final int Executing            = 3;
        public static final int Cancelling           = 4;
        public static final int Alert                = 5;
        public static final int AllDone              = 6;
        public static final int Reject               = 7;

        private ListOrderStatusValues() {
        }

    }

    /**
     * Values for ListExecInstType(433).
     */
    public static class ListExecInstTypeValues {

        public static final char Immediate             = '1';
        public static final char WaitForInstruction    = '2';
        public static final char SellDriven            = '3';
        public static final char BuyDrivenCashTopUp    = '4';
        public static final char BuyDrivenCashWithdraw = '5';

        private ListExecInstTypeValues() {
        }

    }

    /**
     * Values for CxlRejResponseTo(434).
     */
    public static class CxlRejResponseToValues {

        public static final char OrderCancelRequest        = '1';
        public static final char OrderCancelReplaceRequest = '2';

        private CxlRejResponseToValues() {
        }

    }

    /**
     * Values for MultiLegReportingType(442).
     */
    public static class MultiLegReportingTypeValues {

        public static final char SingleSecurity                   = '1';
        public static final char IndividualLegOfAMultiLegSecurity = '2';
        public static final char MultiLegSecurity                 = '3';

        private MultiLegReportingTypeValues() {
        }

    }

    /**
     * Values for PartyIDSource(447).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>NestedPartyIDSource(525)</li>
     *   <li>Nested2PartyIDSource(758)</li>
     *   <li>SettlPartyIDSource(783)</li>
     *   <li>Nested3PartyIDSource(950)</li>
     *   <li>InstrumentPartyIDSource(1050)</li>
     *   <li>UnderlyingInstrumentPartyIDSource(1060)</li>
     *   <li>RootPartyIDSource(1118)</li>
     *   <li>DerivativeInstrumentPartyIDSource(1294)</li>
     *   <li>Nested4PartyIDSource(1416)</li>
     *   <li>TargetPartyIDSource(1463)</li>
     *   <li>PartyDetailAltIDSource(1518)</li>
     *   <li>RelatedPartyDetailIDSource(1564)</li>
     *   <li>RelatedPartyDetailAltIDSource(1571)</li>
     *   <li>RequestingPartyIDSource(1659)</li>
     *   <li>PartyDetailIDSource(1692)</li>
     *   <li>LegInstrumentPartyIDSource(2256)</li>
     *   <li>ProvisionPartyIDSource(40176)</li>
     *   <li>PaymentSettlPartyIDSource(40235)</li>
     *   <li>LegProvisionPartyIDSource(40535)</li>
     *   <li>UnderlyingProvisionPartyIDSource(42175)</li>
     * </ul>
     */
    public static class PartyIDSourceValues {

        public static final char UKNationalInsuranceOrPensionNumber = '6';
        public static final char KoreanInvestorID                   = '1';
        public static final char ISITCAcronym                       = 'I';
        public static final char BIC                                = 'B';
        public static final char USSocialSecurityNumber             = '7';
        public static final char TaiwaneseForeignInvestorID         = '2';
        public static final char GeneralIdentifier                  = 'C';
        public static final char USEmployerOrTaxIDNumber            = '8';
        public static final char TaiwaneseTradingAcct               = '3';
        public static final char Proprietary                        = 'D';
        public static final char AustralianBusinessNumber           = '9';
        public static final char MalaysianCentralDepository         = '4';
        public static final char ISOCountryCode                     = 'E';
        public static final char AustralianTaxFileNumber            = 'A';
        public static final char ChineseInvestorID                  = '5';
        public static final char SettlementEntityLocation           = 'F';
        public static final char TaxID                              = 'J';
        public static final char MIC                                = 'G';
        public static final char CSDParticipant                     = 'H';
        public static final char AustralianCompanyNumber            = 'K';
        public static final char AustralianRegisteredBodyNumber     = 'L';
        public static final char CFTCReportingFirmIdentifier        = 'M';
        public static final char LegalEntityIdentifier              = 'N';
        public static final char InterimIdentifier                  = 'O';
        public static final char ShortCodeIdentifier                = 'P';
        public static final char NationalIDNaturalPerson            = 'Q';
        public static final char IndiaPermanentAccountNumber        = 'R';
        public static final char FDID                               = 'S';
        public static final char SPSAID                             = 'T';
        public static final char MasterSPSAID                       = 'U';

        private PartyIDSourceValues() {
        }

    }

    /**
     * Values for PartyRole(452).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>NestedPartyRole(538)</li>
     *   <li>Nested2PartyRole(759)</li>
     *   <li>SettlPartyRole(784)</li>
     *   <li>Nested3PartyRole(951)</li>
     *   <li>InstrumentPartyRole(1051)</li>
     *   <li>UnderlyingInstrumentPartyRole(1061)</li>
     *   <li>RootPartyRole(1119)</li>
     *   <li>DerivativeInstrumentPartyRole(1295)</li>
     *   <li>TrdRepPartyRole(1388)</li>
     *   <li>Nested4PartyRole(1417)</li>
     *   <li>TargetPartyRole(1464)</li>
     *   <li>RequestedPartyRole(1509)</li>
     *   <li>RelatedPartyDetailRole(1565)</li>
     *   <li>RequestingPartyRole(1660)</li>
     *   <li>PartyDetailRole(1693)</li>
     *   <li>LegInstrumentPartyRole(2257)</li>
     *   <li>LimitRole(2396)</li>
     *   <li>ProvisionPartyRole(40177)</li>
     *   <li>PaymentSettlPartyRole(40236)</li>
     *   <li>LegProvisionPartyRole(40536)</li>
     *   <li>UnderlyingProvisionPartyRole(42176)</li>
     * </ul>
     */
    public static class PartyRoleValues {

        public static final int ExecutingFirm                      = 1;
        public static final int BrokerOfCredit                     = 2;
        public static final int ClientID                           = 3;
        public static final int ClearingFirm                       = 4;
        public static final int InvestorID                         = 5;
        public static final int IntroducingFirm                    = 6;
        public static final int EnteringFirm                       = 7;
        public static final int Locate                             = 8;
        public static final int FundManagerClientID                = 9;
        public static final int SettlementLocation                 = 10;
        public static final int OrderOriginationTrader             = 11;
        public static final int ExecutingTrader                    = 12;
        public static final int OrderOriginationFirm               = 13;
        public static final int GiveupClearingFirmDepr             = 14;
        public static final int CorrespondantClearingFirm          = 15;
        public static final int ExecutingSystem                    = 16;
        public static final int ContraFirm                         = 17;
        public static final int ContraClearingFirm                 = 18;
        public static final int SponsoringFirm                     = 19;
        public static final int UnderlyingContraFirm               = 20;
        public static final int ClearingOrganization               = 21;
        public static final int Exchange                           = 22;
        public static final int CustomerAccount                    = 24;
        public static final int CorrespondentClearingOrganization  = 25;
        public static final int CorrespondentBroker                = 26;
        public static final int Buyer                              = 27;
        public static final int Custodian                          = 28;
        public static final int Intermediary                       = 29;
        public static final int Agent                              = 30;
        public static final int SubCustodian                       = 31;
        public static final int Beneficiary                        = 32;
        public static final int InterestedParty                    = 33;
        public static final int RegulatoryBody                     = 34;
        public static final int LiquidityProvider                  = 35;
        public static final int EnteringTrader                     = 36;
        public static final int ContraTrader                       = 37;
        public static final int PositionAccount                    = 38;
        public static final int ContraInvestorID                   = 39;
        public static final int TransferToFirm                     = 40;
        public static final int ContraPositionAccount              = 41;
        public static final int ContraExchange                     = 42;
        public static final int InternalCarryAccount               = 43;
        public static final int OrderEntryOperatorID               = 44;
        public static final int SecondaryAccountNumber             = 45;
        public static final int ForeignFirm                        = 46;
        public static final int ThirdPartyAllocationFirm           = 47;
        public static final int ClaimingAccount                    = 48;
        public static final int AssetManager                       = 49;
        public static final int PledgorAccount                     = 50;
        public static final int PledgeeAccount                     = 51;
        public static final int LargeTraderReportableAccount       = 52;
        public static final int TraderMnemonic                     = 53;
        public static final int SenderLocation                     = 54;
        public static final int SessionID                          = 55;
        public static final int AcceptableCounterparty             = 56;
        public static final int UnacceptableCounterparty           = 57;
        public static final int EnteringUnit                       = 58;
        public static final int ExecutingUnit                      = 59;
        public static final int IntroducingBroker                  = 60;
        public static final int QuoteOriginator                    = 61;
        public static final int ReportOriginator                   = 62;
        public static final int SystematicInternaliser             = 63;
        public static final int MultilateralTradingFacility        = 64;
        public static final int RegulatedMarket                    = 65;
        public static final int MarketMaker                        = 66;
        public static final int InvestmentFirm                     = 67;
        public static final int HostCompetentAuthority             = 68;
        public static final int HomeCompetentAuthority             = 69;
        public static final int CompetentAuthorityLiquidity        = 70;
        public static final int CompetentAuthorityTransactionVenue = 71;
        public static final int ReportingIntermediary              = 72;
        public static final int ExecutionVenue                     = 73;
        public static final int MarketDataEntryOriginator          = 74;
        public static final int LocationID                         = 75;
        public static final int DeskID                             = 76;
        public static final int MarketDataMarket                   = 77;
        public static final int AllocationEntity                   = 78;
        public static final int PrimeBroker                        = 79;
        public static final int StepOutFirm                        = 80;
        public static final int BrokerClearingID                   = 81;
        public static final int CentralRegistrationDepository      = 82;
        public static final int ClearingAccount                    = 83;
        public static final int AcceptableSettlingCounterparty     = 84;
        public static final int UnacceptableSettlingCounterparty   = 85;
        public static final int CLSMemberBank                      = 86;
        public static final int InConcertGroup                     = 87;
        public static final int InConcertControllingEntity         = 88;
        public static final int LargePositionsReportingAccount     = 89;
        public static final int SettlementFirm                     = 90;
        public static final int SettlementAccount                  = 91;
        public static final int ReportingMarketCenter              = 92;
        public static final int RelatedReportingMarketCenter       = 93;
        public static final int AwayMarket                         = 94;
        public static final int GiveupTradingFirm                  = 95;
        public static final int TakeupTradingFirm                  = 96;
        public static final int GiveupClearingFirm                 = 97;
        public static final int TakeupClearingFirm                 = 98;
        public static final int OriginatingMarket                  = 99;
        public static final int MarginAccount                      = 100;
        public static final int CollateralAssetAccount             = 101;
        public static final int DataRepository                     = 102;
        public static final int CalculationAgent                   = 103;
        public static final int ExerciseNoticeSender               = 104;
        public static final int ExerciseNoticeReceiver             = 105;
        public static final int RateReferenceBank                  = 106;
        public static final int Correspondent                      = 107;
        public static final int BeneficiaryBank                    = 109;
        public static final int Borrower                           = 110;
        public static final int PrimaryObligator                   = 111;
        public static final int Guarantor                          = 112;
        public static final int ExcludedReferenceEntity            = 113;
        public static final int DeterminingParty                   = 114;
        public static final int HedgingParty                       = 115;
        public static final int ReportingEntity                    = 116;
        public static final int SalesPerson                        = 117;
        public static final int Operator                           = 118;
        public static final int CSD                                = 119;
        public static final int ICSD                               = 120;
        public static final int TradingSubAccount                  = 121;
        public static final int InvestmentDecisionMaker            = 122;
        public static final int PublishingIntermediary             = 123;
        public static final int CSDParticipant                     = 124;
        public static final int Issuer                             = 125;
        public static final int ContraCustomerAccount              = 126;
        public static final int ContraInvestmentDecisionMaker      = 127;

        private PartyRoleValues() {
        }

    }

    /**
     * Values for Product(460).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingProduct(462)</li>
     *   <li>LegProduct(607)</li>
     *   <li>DerivativeProduct(1246)</li>
     *   <li>InstrumentScopeProduct(1543)</li>
     * </ul>
     */
    public static class ProductValues {

        public static final int AGENCY      = 1;
        public static final int COMMODITY   = 2;
        public static final int CORPORATE   = 3;
        public static final int CURRENCY    = 4;
        public static final int EQUITY      = 5;
        public static final int GOVERNMENT  = 6;
        public static final int INDEX       = 7;
        public static final int LOAN        = 8;
        public static final int MONEYMARKET = 9;
        public static final int MORTGAGE    = 10;
        public static final int MUNICIPAL   = 11;
        public static final int OTHER       = 12;
        public static final int FINANCING   = 13;

        private ProductValues() {
        }

    }

    /**
     * Values for RoundingDirection(468).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>InstrumentRoundingDirection(2144)</li>
     *   <li>LegInstrumentRoundingDirection(2214)</li>
     *   <li>UnderlyingInstrumentRoundingDirection(2298)</li>
     *   <li>LegPaymentStreamFinalRateRoundingDirection(40346)</li>
     *   <li>UnderlyingPaymentStreamFinalRateRoundingDirection(40635)</li>
     *   <li>PaymentStreamFinalRateRoundingDirection(40804)</li>
     *   <li>DividendFinalRateRoundingDirection(42232)</li>
     *   <li>LegDividendFinalRateRoundingDirection(42326)</li>
     *   <li>LegPaymentStreamCompoundingFinalRateRoundingDirection(42441)</li>
     *   <li>PaymentStreamCompoundingFinalRateRoundingDirection(42642)</li>
     *   <li>UnderlyingDividendFinalRateRoundingDirection(42815)</li>
     *   <li>UnderlyingPaymentStreamCompoundingFinalRateRoundingDirection(42937)</li>
     * </ul>
     */
    public static class RoundingDirectionValues {

        public static final char RoundToNearest = '0';
        public static final char RoundDown      = '1';
        public static final char RoundUp        = '2';

        private RoundingDirectionValues() {
        }

    }

    /**
     * Values for DistribPaymentMethod(477).
     */
    public static class DistribPaymentMethodValues {

        public static final int CREST                        = 1;
        public static final int NSCC                         = 2;
        public static final int Euroclear                    = 3;
        public static final int Clearstream                  = 4;
        public static final int Cheque                       = 5;
        public static final int TelegraphicTransfer          = 6;
        public static final int FedWire                      = 7;
        public static final int DirectCredit                 = 8;
        public static final int ACHCredit                    = 9;
        public static final int BPAY                         = 10;
        public static final int HighValueClearingSystemHVACS = 11;
        public static final int ReinvestInFund               = 12;
        public static final int Other                        = 999;

        private DistribPaymentMethodValues() {
        }

    }

    /**
     * Values for CancellationRights(480).
     */
    public static class CancellationRightsValues {

        public static final char Yes               = 'Y';
        public static final char NoExecutionOnly   = 'N';
        public static final char NoWaiverAgreement = 'M';
        public static final char NoInstitutional   = 'O';

        private CancellationRightsValues() {
        }

    }

    /**
     * Values for MoneyLaunderingStatus(481).
     */
    public static class MoneyLaunderingStatusValues {

        public static final char Passed           = 'Y';
        public static final char NotChecked       = 'N';
        public static final char ExemptBelowLimit = '1';
        public static final char ExemptMoneyType  = '2';
        public static final char ExemptAuthorised = '3';

        private MoneyLaunderingStatusValues() {
        }

    }

    /**
     * Values for ExecPriceType(484).
     */
    public static class ExecPriceTypeValues {

        public static final char BidPrice                           = 'B';
        public static final char CreationPrice                      = 'C';
        public static final char CreationPricePlusAdjustmentPercent = 'D';
        public static final char CreationPricePlusAdjustmentAmount  = 'E';
        public static final char OfferPrice                         = 'O';
        public static final char OfferPriceMinusAdjustmentPercent   = 'P';
        public static final char OfferPriceMinusAdjustmentAmount    = 'Q';
        public static final char SinglePrice                        = 'S';

        private ExecPriceTypeValues() {
        }

    }

    /**
     * Values for TradeReportTransType(487).
     */
    public static class TradeReportTransTypeValues {

        public static final int New                       = 0;
        public static final int Cancel                    = 1;
        public static final int Replace                   = 2;
        public static final int Release                   = 3;
        public static final int Reverse                   = 4;
        public static final int CancelDueToBackOutOfTrade = 5;

        private TradeReportTransTypeValues() {
        }

    }

    /**
     * Values for PaymentMethod(492).
     */
    public static class PaymentMethodValues {

        public static final int CREST                   = 1;
        public static final int NSCC                    = 2;
        public static final int Euroclear               = 3;
        public static final int Clearstream             = 4;
        public static final int Cheque                  = 5;
        public static final int TelegraphicTransfer     = 6;
        public static final int FedWire                 = 7;
        public static final int DebitCard               = 8;
        public static final int DirectDebit             = 9;
        public static final int DirectCredit            = 10;
        public static final int CreditCard              = 11;
        public static final int ACHDebit                = 12;
        public static final int ACHCredit               = 13;
        public static final int BPAY                    = 14;
        public static final int HighValueClearingSystem = 15;
        public static final int CHIPS                   = 16;
        public static final int SWIFT                   = 17;
        public static final int CHAPS                   = 18;
        public static final int SIC                     = 19;
        public static final int EuroSIC                 = 20;
        public static final int Other                   = 999;

        private PaymentMethodValues() {
        }

    }

    /**
     * Values for TaxAdvantageType(495).
     */
    public static class TaxAdvantageTypeValues {

        public static final int None                          = 0;
        public static final int MaxiISA                       = 1;
        public static final int TESSA                         = 2;
        public static final int MiniCashISA                   = 3;
        public static final int MiniStocksAndSharesISA        = 4;
        public static final int MiniInsuranceISA              = 5;
        public static final int CurrentYearPayment            = 6;
        public static final int PriorYearPayment              = 7;
        public static final int AssetTransfer                 = 8;
        public static final int EmployeePriorYear             = 9;
        public static final int EmployeeCurrentYear           = 10;
        public static final int EmployerPriorYear             = 11;
        public static final int EmployerCurrentYear           = 12;
        public static final int NonFundPrototypeIRA           = 13;
        public static final int NonFundQualifiedPlan          = 14;
        public static final int DefinedContributionPlan       = 15;
        public static final int IRA                           = 16;
        public static final int IRARollover                   = 17;
        public static final int KEOGH                         = 18;
        public static final int ProfitSharingPlan             = 19;
        public static final int US401K                        = 20;
        public static final int SelfDirectedIRA               = 21;
        public static final int US403b                        = 22;
        public static final int US457                         = 23;
        public static final int RothIRAPrototype              = 24;
        public static final int RothIRANonPrototype           = 25;
        public static final int RothConversionIRAPrototype    = 26;
        public static final int RothConversionIRANonPrototype = 27;
        public static final int EducationIRAPrototype         = 28;
        public static final int EducationIRANonPrototype      = 29;
        public static final int Other                         = 999;

        private TaxAdvantageTypeValues() {
        }

    }

    /**
     * Values for FundRenewWaiv(497).
     */
    public static class FundRenewWaivValues {

        public static final char No  = 'N';
        public static final char Yes = 'Y';

        private FundRenewWaivValues() {
        }

    }

    /**
     * Values for RegistStatus(506).
     */
    public static class RegistStatusValues {

        public static final char Accepted = 'A';
        public static final char Rejected = 'R';
        public static final char Held     = 'H';
        public static final char Reminder = 'N';

        private RegistStatusValues() {
        }

    }

    /**
     * Values for RegistRejReasonCode(507).
     */
    public static class RegistRejReasonCodeValues {

        public static final int InvalidAccountType         = 1;
        public static final int InvalidTaxExemptType       = 2;
        public static final int InvalidOwnershipType       = 3;
        public static final int NoRegDetails               = 4;
        public static final int InvalidRegSeqNo            = 5;
        public static final int InvalidRegDetails          = 6;
        public static final int InvalidMailingDetails      = 7;
        public static final int InvalidMailingInstructions = 8;
        public static final int InvalidInvestorID          = 9;
        public static final int InvalidInvestorIDSource    = 10;
        public static final int InvalidDateOfBirth         = 11;
        public static final int InvalidCountry             = 12;
        public static final int InvalidDistribInstns       = 13;
        public static final int InvalidPercentage          = 14;
        public static final int InvalidPaymentMethod       = 15;
        public static final int InvalidAccountName         = 16;
        public static final int InvalidAgentCode           = 17;
        public static final int InvalidAccountNum          = 18;
        public static final int Other                      = 99;

        private RegistRejReasonCodeValues() {
        }

    }

    /**
     * Values for RegistTransType(514).
     */
    public static class RegistTransTypeValues {

        public static final char New     = '0';
        public static final char Cancel  = '2';
        public static final char Replace = '1';

        private RegistTransTypeValues() {
        }

    }

    /**
     * Values for OwnershipType(517).
     */
    public static class OwnershipTypeValues {

        public static final char JointInvestors  = 'J';
        public static final char TenantsInCommon = 'T';
        public static final char JointTrustees   = '2';

        private OwnershipTypeValues() {
        }

    }

    /**
     * Values for ContAmtType(519).
     */
    public static class ContAmtTypeValues {

        public static final int CommissionAmount                  = 1;
        public static final int CommissionPercent                 = 2;
        public static final int InitialChargeAmount               = 3;
        public static final int InitialChargePercent              = 4;
        public static final int DiscountAmount                    = 5;
        public static final int DiscountPercent                   = 6;
        public static final int DilutionLevyAmount                = 7;
        public static final int DilutionLevyPercent               = 8;
        public static final int ExitChargeAmount                  = 9;
        public static final int ExitChargePercent                 = 10;
        public static final int FundBasedRenewalCommissionPercent = 11;
        public static final int ProjectedFundValue                = 12;
        public static final int FundBasedRenewalCommissionOnOrder = 13;
        public static final int FundBasedRenewalCommissionOnFund  = 14;
        public static final int NetSettlementAmount               = 15;

        private ContAmtTypeValues() {
        }

    }

    /**
     * Values for OwnerType(522).
     */
    public static class OwnerTypeValues {

        public static final int IndividualInvestor             = 1;
        public static final int PublicCompany                  = 2;
        public static final int PrivateCompany                 = 3;
        public static final int IndividualTrustee              = 4;
        public static final int CompanyTrustee                 = 5;
        public static final int PensionPlan                    = 6;
        public static final int CustodianUnderGiftsToMinorsAct = 7;
        public static final int Trusts                         = 8;
        public static final int Fiduciaries                    = 9;
        public static final int NetworkingSubAccount           = 10;
        public static final int NonProfitOrganization          = 11;
        public static final int CorporateBody                  = 12;
        public static final int Nominee                        = 13;
        public static final int InstitutionalCustomer          = 14;
        public static final int Combined                       = 15;
        public static final int MemberFirmEmployee             = 16;
        public static final int MarketMakingAccount            = 17;
        public static final int ProprietaryAccount             = 18;
        public static final int NonbrokerDealer                = 19;
        public static final int UnknownBeneficialOwnerType     = 20;
        public static final int FirmsErrorAccount              = 21;
        public static final int FirmAgencyAveragePriceAccount  = 22;

        private OwnerTypeValues() {
        }

    }

    /**
     * Values for OrderCapacity(528).
     */
    public static class OrderCapacityValues {

        public static final char Agency              = 'A';
        public static final char Proprietary         = 'G';
        public static final char Individual          = 'I';
        public static final char Principal           = 'P';
        public static final char RisklessPrincipal   = 'R';
        public static final char AgentForOtherMember = 'W';
        public static final char MixedCapacity       = 'M';

        private OrderCapacityValues() {
        }

    }

    /**
     * Values for OrderRestrictions(529).
     */
    public static class OrderRestrictionsValues {

        public static final char ProgramTrade                                = '1';
        public static final char IndexArbitrage                              = '2';
        public static final char NonIndexArbitrage                           = '3';
        public static final char CompetingMarketMaker                        = '4';
        public static final char ActingAsMarketMakerOrSpecialistInSecurity   = '5';
        public static final char ActingAsMarketMakerOrSpecialistInUnderlying = '6';
        public static final char ForeignEntity                               = '7';
        public static final char ExternalMarketParticipant                   = '8';
        public static final char ExternalInterConnectedMarketLinkage         = '9';
        public static final char RisklessArbitrage                           = 'A';
        public static final char IssuerHolding                               = 'B';
        public static final char IssuePriceStabilization                     = 'C';
        public static final char NonAlgorithmic                              = 'D';
        public static final char Algorithmic                                 = 'E';
        public static final char Cross                                       = 'F';
        public static final char InsiderAccount                              = 'G';
        public static final char SignificantShareholder                      = 'H';
        public static final char NormalCourseIssuerBid                       = 'I';

        private OrderRestrictionsValues() {
        }

    }

    /**
     * Values for MassCancelRequestType(530).
     */
    public static class MassCancelRequestTypeValues {

        public static final char CancelOrdersForASecurity            = '1';
        public static final char CancelOrdersForAnUnderlyingSecurity = '2';
        public static final char CancelOrdersForAProduct             = '3';
        public static final char CancelOrdersForACFICode             = '4';
        public static final char CancelOrdersForASecurityType        = '5';
        public static final char CancelOrdersForATradingSession      = '6';
        public static final char CancelAllOrders                     = '7';
        public static final char CancelOrdersForAMarket              = '8';
        public static final char CancelOrdersForAMarketSegment       = '9';
        public static final char CancelOrdersForASecurityGroup       = 'A';
        public static final char CancelOrdersForSecurityIssuer       = 'B';
        public static final char CancelForIssuerOfUnderlyingSecurity = 'C';

        private MassCancelRequestTypeValues() {
        }

    }

    /**
     * Values for MassCancelResponse(531).
     */
    public static class MassCancelResponseValues {

        public static final char CancelRequestRejected                     = '0';
        public static final char CancelOrdersForASecurity                  = '1';
        public static final char CancelOrdersForAnUnderlyingSecurity       = '2';
        public static final char CancelOrdersForAProduct                   = '3';
        public static final char CancelOrdersForACFICode                   = '4';
        public static final char CancelOrdersForASecurityType              = '5';
        public static final char CancelOrdersForATradingSession            = '6';
        public static final char CancelAllOrders                           = '7';
        public static final char CancelOrdersForAMarket                    = '8';
        public static final char CancelOrdersForAMarketSegment             = '9';
        public static final char CancelOrdersForASecurityGroup             = 'A';
        public static final char CancelOrdersForASecuritiesIssuer          = 'B';
        public static final char CancelOrdersForIssuerOfUnderlyingSecurity = 'C';

        private MassCancelResponseValues() {
        }

    }

    /**
     * Values for MassCancelRejectReason(532).
     */
    public static class MassCancelRejectReasonValues {

        public static final int MassCancelNotSupported                     = 0;
        public static final int InvalidOrUnknownSecurity                   = 1;
        public static final int InvalidOrUnknownUnderlyingSecurity         = 2;
        public static final int InvalidOrUnknownProduct                    = 3;
        public static final int InvalidOrUnknownCFICode                    = 4;
        public static final int InvalidOrUnknownSecurityType               = 5;
        public static final int InvalidOrUnknownTradingSession             = 6;
        public static final int InvalidOrUnknownMarket                     = 7;
        public static final int InvalidOrUnkownMarketSegment               = 8;
        public static final int InvalidOrUnknownSecurityGroup              = 9;
        public static final int InvalidOrUnknownSecurityIssuer             = 10;
        public static final int InvalidOrUnknownIssuerOfUnderlyingSecurity = 11;
        public static final int Other                                      = 99;

        private MassCancelRejectReasonValues() {
        }

    }

    /**
     * Values for QuoteType(537).
     */
    public static class QuoteTypeValues {

        public static final int Indicative          = 0;
        public static final int Tradeable           = 1;
        public static final int RestrictedTradeable = 2;
        public static final int Counter             = 3;
        public static final int InitiallyTradeable  = 4;

        private QuoteTypeValues() {
        }

    }

    /**
     * Values for CashMargin(544).
     */
    public static class CashMarginValues {

        public static final char Cash        = '1';
        public static final char MarginOpen  = '2';
        public static final char MarginClose = '3';

        private CashMarginValues() {
        }

    }

    /**
     * Values for Scope(546).
     */
    public static class ScopeValues {

        public static final char LocalMarket = '1';
        public static final char National    = '2';
        public static final char Global      = '3';

        private ScopeValues() {
        }

    }

    /**
     * Values for CrossType(549).
     */
    public static class CrossTypeValues {

        public static final int CrossAON           = 1;
        public static final int CrossIOC           = 2;
        public static final int CrossOneSide       = 3;
        public static final int CrossSamePrice     = 4;
        public static final int BasisCross         = 5;
        public static final int ContingentCross    = 6;
        public static final int VWAPCross          = 7;
        public static final int STSCross           = 8;
        public static final int CustomerToCustomer = 9;

        private CrossTypeValues() {
        }

    }

    /**
     * Values for CrossPrioritization(550).
     */
    public static class CrossPrioritizationValues {

        public static final int None                  = 0;
        public static final int BuySideIsPrioritized  = 1;
        public static final int SellSideIsPrioritized = 2;

        private CrossPrioritizationValues() {
        }

    }

    /**
     * Values for NoSides(552).
     */
    public static class NoSidesValues {

        public static final int OneSide   = 1;
        public static final int BothSides = 2;

        private NoSidesValues() {
        }

    }

    /**
     * Values for SecurityListRequestType(559).
     */
    public static class SecurityListRequestTypeValues {

        public static final int Symbol             = 0;
        public static final int SecurityTypeAnd    = 1;
        public static final int Product            = 2;
        public static final int TradingSessionID   = 3;
        public static final int AllSecurities      = 4;
        public static final int MarketIDOrMarketID = 5;

        private SecurityListRequestTypeValues() {
        }

    }

    /**
     * Values for SecurityRequestResult(560).
     */
    public static class SecurityRequestResultValues {

        public static final int ValidRequest                          = 0;
        public static final int InvalidOrUnsupportedRequest           = 1;
        public static final int NoInstrumentsFound                    = 2;
        public static final int NotAuthorizedToRetrieveInstrumentData = 3;
        public static final int InstrumentDataTemporarilyUnavailable  = 4;
        public static final int RequestForInstrumentDataNotSupported  = 5;

        private SecurityRequestResultValues() {
        }

    }

    /**
     * Values for MultiLegRptTypeReq(563).
     */
    public static class MultiLegRptTypeReqValues {

        public static final int ReportByMulitlegSecurityOnly              = 0;
        public static final int ReportByMultilegSecurityAndInstrumentLegs = 1;
        public static final int ReportByInstrumentLegsOnly                = 2;

        private MultiLegRptTypeReqValues() {
        }

    }

    /**
     * Values for TradSesStatusRejReason(567).
     */
    public static class TradSesStatusRejReasonValues {

        public static final int UnknownOrInvalidTradingSessionID = 1;
        public static final int Other                            = 99;

        private TradSesStatusRejReasonValues() {
        }

    }

    /**
     * Values for TradeRequestType(569).
     */
    public static class TradeRequestTypeValues {

        public static final int AllTrades                         = 0;
        public static final int MatchedTradesMatchingCriteria     = 1;
        public static final int UnmatchedTradesThatMatchCriteria  = 2;
        public static final int UnreportedTradesThatMatchCriteria = 3;
        public static final int AdvisoriesThatMatchCriteria       = 4;

        private TradeRequestTypeValues() {
        }

    }

    /**
     * Values for MatchStatus(573).
     */
    public static class MatchStatusValues {

        public static final char Compared        = '0';
        public static final char Uncompared      = '1';
        public static final char AdvisoryOrAlert = '2';
        public static final char Mismatched      = '3';

        private MatchStatusValues() {
        }

    }

    /**
     * Values for MatchType(574).
     */
    public static class MatchTypeValues {

        public static final String ExactMatchPlus4BadgesExecTime        = "A1";
        public static final String ExactMatchPlus4Badges                = "A2";
        public static final String ACTAcceptedTrade                     = "M3";
        public static final String ExactMatchPlus2BadgesExecTime        = "A3";
        public static final String ACTDefaultTrade                      = "M4";
        public static final String ExactMatchPlus2Badges                = "A4";
        public static final String ACTDefaultAfterM2                    = "M5";
        public static final String ExactMatchPlusExecTime               = "A5";
        public static final String ACTM6Match                           = "M6";
        public static final String StampedAdvisoriesOrSpecialistAccepts = "AQ";
        public static final String A1ExactMatchSummarizedQuantity       = "S1";
        public static final String A2ExactMatchSummarizedQuantity       = "S2";
        public static final String A3ExactMatchSummarizedQuantity       = "S3";
        public static final String A4ExactMatchSummarizedQuantity       = "S4";
        public static final String A5ExactMatchSummarizedQuantity       = "S5";
        public static final String ExactMatchMinusBadgesTimes           = "M1";
        public static final String SummarizedMatchMinusBadgesTimes      = "M2";
        public static final String OCSLockedIn                          = "MT";
        public static final String OnePartyTradeReport                  = "1";
        public static final String TwoPartyTradeReport                  = "2";
        public static final String ConfirmedTradeReport                 = "3";
        public static final String AutoMatch                            = "4";
        public static final String CrossAuction                         = "5";
        public static final String CounterOrderSelection                = "6";
        public static final String CallAuction                          = "7";
        public static final String Issuing                              = "8";
        public static final String SystematicInternaliser               = "9";
        public static final String AutoMatchLastLook                    = "10";
        public static final String CrossAuctionLastLook                 = "11";

        private MatchTypeValues() {
        }

    }

    /**
     * Values for ClearingInstruction(577).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>TradeClearingInstruction(1925)</li>
     * </ul>
     */
    public static class ClearingInstructionValues {

        public static final int ProcessNormally                   = 0;
        public static final int ExcludeFromAllNetting             = 1;
        public static final int BilateralNettingOnly              = 2;
        public static final int ExClearing                        = 3;
        public static final int SpecialTrade                      = 4;
        public static final int MultilateralNetting               = 5;
        public static final int ClearAgainstCentralCounterparty   = 6;
        public static final int ExcludeFromCentralCounterparty    = 7;
        public static final int ManualMode                        = 8;
        public static final int AutomaticPostingMode              = 9;
        public static final int AutomaticGiveUpMode               = 10;
        public static final int QualifiedServiceRepresentativeQSR = 11;
        public static final int CustomerTrade                     = 12;
        public static final int SelfClearing                      = 13;
        public static final int BuyIn                             = 14;

        private ClearingInstructionValues() {
        }

    }

    /**
     * Values for AccountType(581).
     */
    public static class AccountTypeValues {

        public static final int CarriedCustomerSide                 = 1;
        public static final int CarriedNonCustomerSide              = 2;
        public static final int HouseTrader                         = 3;
        public static final int FloorTrader                         = 4;
        public static final int CarriedNonCustomerSideCrossMargined = 6;
        public static final int HouseTraderCrossMargined            = 7;
        public static final int JointBackOfficeAccount              = 8;
        public static final int EquitiesSpecialist                  = 9;
        public static final int OptionsMarketMaker                  = 10;
        public static final int OptionsFirmAccount                  = 11;
        public static final int AccountCustomerNonCustomerOrders    = 12;
        public static final int AccountOrdersMultipleCustomers      = 13;

        private AccountTypeValues() {
        }

    }

    /**
     * Values for CustOrderCapacity(582).
     */
    public static class CustOrderCapacityValues {

        public static final int MemberTradingForTheirOwnAccount             = 1;
        public static final int ClearingFirmTradingForItsProprietaryAccount = 2;
        public static final int MemberTradingForAnotherMember               = 3;
        public static final int AllOther                                    = 4;
        public static final int RetailCustomer                              = 5;

        private CustOrderCapacityValues() {
        }

    }

    /**
     * Values for MassStatusReqType(585).
     */
    public static class MassStatusReqTypeValues {

        public static final int StatusForOrdersForASecurity            = 1;
        public static final int StatusForOrdersForAnUnderlyingSecurity = 2;
        public static final int StatusForOrdersForAProduct             = 3;
        public static final int StatusForOrdersForACFICode             = 4;
        public static final int StatusForOrdersForASecurityType        = 5;
        public static final int StatusForOrdersForATradingSession      = 6;
        public static final int StatusForAllOrders                     = 7;
        public static final int StatusForOrdersForAPartyID             = 8;
        public static final int StatusForSecurityIssuer                = 9;
        public static final int StatusForIssuerOfUnderlyingSecurity    = 10;

        private MassStatusReqTypeValues() {
        }

    }

    /**
     * Values for DayBookingInst(589).
     */
    public static class DayBookingInstValues {

        public static final char Auto                                 = '0';
        public static final char SpeakWithOrderInitiatorBeforeBooking = '1';
        public static final char Accumulate                           = '2';

        private DayBookingInstValues() {
        }

    }

    /**
     * Values for BookingUnit(590).
     */
    public static class BookingUnitValues {

        public static final char EachPartialExecutionIsABookableUnit   = '0';
        public static final char AggregatePartialExecutionsOnThisOrder = '1';
        public static final char AggregateExecutionsForThisSymbol      = '2';

        private BookingUnitValues() {
        }

    }

    /**
     * Values for PreallocMethod(591).
     */
    public static class PreallocMethodValues {

        public static final char ProRata      = '0';
        public static final char DoNotProRata = '1';

        private PreallocMethodValues() {
        }

    }

    /**
     * Values for TradingSessionSubID(625).
     */
    public static class TradingSessionSubIDValues {

        public static final String PreTrading                 = "1";
        public static final String OpeningOrOpeningAuction    = "2";
        public static final String Continuous                 = "3";
        public static final String ClosingOrClosingAuction    = "4";
        public static final String PostTrading                = "5";
        public static final String ScheduledIntradayAuction   = "6";
        public static final String Quiescent                  = "7";
        public static final String AnyAuction                 = "8";
        public static final String UnscheduledIntradayAuction = "9";
        public static final String OutOfMainSessionTrading    = "10";
        public static final String PrivateAuction             = "11";
        public static final String PublicAuction              = "12";
        public static final String GroupAuction               = "13";

        private TradingSessionSubIDValues() {
        }

    }

    /**
     * Values for AllocType(626).
     */
    public static class AllocTypeValues {

        public static final int Calculated                           = 1;
        public static final int Preliminary                          = 2;
        public static final int SellsideCalculatedUsingPreliminary   = 3;
        public static final int SellsideCalculatedWithoutPreliminary = 4;
        public static final int ReadyToBook                          = 5;
        public static final int BuysideReadyToBook                   = 6;
        public static final int WarehouseInstruction                 = 7;
        public static final int RequestToIntermediary                = 8;
        public static final int Accept                               = 9;
        public static final int Reject                               = 10;
        public static final int AcceptPending                        = 11;
        public static final int IncompleteGroup                      = 12;
        public static final int CompleteGroup                        = 13;
        public static final int ReversalPending                      = 14;
        public static final int ReopenGroup                          = 15;
        public static final int CancelGroup                          = 16;
        public static final int Giveup                               = 17;
        public static final int Takeup                               = 18;
        public static final int RefuseTakeup                         = 19;
        public static final int InitiateReversal                     = 20;
        public static final int Reverse                              = 21;
        public static final int RefuseReversal                       = 22;
        public static final int SubAllocationGiveup                  = 23;
        public static final int ApproveGiveup                        = 24;
        public static final int ApproveTakeup                        = 25;
        public static final int NotionalValueAveragePxGroupAlloc     = 26;

        private AllocTypeValues() {
        }

    }

    /**
     * Values for ClearingFeeIndicator(635).
     */
    public static class ClearingFeeIndicatorValues {

        public static final String FirstYearDelegate             = "1";
        public static final String SecondYearDelegate            = "2";
        public static final String ThirdYearDelegate             = "3";
        public static final String FourthYearDelegate            = "4";
        public static final String FifthYearDelegate             = "5";
        public static final String SixthYearDelegate             = "9";
        public static final String CBOEMember                    = "B";
        public static final String NonMemberAndCustomer          = "C";
        public static final String EquityMemberAndClearingMember = "E";
        public static final String FullAndAssociateMember        = "F";
        public static final String Firms106HAnd106J              = "H";
        public static final String GIM                           = "I";
        public static final String Lessee106FEmployees           = "L";
        public static final String AllOtherOwnershipTypes        = "M";

        private ClearingFeeIndicatorValues() {
        }

    }

    /**
     * Values for PriorityIndicator(638).
     */
    public static class PriorityIndicatorValues {

        public static final int PriorityUnchanged                 = 0;
        public static final int LostPriorityAsResultOfOrderChange = 1;

        private PriorityIndicatorValues() {
        }

    }

    /**
     * Values for QuoteRequestRejectReason(658).
     */
    public static class QuoteRequestRejectReasonValues {

        public static final int UnknownSymbol               = 1;
        public static final int Exchange                    = 2;
        public static final int QuoteRequestExceedsLimit    = 3;
        public static final int TooLateToEnter              = 4;
        public static final int InvalidPrice                = 5;
        public static final int NotAuthorizedToRequestQuote = 6;
        public static final int NoMatchForInquiry           = 7;
        public static final int NoMarketForInstrument       = 8;
        public static final int NoInventory                 = 9;
        public static final int Pass                        = 10;
        public static final int InsufficientCredit          = 11;
        public static final int ExceededClipSizeLimit       = 12;
        public static final int ExceededMaxNotionalOrderAmt = 13;
        public static final int ExceededDV01PV01Limit       = 14;
        public static final int ExceededCS01Limit           = 15;
        public static final int Other                       = 99;

        private QuoteRequestRejectReasonValues() {
        }

    }

    /**
     * Values for AcctIDSource(660).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>AllocAcctIDSource(661)</li>
     *   <li>LegAllocAcctIDSource(674)</li>
     * </ul>
     */
    public static class AcctIDSourceValues {

        public static final int BIC      = 1;
        public static final int SIDCode  = 2;
        public static final int TFM      = 3;
        public static final int OMGEO    = 4;
        public static final int DTCCCode = 5;
        public static final int SPSAID   = 6;
        public static final int Other    = 99;

        private AcctIDSourceValues() {
        }

    }

    /**
     * Values for ConfirmStatus(665).
     */
    public static class ConfirmStatusValues {

        public static final int Received                      = 1;
        public static final int MismatchedAccount             = 2;
        public static final int MissingSettlementInstructions = 3;
        public static final int Confirmed                     = 4;
        public static final int RequestRejected               = 5;

        private ConfirmStatusValues() {
        }

    }

    /**
     * Values for ConfirmTransType(666).
     */
    public static class ConfirmTransTypeValues {

        public static final int New     = 0;
        public static final int Replace = 1;
        public static final int Cancel  = 2;

        private ConfirmTransTypeValues() {
        }

    }

    /**
     * Values for DeliveryForm(668).
     */
    public static class DeliveryFormValues {

        public static final int BookEntry = 1;
        public static final int Bearer    = 2;

        private DeliveryFormValues() {
        }

    }

    /**
     * Values for LegSwapType(690).
     */
    public static class LegSwapTypeValues {

        public static final int ParForPar        = 1;
        public static final int ModifiedDuration = 2;
        public static final int Risk             = 4;
        public static final int Proceeds         = 5;

        private LegSwapTypeValues() {
        }

    }

    /**
     * Values for QuotePriceType(692).
     */
    public static class QuotePriceTypeValues {

        public static final int Percent                        = 1;
        public static final int PerShare                       = 2;
        public static final int FixedAmount                    = 3;
        public static final int Discount                       = 4;
        public static final int Premium                        = 5;
        public static final int Spread                         = 6;
        public static final int TEDPrice                       = 7;
        public static final int TEDYield                       = 8;
        public static final int YieldSpread                    = 9;
        public static final int Yield                          = 10;
        public static final int PriceSpread                    = 12;
        public static final int ProductTicksInHalves           = 13;
        public static final int ProductTicksInFourths          = 14;
        public static final int ProductTicksInEighths          = 15;
        public static final int ProductTicksInSixteenths       = 16;
        public static final int ProductTicksInThirtySeconds    = 17;
        public static final int ProductTicksInSixtyFourths     = 18;
        public static final int ProductTicksInOneTwentyEighths = 19;
        public static final int NormalRateRepresentation       = 20;
        public static final int InverseRateRepresentation      = 21;
        public static final int BasisPoints                    = 22;
        public static final int UpFrontPoints                  = 23;
        public static final int InterestRate                   = 24;
        public static final int PercentageOfNotional           = 25;

        private QuotePriceTypeValues() {
        }

    }

    /**
     * Values for QuoteRespType(694).
     */
    public static class QuoteRespTypeValues {

        public static final int Hit               = 1;
        public static final int Counter           = 2;
        public static final int Expired           = 3;
        public static final int Cover             = 4;
        public static final int DoneAway          = 5;
        public static final int Pass              = 6;
        public static final int EndTrade          = 7;
        public static final int TimedOut          = 8;
        public static final int Tied              = 9;
        public static final int TiedCover         = 10;
        public static final int Accept            = 11;
        public static final int TerminateContract = 12;

        private QuoteRespTypeValues() {
        }

    }

    /**
     * Values for PosType(703).
     */
    public static class PosTypeValues {

        public static final String AllocationTradeQty                        = "ALC";
        public static final String OptionAssignment                          = "AS";
        public static final String AsOfTradeQty                              = "ASF";
        public static final String DeliveryQty                               = "DLV";
        public static final String ElectronicTradeQty                        = "ETR";
        public static final String OptionExerciseQty                         = "EX";
        public static final String EndOfDayQty                               = "FIN";
        public static final String IntraSpreadQty                            = "IAS";
        public static final String InterSpreadQty                            = "IES";
        public static final String AdjustmentQty                             = "PA";
        public static final String PitTradeQty                               = "PIT";
        public static final String StartOfDayQty                             = "SOD";
        public static final String IntegralSplit                             = "SPL";
        public static final String TransactionFromAssignment                 = "TA";
        public static final String TotalTransactionQty                       = "TOT";
        public static final String TransactionQuantity                       = "TQ";
        public static final String TransferTradeQty                          = "TRF";
        public static final String TransactionFromExercise                   = "TX";
        public static final String CrossMarginQty                            = "XM";
        public static final String ReceiveQuantity                           = "RCV";
        public static final String CorporateActionAdjustment                 = "CAA";
        public static final String DeliveryNoticeQty                         = "DN";
        public static final String ExchangeForPhysicalQty                    = "EP";
        public static final String PrivatelyNegotiatedTradeQty               = "PNTN";
        public static final String NetDeltaQty                               = "DLT";
        public static final String CreditEventAdjustment                     = "CEA";
        public static final String SuccessionEventAdjustment                 = "SEA";
        public static final String NetQty                                    = "NET";
        public static final String GrossQty                                  = "GRS";
        public static final String IntradayQty                               = "ITD";
        public static final String GrossLongNonDeltaAdjustedSwaptionPosition = "NDAS";
        public static final String LongDeltaAdjustedPairedSwaptionPosition   = "DAS";
        public static final String ExpiringQuantity                          = "EXP";
        public static final String QuantityNotExercised                      = "UNEX";
        public static final String RequestedExerciseQuantity                 = "REQ";
        public static final String CashFuturesEquivalentQuantity             = "CFE";
        public static final String LoanOrBorrowedQuantity                    = "SECLN";

        private PosTypeValues() {
        }

    }

    /**
     * Values for PosQtyStatus(706).
     */
    public static class PosQtyStatusValues {

        public static final int Submitted = 0;
        public static final int Accepted  = 1;
        public static final int Rejected  = 2;

        private PosQtyStatusValues() {
        }

    }

    /**
     * Values for PosAmtType(707).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPosAmtType(1588)</li>
     *   <li>TradeAllocAmtType(1845)</li>
     * </ul>
     */
    public static class PosAmtTypeValues {

        public static final String CashAmount                            = "CASH";
        public static final String CashResidualAmount                    = "CRES";
        public static final String FinalMarkToMarketAmount               = "FMTM";
        public static final String IncrementalMarkToMarketAmount         = "IMTM";
        public static final String PremiumAmount                         = "PREM";
        public static final String StartOfDayMarkToMarketAmount          = "SMTM";
        public static final String TradeVariationAmount                  = "TVAR";
        public static final String ValueAdjustedAmount                   = "VADJ";
        public static final String SettlementValue                       = "SETL";
        public static final String InitialTradeCouponAmount              = "ICPN";
        public static final String AccruedCouponAmount                   = "ACPN";
        public static final String CouponAmount                          = "CPN";
        public static final String IncrementalAccruedCoupon              = "IACPN";
        public static final String CollateralizedMarkToMarket            = "CMTM";
        public static final String IncrementalCollateralizedMarkToMarket = "ICMTM";
        public static final String CompensationAmount                    = "DLV";
        public static final String TotalBankedAmount                     = "BANK";
        public static final String TotalCollateralizedAmount             = "COLAT";
        public static final String LongPairedSwapNotionalValue           = "LSNV";
        public static final String ShortPairedSwapNotionalValue          = "SSNV";
        public static final String StartOfDayAccruedCoupon               = "SACPN";
        public static final String NetPresentValue                       = "NPV";
        public static final String StartOfDayNetPresentValue             = "SNPV";
        public static final String NetCashFlow                           = "NCF";
        public static final String PresentValueOfFees                    = "PVFEES";
        public static final String PresentValueOneBasisPoints            = "PV01";
        public static final String FiveYearEquivalentNotional            = "5YREN";
        public static final String UndiscountedMarkToMarket              = "UMTM";
        public static final String MarkToModel                           = "MTD";
        public static final String MarkToMarketVariance                  = "VMTM";
        public static final String MarkToModelVariance                   = "VMTD";
        public static final String UpfrontPayment                        = "UPFRNT";
        public static final String EndVale                               = "ENDV";
        public static final String OutstandingMarginLoan                 = "MGNLN";
        public static final String LoanValue                             = "LNVL";

        private PosAmtTypeValues() {
        }

    }

    /**
     * Values for PosTransType(709).
     */
    public static class PosTransTypeValues {

        public static final int Exercise                          = 1;
        public static final int DoNotExercise                     = 2;
        public static final int PositionAdjustment                = 3;
        public static final int PositionChangeSubmission          = 4;
        public static final int Pledge                            = 5;
        public static final int LargeTraderSubmission             = 6;
        public static final int LargePositionsReportingSubmission = 7;
        public static final int LongHoldings                      = 8;
        public static final int InternalTransfer                  = 9;
        public static final int TransferOfFirm                    = 10;
        public static final int ExternalTransfer                  = 11;
        public static final int CorporateAction                   = 12;
        public static final int Notification                      = 13;
        public static final int PositionCreation                  = 14;
        public static final int Closeout                          = 15;
        public static final int Reopen                            = 16;

        private PosTransTypeValues() {
        }

    }

    /**
     * Values for PosMaintAction(712).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>PosReportAction(2364)</li>
     * </ul>
     */
    public static class PosMaintActionValues {

        public static final int New     = 1;
        public static final int Replace = 2;
        public static final int Cancel  = 3;
        public static final int Reverse = 4;

        private PosMaintActionValues() {
        }

    }

    /**
     * Values for SettlSessID(716).
     */
    public static class SettlSessIDValues {

        public static final String Intraday               = "ITD";
        public static final String RegularTradingHours    = "RTH";
        public static final String ElectronicTradingHours = "ETH";
        public static final String EndOfDay               = "EOD";

        private SettlSessIDValues() {
        }

    }

    /**
     * Values for AdjustmentType(718).
     */
    public static class AdjustmentTypeValues {

        public static final int ProcessRequestAsMarginDisposition = 0;
        public static final int DeltaPlus                         = 1;
        public static final int DeltaMinus                        = 2;
        public static final int Final                             = 3;
        public static final int CustomerSpecificPosition          = 4;

        private AdjustmentTypeValues() {
        }

    }

    /**
     * Values for PosMaintStatus(722).
     */
    public static class PosMaintStatusValues {

        public static final int Accepted              = 0;
        public static final int AcceptedWithWarnings  = 1;
        public static final int Rejected              = 2;
        public static final int Completed             = 3;
        public static final int CompletedWithWarnings = 4;

        private PosMaintStatusValues() {
        }

    }

    /**
     * Values for PosMaintResult(723).
     */
    public static class PosMaintResultValues {

        public static final int SuccessfulCompletion = 0;
        public static final int Rejected             = 1;
        public static final int Other                = 99;

        private PosMaintResultValues() {
        }

    }

    /**
     * Values for PosReqType(724).
     */
    public static class PosReqTypeValues {

        public static final int Positions                           = 0;
        public static final int Trades                              = 1;
        public static final int Exercises                           = 2;
        public static final int Assignments                         = 3;
        public static final int SettlementActivity                  = 4;
        public static final int BackoutMessage                      = 5;
        public static final int DeltaPositions                      = 6;
        public static final int NetPosition                         = 7;
        public static final int LargePositionsReporting             = 8;
        public static final int ExercisePositionReportingSubmission = 9;
        public static final int PositionLimitReportingSubmissing    = 10;

        private PosReqTypeValues() {
        }

    }

    /**
     * Values for ResponseTransportType(725).
     */
    public static class ResponseTransportTypeValues {

        public static final int Inband    = 0;
        public static final int OutOfBand = 1;

        private ResponseTransportTypeValues() {
        }

    }

    /**
     * Values for PosReqResult(728).
     */
    public static class PosReqResultValues {

        public static final int ValidRequest                      = 0;
        public static final int InvalidOrUnsupportedRequest       = 1;
        public static final int NoPositionsFoundThatMatchCriteria = 2;
        public static final int NotAuthorizedToRequestPositions   = 3;
        public static final int RequestForPositionNotSupported    = 4;
        public static final int Other                             = 99;

        private PosReqResultValues() {
        }

    }

    /**
     * Values for PosReqStatus(729).
     */
    public static class PosReqStatusValues {

        public static final int Completed             = 0;
        public static final int CompletedWithWarnings = 1;
        public static final int Rejected              = 2;

        private PosReqStatusValues() {
        }

    }

    /**
     * Values for SettlPriceType(731).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingSettlPriceType(733)</li>
     * </ul>
     */
    public static class SettlPriceTypeValues {

        public static final int Final       = 1;
        public static final int Theoretical = 2;

        private SettlPriceTypeValues() {
        }

    }

    /**
     * Values for AssignmentMethod(744).
     */
    public static class AssignmentMethodValues {

        public static final char ProRata = 'P';
        public static final char Random  = 'R';

        private AssignmentMethodValues() {
        }

    }

    /**
     * Values for ExerciseMethod(747).
     */
    public static class ExerciseMethodValues {

        public static final char Automatic = 'A';
        public static final char Manual    = 'M';

        private ExerciseMethodValues() {
        }

    }

    /**
     * Values for TradeRequestResult(749).
     */
    public static class TradeRequestResultValues {

        public static final int Successful                    = 0;
        public static final int InvalidOrUnknownInstrument    = 1;
        public static final int InvalidTypeOfTradeRequested   = 2;
        public static final int InvalidParties                = 3;
        public static final int InvalidTransportTypeRequested = 4;
        public static final int InvalidDestinationRequested   = 5;
        public static final int TradeRequestTypeNotSupported  = 8;
        public static final int NotAuthorized                 = 9;
        public static final int Other                         = 99;

        private TradeRequestResultValues() {
        }

    }

    /**
     * Values for TradeRequestStatus(750).
     */
    public static class TradeRequestStatusValues {

        public static final int Accepted  = 0;
        public static final int Completed = 1;
        public static final int Rejected  = 2;

        private TradeRequestStatusValues() {
        }

    }

    /**
     * Values for TradeReportRejectReason(751).
     */
    public static class TradeReportRejectReasonValues {

        public static final int Successful                    = 0;
        public static final int InvalidPartyInformation       = 1;
        public static final int UnknownInstrument             = 2;
        public static final int UnauthorizedToReportTrades    = 3;
        public static final int InvalidTradeType              = 4;
        public static final int PriceExceedsCurrentPriceBand  = 5;
        public static final int ReferencePriceNotAvailable    = 6;
        public static final int NotionalValueExceedsThreshold = 7;
        public static final int Other                         = 99;

        private TradeReportRejectReasonValues() {
        }

    }

    /**
     * Values for SideMultiLegReportingType(752).
     */
    public static class SideMultiLegReportingTypeValues {

        public static final int SingleSecurity                   = 1;
        public static final int IndividualLegOfAMultilegSecurity = 2;
        public static final int MultilegSecurity                 = 3;

        private SideMultiLegReportingTypeValues() {
        }

    }

    /**
     * Values for TrdRegTimestampType(770).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SideTrdRegTimestampType(1013)</li>
     * </ul>
     */
    public static class TrdRegTimestampTypeValues {

        public static final int ExecutionTime              = 1;
        public static final int TimeIn                     = 2;
        public static final int TimeOut                    = 3;
        public static final int BrokerReceipt              = 4;
        public static final int BrokerExecution            = 5;
        public static final int DeskReceipt                = 6;
        public static final int SubmissionToClearing       = 7;
        public static final int TimePriority               = 8;
        public static final int OrderbookEntryTime         = 9;
        public static final int OrderSubmissionTime        = 10;
        public static final int PubliclyReported           = 11;
        public static final int PublicReportUpdated        = 12;
        public static final int NonPubliclyReported        = 13;
        public static final int NonPublicReportUpdated     = 14;
        public static final int SubmittedForConfirmation   = 15;
        public static final int UpdatedForConfirmation     = 16;
        public static final int Confirmed                  = 17;
        public static final int UpdatedForClearing         = 18;
        public static final int Cleared                    = 19;
        public static final int AllocationsSubmitted       = 20;
        public static final int AllocationsUpdated         = 21;
        public static final int AllocationsCompleted       = 22;
        public static final int SubmittedToRepository      = 23;
        public static final int PostTrdContntnEvnt         = 24;
        public static final int PostTradeValuation         = 25;
        public static final int PreviousTimePriority       = 26;
        public static final int IdentifierAssigned         = 27;
        public static final int PreviousIdentifierAssigned = 28;
        public static final int OrderCancellationTime      = 29;
        public static final int OrderModificationTime      = 30;
        public static final int OrderRoutingTime           = 31;
        public static final int TradeCancellationTime      = 32;
        public static final int TradeModificationTime      = 33;
        public static final int ReferenceTimeForNBBO       = 34;

        private TrdRegTimestampTypeValues() {
        }

    }

    /**
     * Values for ConfirmType(773).
     */
    public static class ConfirmTypeValues {

        public static final int Status                      = 1;
        public static final int Confirmation                = 2;
        public static final int ConfirmationRequestRejected = 3;

        private ConfirmTypeValues() {
        }

    }

    /**
     * Values for ConfirmRejReason(774).
     */
    public static class ConfirmRejReasonValues {

        public static final int MismatchedAccount                      = 1;
        public static final int MissingSettlementInstructions          = 2;
        public static final int UnknownOrMissingIndividualAllocId      = 3;
        public static final int TransactionNotRecognized               = 4;
        public static final int DuplicateTransaction                   = 5;
        public static final int IncorrectOrMissingInstrument           = 6;
        public static final int IncorrectOrMissingPrice                = 7;
        public static final int IncorrectOrMissingCommission           = 8;
        public static final int IncorrectOrMissingSettlDate            = 9;
        public static final int IncorrectOrMissingFundIDOrFundName     = 10;
        public static final int IncorrectOrMissingQuantity             = 11;
        public static final int IncorrectOrMissingFees                 = 12;
        public static final int IncorrectOrMissingTax                  = 13;
        public static final int IncorrectOrMissingParty                = 14;
        public static final int IncorrectOrMissingSide                 = 15;
        public static final int IncorrectOrMissingNetMoney             = 16;
        public static final int IncorrectOrMissingTradeDate            = 17;
        public static final int IncorrectOrMissingSettlCcyInstructions = 18;
        public static final int IncorrectOrMissingCapacity             = 19;
        public static final int Other                                  = 99;

        private ConfirmRejReasonValues() {
        }

    }

    /**
     * Values for BookingType(775).
     */
    public static class BookingTypeValues {

        public static final int RegularBooking  = 0;
        public static final int CFD             = 1;
        public static final int TotalReturnSwap = 2;

        private BookingTypeValues() {
        }

    }

    /**
     * Values for AllocSettlInstType(780).
     */
    public static class AllocSettlInstTypeValues {

        public static final int UseDefaultInstructions       = 0;
        public static final int DeriveFromParametersProvided = 1;
        public static final int FullDetailsProvided          = 2;
        public static final int SSIDBIDsProvided             = 3;
        public static final int PhoneForInstructions         = 4;

        private AllocSettlInstTypeValues() {
        }

    }

    /**
     * Values for DlvyInstType(787).
     */
    public static class DlvyInstTypeValues {

        public static final char Cash       = 'C';
        public static final char Securities = 'S';

        private DlvyInstTypeValues() {
        }

    }

    /**
     * Values for TerminationType(788).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegTerminationType(2514)</li>
     * </ul>
     */
    public static class TerminationTypeValues {

        public static final int Overnight = 1;
        public static final int Term      = 2;
        public static final int Flexible  = 3;
        public static final int Open      = 4;

        private TerminationTypeValues() {
        }

    }

    /**
     * Values for SettlInstReqRejCode(792).
     */
    public static class SettlInstReqRejCodeValues {

        public static final int UnableToProcessRequest                = 0;
        public static final int UnknownAccount                        = 1;
        public static final int NoMatchingSettlementInstructionsFound = 2;
        public static final int Other                                 = 99;

        private SettlInstReqRejCodeValues() {
        }

    }

    /**
     * Values for AllocReportType(794).
     */
    public static class AllocReportTypeValues {

        public static final int PreliminaryRequestToIntermediary     = 2;
        public static final int SellsideCalculatedUsingPreliminary   = 3;
        public static final int SellsideCalculatedWithoutPreliminary = 4;
        public static final int WarehouseRecap                       = 5;
        public static final int RequestToIntermediary                = 8;
        public static final int Accept                               = 9;
        public static final int Reject                               = 10;
        public static final int AcceptPending                        = 11;
        public static final int Complete                             = 12;
        public static final int ReversePending                       = 14;
        public static final int Giveup                               = 15;
        public static final int Takeup                               = 16;
        public static final int Reversal                             = 17;
        public static final int Alleged                              = 18;
        public static final int SubAllocationGiveup                  = 19;

        private AllocReportTypeValues() {
        }

    }

    /**
     * Values for AllocCancReplaceReason(796).
     */
    public static class AllocCancReplaceReasonValues {

        public static final int OriginalDetailsIncomplete      = 1;
        public static final int ChangeInUnderlyingOrderDetails = 2;
        public static final int CancelledByGiveupFirm          = 3;
        public static final int Other                          = 99;

        private AllocCancReplaceReasonValues() {
        }

    }

    /**
     * Values for AllocAccountType(798).
     */
    public static class AllocAccountTypeValues {

        public static final int CarriedCustomerSide                 = 1;
        public static final int CarriedNonCustomerSide              = 2;
        public static final int HouseTrader                         = 3;
        public static final int FloorTrader                         = 4;
        public static final int CarriedNonCustomerSideCrossMargined = 6;
        public static final int HouseTraderCrossMargined            = 7;
        public static final int JointBackOfficeAccount              = 8;

        private AllocAccountTypeValues() {
        }

    }

    /**
     * Values for PartySubIDType(803).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SettlPartySubIDType(786)</li>
     *   <li>NestedPartySubIDType(805)</li>
     *   <li>Nested2PartySubIDType(807)</li>
     *   <li>Nested3PartySubIDType(954)</li>
     *   <li>InstrumentPartySubIDType(1054)</li>
     *   <li>UnderlyingInstrumentPartySubIDType(1064)</li>
     *   <li>RootPartySubIDType(1122)</li>
     *   <li>DerivativeInstrumentPartySubIDType(1298)</li>
     *   <li>Nested4PartySubIDType(1411)</li>
     *   <li>PartyDetailAltSubIDType(1521)</li>
     *   <li>RelatedPartyDetailSubIDType(1568)</li>
     *   <li>RelatedPartyDetailAltSubIDType(1574)</li>
     *   <li>RequestingPartySubIDType(1663)</li>
     *   <li>PartyDetailSubIDType(1696)</li>
     *   <li>LegInstrumentPartySubIDType(2260)</li>
     *   <li>TargetPartySubIDType(2435)</li>
     *   <li>ProvisionPartySubIDType(40180)</li>
     *   <li>PaymentSettlPartySubIDType(40240)</li>
     *   <li>LegProvisionPartySubIDType(40539)</li>
     *   <li>UnderlyingProvisionPartySubIDType(42179)</li>
     * </ul>
     */
    public static class PartySubIDTypeValues {

        public static final int Firm                                = 1;
        public static final int Person                              = 2;
        public static final int System                              = 3;
        public static final int Application                         = 4;
        public static final int FullLegalNameOfFirm                 = 5;
        public static final int PostalAddress                       = 6;
        public static final int PhoneNumber                         = 7;
        public static final int EmailAddress                        = 8;
        public static final int ContactName                         = 9;
        public static final int SecuritiesAccountNumber             = 10;
        public static final int RegistrationNumber                  = 11;
        public static final int RegisteredAddressForConfirmation    = 12;
        public static final int RegulatoryStatus                    = 13;
        public static final int RegistrationName                    = 14;
        public static final int CashAccountNumber                   = 15;
        public static final int BIC                                 = 16;
        public static final int CSDParticipantMemberCode            = 17;
        public static final int RegisteredAddress                   = 18;
        public static final int FundAccountName                     = 19;
        public static final int TelexNumber                         = 20;
        public static final int FaxNumber                           = 21;
        public static final int SecuritiesAccountName               = 22;
        public static final int CashAccountName                     = 23;
        public static final int Department                          = 24;
        public static final int LocationDesk                        = 25;
        public static final int PositionAccountType                 = 26;
        public static final int SecurityLocateID                    = 27;
        public static final int MarketMaker                         = 28;
        public static final int EligibleCounterparty                = 29;
        public static final int ProfessionalClient                  = 30;
        public static final int Location                            = 31;
        public static final int ExecutionVenue                      = 32;
        public static final int CurrencyDeliveryIdentifier          = 33;
        public static final int AddressCity                         = 34;
        public static final int AddressStateOrProvince              = 35;
        public static final int AddressPostalCode                   = 36;
        public static final int AddressStreet                       = 37;
        public static final int AddressISOCountryCode               = 38;
        public static final int ISOCountryCode                      = 39;
        public static final int MarketSegment                       = 40;
        public static final int CustomerAccountType                 = 41;
        public static final int OmnibusAccount                      = 42;
        public static final int FundsSegregationType                = 43;
        public static final int GuaranteeFund                       = 44;
        public static final int SwapDealer                          = 45;
        public static final int MajorParticipant                    = 46;
        public static final int FinancialEntity                     = 47;
        public static final int USPerson                            = 48;
        public static final int ReportingEntityIndicator            = 49;
        public static final int ElectedClearingRequirementException = 50;
        public static final int BusinessCenter                      = 51;
        public static final int ReferenceText                       = 52;
        public static final int ShortMarkingExemptAccount           = 53;
        public static final int ParentFirmIdentifier                = 54;
        public static final int ParentFirmName                      = 55;
        public static final int DealIdentifier                      = 56;
        public static final int SystemTradeID                       = 57;
        public static final int SystemTradeSubID                    = 58;
        public static final int FCMCode                             = 59;
        public static final int DlvryTrmlCode                       = 60;
        public static final int VolntyRptEntity                     = 61;
        public static final int RptObligJursdctn                    = 62;
        public static final int VolntyRptJursdctn                   = 63;
        public static final int CompanyActivities                   = 64;
        public static final int EEAreaDomiciled                     = 65;
        public static final int ContractLinked                      = 66;
        public static final int ContractAbove                       = 67;
        public static final int VolntyRptPty                        = 68;
        public static final int EndUser                             = 69;
        public static final int LocationOrJurisdiction              = 70;
        public static final int DerivativesDealer                   = 71;
        public static final int Domicile                            = 72;
        public static final int ExemptFromRecognition               = 73;
        public static final int Payer                               = 74;
        public static final int Receiver                            = 75;
        public static final int SystematicInternaliser              = 76;
        public static final int PublishingEntityIndicator           = 77;
        public static final int FirstName                           = 78;
        public static final int Surname                             = 79;
        public static final int DateOfBirth                         = 80;
        public static final int OrderTransmittingFirm               = 81;
        public static final int OrderTransmittingFirmBuyer          = 82;
        public static final int OrderTransmitterSeller              = 83;
        public static final int LegalEntityIdentifier               = 84;
        public static final int SubSectorClassification             = 85;
        public static final int PartySide                           = 86;
        public static final int LegalRegistrationCountry            = 87;

        private PartySubIDTypeValues() {
        }

    }

    /**
     * Values for AllocIntermedReqType(808).
     */
    public static class AllocIntermedReqTypeValues {

        public static final int PendingAccept      = 1;
        public static final int PendingRelease     = 2;
        public static final int PendingReversal    = 3;
        public static final int Accept             = 4;
        public static final int BlockLevelReject   = 5;
        public static final int AccountLevelReject = 6;

        private AllocIntermedReqTypeValues() {
        }

    }

    /**
     * Values for ApplQueueResolution(814).
     */
    public static class ApplQueueResolutionValues {

        public static final int NoActionTaken = 0;
        public static final int QueueFlushed  = 1;
        public static final int OverlayLast   = 2;
        public static final int EndSession    = 3;

        private ApplQueueResolutionValues() {
        }

    }

    /**
     * Values for ApplQueueAction(815).
     */
    public static class ApplQueueActionValues {

        public static final int NoActionTaken = 0;
        public static final int QueueFlushed  = 1;
        public static final int OverlayLast   = 2;
        public static final int EndSession    = 3;

        private ApplQueueActionValues() {
        }

    }

    /**
     * Values for AvgPxIndicator(819).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>AllocAvgPxIndicator(2769)</li>
     * </ul>
     */
    public static class AvgPxIndicatorValues {

        public static final int NoAveragePricing                 = 0;
        public static final int Trade                            = 1;
        public static final int LastTrade                        = 2;
        public static final int NotionalValueAveragePxGroupTrade = 3;
        public static final int AveragePricedTrade               = 4;

        private AvgPxIndicatorValues() {
        }

    }

    /**
     * Values for TradeAllocIndicator(826).
     */
    public static class TradeAllocIndicatorValues {

        public static final int AllocationNotRequired             = 0;
        public static final int AllocationRequired                = 1;
        public static final int UseAllocationProvidedWithTheTrade = 2;
        public static final int AllocationGiveUpExecutor          = 3;
        public static final int AllocationFromExecutor            = 4;
        public static final int AllocationToClaimAccount          = 5;
        public static final int TradeSplit                        = 6;

        private TradeAllocIndicatorValues() {
        }

    }

    /**
     * Values for ExpirationCycle(827).
     */
    public static class ExpirationCycleValues {

        public static final int ExpireOnTradingSessionClose = 0;
        public static final int ExpireOnTradingSessionOpen  = 1;
        public static final int SpecifiedExpiration         = 2;

        private ExpirationCycleValues() {
        }

    }

    /**
     * Values for TrdType(828).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SecondaryTrdType(855)</li>
     *   <li>TertiaryTrdType(2896)</li>
     * </ul>
     */
    public static class TrdTypeValues {

        public static final int RegularTrade                     = 0;
        public static final int BlockTrade                       = 1;
        public static final int EFP                              = 2;
        public static final int Transfer                         = 3;
        public static final int LateTrade                        = 4;
        public static final int TTrade                           = 5;
        public static final int WeightedAveragePriceTrade        = 6;
        public static final int BunchedTrade                     = 7;
        public static final int LateBunchedTrade                 = 8;
        public static final int PriorReferencePriceTrade         = 9;
        public static final int AfterHoursTrade                  = 10;
        public static final int ExchangeForRisk                  = 11;
        public static final int ExchangeForSwap                  = 12;
        public static final int ExchangeOfFuturesFor             = 13;
        public static final int ExchangeOfOptionsForOptions      = 14;
        public static final int TradingAtSettlement              = 15;
        public static final int AllOrNone                        = 16;
        public static final int FuturesLargeOrderExecution       = 17;
        public static final int ExchangeOfFuturesForFutures      = 18;
        public static final int OptionInterimTrade               = 19;
        public static final int OptionCabinetTrade               = 20;
        public static final int PrivatelyNegotiatedTrades        = 22;
        public static final int SubstitutionOfFuturesForForwards = 23;
        public static final int ErrorTrade                       = 24;
        public static final int SpecialCumDividend               = 25;
        public static final int SpecialExDividend                = 26;
        public static final int SpecialCumCoupon                 = 27;
        public static final int SpecialExCoupon                  = 28;
        public static final int CashSettlement                   = 29;
        public static final int SpecialPrice                     = 30;
        public static final int GuaranteedDelivery               = 31;
        public static final int SpecialCumRights                 = 32;
        public static final int SpecialExRights                  = 33;
        public static final int SpecialCumCapitalRepayments      = 34;
        public static final int SpecialExCapitalRepayments       = 35;
        public static final int SpecialCumBonus                  = 36;
        public static final int SpecialExBonus                   = 37;
        public static final int LargeTrade                       = 38;
        public static final int WorkedPrincipalTrade             = 39;
        public static final int BlockTrades                      = 40;
        public static final int NameChange                       = 41;
        public static final int PortfolioTransfer                = 42;
        public static final int ProrogationBuy                   = 43;
        public static final int ProrogationSell                  = 44;
        public static final int OptionExercise                   = 45;
        public static final int DeltaNeutralTransaction          = 46;
        public static final int FinancingTransaction             = 47;
        public static final int NonStandardSettlement            = 48;
        public static final int DerivativeRelatedTransaction     = 49;
        public static final int PortfolioTrade                   = 50;
        public static final int VolumeWeightedAverageTrade       = 51;
        public static final int ExchangeGrantedTrade             = 52;
        public static final int RepurchaseAgreement              = 53;
        public static final int OTC                              = 54;
        public static final int ExchangeBasisFacility            = 55;
        public static final int OpeningTrade                     = 56;
        public static final int NettedTrade                      = 57;
        public static final int BlockSwapTrade                   = 58;
        public static final int CreditEventTrade                 = 59;
        public static final int SuccessionEventTrade             = 60;
        public static final int GiveUpGiveInTrade                = 61;
        public static final int DarkTrade                        = 62;
        public static final int TechnicalTrade                   = 63;
        public static final int Benchmark                        = 64;
        public static final int PackageTrade                     = 65;
        public static final int RollTrade                        = 66;

        private TrdTypeValues() {
        }

    }

    /**
     * Values for TrdSubType(829).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SideTrdSubType(1008)</li>
     * </ul>
     */
    public static class TrdSubTypeValues {

        public static final int CMTA                                      = 0;
        public static final int InternalTransferOrAdjustment              = 1;
        public static final int ExternalTransferOrTransferOfAccount       = 2;
        public static final int RejectForSubmittingSide                   = 3;
        public static final int AdvisoryForContraSide                     = 4;
        public static final int OffsetDueToAnAllocation                   = 5;
        public static final int OnsetDueToAnAllocation                    = 6;
        public static final int DifferentialSpread                        = 7;
        public static final int ImpliedSpreadLegExecutedAgainstAnOutright = 8;
        public static final int TransactionFromExercise                   = 9;
        public static final int TransactionFromAssignment                 = 10;
        public static final int ACATS                                     = 11;
        public static final int AI                                        = 14;
        public static final int B                                         = 15;
        public static final int K                                         = 16;
        public static final int LC                                        = 17;
        public static final int M                                         = 18;
        public static final int N                                         = 19;
        public static final int NM                                        = 20;
        public static final int NR                                        = 21;
        public static final int P                                         = 22;
        public static final int PA                                        = 23;
        public static final int PC                                        = 24;
        public static final int PN                                        = 25;
        public static final int R                                         = 26;
        public static final int RO                                        = 27;
        public static final int RT                                        = 28;
        public static final int SW                                        = 29;
        public static final int T                                         = 30;
        public static final int WN                                        = 31;
        public static final int WT                                        = 32;
        public static final int OffHoursTrade                             = 33;
        public static final int OnHoursTrade                              = 34;
        public static final int OTCQuote                                  = 35;
        public static final int ConvertedSWAP                             = 36;
        public static final int CrossedTrade                              = 37;
        public static final int InterimProtectedTrade                     = 38;
        public static final int LargeInScale                              = 39;
        public static final int WashTrade                                 = 40;
        public static final int TradeAtSettlement                         = 41;
        public static final int AuctionTrade                              = 42;
        public static final int TradeAtMarker                             = 43;
        public static final int CreditDefault                             = 44;
        public static final int CreditRestructuring                       = 45;
        public static final int Merger                                    = 46;
        public static final int SpinOff                                   = 47;
        public static final int MultilateralCompression                   = 48;
        public static final int Balancing                                 = 50;
        public static final int BasisTradeIndexClose                      = 51;
        public static final int TradeAtCashOpen                           = 52;
        public static final int TrdSubmitVenueClrSettl                    = 53;
        public static final int BilateralCompression                      = 54;

        private TrdSubTypeValues() {
        }

    }

    /**
     * Values for PegMoveType(835).
     */
    public static class PegMoveTypeValues {

        public static final int Floating = 0;
        public static final int Fixed    = 1;

        private PegMoveTypeValues() {
        }

    }

    /**
     * Values for PegOffsetType(836).
     */
    public static class PegOffsetTypeValues {

        public static final int Price       = 0;
        public static final int BasisPoints = 1;
        public static final int Ticks       = 2;
        public static final int PriceTier   = 3;
        public static final int Percentage  = 4;

        private PegOffsetTypeValues() {
        }

    }

    /**
     * Values for PegLimitType(837).
     */
    public static class PegLimitTypeValues {

        public static final int OrBetter = 0;
        public static final int Strict   = 1;
        public static final int OrWorse  = 2;

        private PegLimitTypeValues() {
        }

    }

    /**
     * Values for PegRoundDirection(838).
     */
    public static class PegRoundDirectionValues {

        public static final int MoreAggressive = 1;
        public static final int MorePassive    = 2;

        private PegRoundDirectionValues() {
        }

    }

    /**
     * Values for PegScope(840).
     */
    public static class PegScopeValues {

        public static final int Local                  = 1;
        public static final int National               = 2;
        public static final int Global                 = 3;
        public static final int NationalExcludingLocal = 4;

        private PegScopeValues() {
        }

    }

    /**
     * Values for DiscretionMoveType(841).
     */
    public static class DiscretionMoveTypeValues {

        public static final int Floating = 0;
        public static final int Fixed    = 1;

        private DiscretionMoveTypeValues() {
        }

    }

    /**
     * Values for DiscretionOffsetType(842).
     */
    public static class DiscretionOffsetTypeValues {

        public static final int Price       = 0;
        public static final int BasisPoints = 1;
        public static final int Ticks       = 2;
        public static final int PriceTier   = 3;

        private DiscretionOffsetTypeValues() {
        }

    }

    /**
     * Values for DiscretionLimitType(843).
     */
    public static class DiscretionLimitTypeValues {

        public static final int OrBetter = 0;
        public static final int Strict   = 1;
        public static final int OrWorse  = 2;

        private DiscretionLimitTypeValues() {
        }

    }

    /**
     * Values for DiscretionRoundDirection(844).
     */
    public static class DiscretionRoundDirectionValues {

        public static final int MoreAggressive = 1;
        public static final int MorePassive    = 2;

        private DiscretionRoundDirectionValues() {
        }

    }

    /**
     * Values for DiscretionScope(846).
     */
    public static class DiscretionScopeValues {

        public static final int Local                  = 1;
        public static final int National               = 2;
        public static final int Global                 = 3;
        public static final int NationalExcludingLocal = 4;

        private DiscretionScopeValues() {
        }

    }

    /**
     * Values for TargetStrategy(847).
     */
    public static class TargetStrategyValues {

        public static final int VWAP                 = 1;
        public static final int Participate          = 2;
        public static final int MininizeMarketImpact = 3;

        private TargetStrategyValues() {
        }

    }

    /**
     * Values for LastLiquidityInd(851).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>FillLiquidityInd(1443)</li>
     *   <li>SideLiquidityInd(1444)</li>
     *   <li>OrderEventLiquidityIndicator(1801)</li>
     * </ul>
     */
    public static class LastLiquidityIndValues {

        public static final int NeitherAddedNorRemovedLiquidity          = 0;
        public static final int AddedLiquidity                           = 1;
        public static final int RemovedLiquidity                         = 2;
        public static final int LiquidityRoutedOut                       = 3;
        public static final int Auction                                  = 4;
        public static final int TriggeredStopOrder                       = 5;
        public static final int TriggeredContingencyOrder                = 6;
        public static final int TriggeredMarketOrder                     = 7;
        public static final int RemovedLiquidityAfterFirmOrderCommitment = 8;
        public static final int AuctionExecutionAfterFirmOrderCommitment = 9;

        private LastLiquidityIndValues() {
        }

    }

    /**
     * Values for ShortSaleReason(853).
     */
    public static class ShortSaleReasonValues {

        public static final int DealerSoldShort                   = 0;
        public static final int DealerSoldShortExempt             = 1;
        public static final int SellingCustomerSoldShort          = 2;
        public static final int SellingCustomerSoldShortExempt    = 3;
        public static final int QualifiedServiceRepresentative    = 4;
        public static final int QSROrAGUContraSideSoldShortExempt = 5;

        private ShortSaleReasonValues() {
        }

    }

    /**
     * Values for QtyType(854).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegQtyType(1591)</li>
     * </ul>
     */
    public static class QtyTypeValues {

        public static final int Units                     = 0;
        public static final int Contracts                 = 1;
        public static final int UnitsOfMeasurePerTimeUnit = 2;

        private QtyTypeValues() {
        }

    }

    /**
     * Values for TradeReportType(856).
     */
    public static class TradeReportTypeValues {

        public static final int Submit                   = 0;
        public static final int Alleged                  = 1;
        public static final int Accept                   = 2;
        public static final int Decline                  = 3;
        public static final int Addendum                 = 4;
        public static final int No                       = 5;
        public static final int TradeReportCancel        = 6;
        public static final int LockedIn                 = 7;
        public static final int Defaulted                = 8;
        public static final int InvalidCMTA              = 9;
        public static final int Pended                   = 10;
        public static final int AllegedNew               = 11;
        public static final int AllegedAddendum          = 12;
        public static final int AllegedNo                = 13;
        public static final int AllegedTradeReportCancel = 14;
        public static final int AllegedTradeBreak        = 15;
        public static final int Verify                   = 16;
        public static final int Dispute                  = 17;
        public static final int NonMaterialUpdate        = 18;

        private TradeReportTypeValues() {
        }

    }

    /**
     * Values for AllocNoOrdersType(857).
     */
    public static class AllocNoOrdersTypeValues {

        public static final int NotSpecified         = 0;
        public static final int ExplicitListProvided = 1;

        private AllocNoOrdersTypeValues() {
        }

    }

    /**
     * Values for EventType(865).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DerivativeEventType(1287)</li>
     *   <li>UnderlyingEventType(1982)</li>
     *   <li>LegEventType(2060)</li>
     * </ul>
     */
    public static class EventTypeValues {

        public static final int Put                     = 1;
        public static final int Call                    = 2;
        public static final int Tender                  = 3;
        public static final int SinkingFundCall         = 4;
        public static final int Activation              = 5;
        public static final int Inactiviation           = 6;
        public static final int LastEligibleTradeDate   = 7;
        public static final int SwapStartDate           = 8;
        public static final int SwapEndDate             = 9;
        public static final int SwapRollDate            = 10;
        public static final int SwapNextStartDate       = 11;
        public static final int SwapNextRollDate        = 12;
        public static final int FirstDeliveryDate       = 13;
        public static final int LastDeliveryDate        = 14;
        public static final int InitialInventoryDueDate = 15;
        public static final int FinalInventoryDueDate   = 16;
        public static final int FirstIntentDate         = 17;
        public static final int LastIntentDate          = 18;
        public static final int PositionRemovalDate     = 19;
        public static final int MinimumNotice           = 20;
        public static final int DeliveryStartTime       = 21;
        public static final int DeliveryEndTime         = 22;
        public static final int FirstNoticeDate         = 23;
        public static final int LastNoticeDate          = 24;
        public static final int FirstExerciseDate       = 25;
        public static final int RedemptionDate          = 26;
        public static final int TrdCntntnEfctvDt        = 27;
        public static final int Other                   = 99;

        private EventTypeValues() {
        }

    }

    /**
     * Values for InstrAttribType(871).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>NestedInstrAttribType(1210)</li>
     *   <li>DerivativeInstrAttribType(1313)</li>
     * </ul>
     */
    public static class InstrAttribTypeValues {

        public static final int Flat                                   = 1;
        public static final int ZeroCoupon                             = 2;
        public static final int InterestBearing                        = 3;
        public static final int NoPeriodicPayments                     = 4;
        public static final int VariableRate                           = 5;
        public static final int LessFeeForPut                          = 6;
        public static final int SteppedCoupon                          = 7;
        public static final int CouponPeriod                           = 8;
        public static final int When                                   = 9;
        public static final int OriginalIssueDiscount                  = 10;
        public static final int Callable                               = 11;
        public static final int EscrowedToMaturity                     = 12;
        public static final int EscrowedToRedemptionDate               = 13;
        public static final int PreRefunded                            = 14;
        public static final int InDefault                              = 15;
        public static final int Unrated                                = 16;
        public static final int Taxable                                = 17;
        public static final int Indexed                                = 18;
        public static final int SubjectToAlternativeMinimumTax         = 19;
        public static final int OriginalIssueDiscountPrice             = 20;
        public static final int CallableBelowMaturityValue             = 21;
        public static final int CallableWithoutNotice                  = 22;
        public static final int PriceTickRulesForSecurity              = 23;
        public static final int TradeTypeEligibilityDetailsForSecurity = 24;
        public static final int InstrumentDenominator                  = 25;
        public static final int InstrumentNumerator                    = 26;
        public static final int InstrumentPricePrecision               = 27;
        public static final int InstrumentStrikePrice                  = 28;
        public static final int TradeableIndicator                     = 29;
        public static final int InstrumentEligibleAnonOrders           = 30;
        public static final int MinGuaranteedFillVolume                = 31;
        public static final int MinGuaranteedFillStatus                = 32;
        public static final int TradeAtSettlementEligibility           = 33;
        public static final int TestInstrument                         = 34;
        public static final int DummyInstrument                        = 35;
        public static final int NegativeSettlementPriceEligibility     = 36;
        public static final int NegativeStrikePriceEligibility         = 37;
        public static final int USStdContractInd                       = 38;
        public static final int AdmittedToTradingOnTradingVenue        = 39;
        public static final int AverageDailyNotionalAmount             = 40;
        public static final int AverageDailyNumberTrades               = 41;
        public static final int Text                                   = 99;

        private InstrAttribTypeValues() {
        }

    }

    /**
     * Values for CPProgram(875).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingCPProgram(877)</li>
     *   <li>LegCPProgram(2207)</li>
     * </ul>
     */
    public static class CPProgramValues {

        public static final int Program3a3       = 1;
        public static final int Program42        = 2;
        public static final int Program3a2       = 3;
        public static final int Program3a3And3c7 = 4;
        public static final int Program3a4       = 5;
        public static final int Program3a5       = 6;
        public static final int Program3a7       = 7;
        public static final int Program3c7       = 8;
        public static final int Other            = 99;

        private CPProgramValues() {
        }

    }

    /**
     * Values for MiscFeeBasis(891).
     */
    public static class MiscFeeBasisValues {

        public static final int Absolute   = 0;
        public static final int PerUnit    = 1;
        public static final int Percentage = 2;

        private MiscFeeBasisValues() {
        }

    }

    /**
     * Values for CollAsgnReason(895).
     */
    public static class CollAsgnReasonValues {

        public static final int Initial                 = 0;
        public static final int Scheduled               = 1;
        public static final int TimeWarning             = 2;
        public static final int MarginDeficiency        = 3;
        public static final int MarginExcess            = 4;
        public static final int ForwardCollateralDemand = 5;
        public static final int EventOfDefault          = 6;
        public static final int AdverseTaxEvent         = 7;
        public static final int TransferDeposit         = 8;
        public static final int TransferWithdrawal      = 9;
        public static final int Pledge                  = 10;

        private CollAsgnReasonValues() {
        }

    }

    /**
     * Values for CollInquiryQualifier(896).
     */
    public static class CollInquiryQualifierValues {

        public static final int TradeDate            = 0;
        public static final int GCInstrument         = 1;
        public static final int CollateralInstrument = 2;
        public static final int SubstitutionEligible = 3;
        public static final int NotAssigned          = 4;
        public static final int PartiallyAssigned    = 5;
        public static final int FullyAssigned        = 6;
        public static final int OutstandingTrades    = 7;

        private CollInquiryQualifierValues() {
        }

    }

    /**
     * Values for CollAsgnTransType(903).
     */
    public static class CollAsgnTransTypeValues {

        public static final int New     = 0;
        public static final int Replace = 1;
        public static final int Cancel  = 2;
        public static final int Release = 3;
        public static final int Reverse = 4;

        private CollAsgnTransTypeValues() {
        }

    }

    /**
     * Values for CollAsgnRespType(905).
     */
    public static class CollAsgnRespTypeValues {

        public static final int Received                        = 0;
        public static final int Accepted                        = 1;
        public static final int Declined                        = 2;
        public static final int Rejected                        = 3;
        public static final int TransactionPending              = 4;
        public static final int TransactionCompletedWithWarning = 5;

        private CollAsgnRespTypeValues() {
        }

    }

    /**
     * Values for CollAsgnRejectReason(906).
     */
    public static class CollAsgnRejectReasonValues {

        public static final int UnknownDeal                = 0;
        public static final int UnknownOrInvalidInstrument = 1;
        public static final int UnauthorizedTransaction    = 2;
        public static final int InsufficientCollateral     = 3;
        public static final int InvalidTypeOfCollateral    = 4;
        public static final int ExcessiveSubstitution      = 5;
        public static final int Other                      = 99;

        private CollAsgnRejectReasonValues() {
        }

    }

    /**
     * Values for CollStatus(910).
     */
    public static class CollStatusValues {

        public static final int Unassigned         = 0;
        public static final int PartiallyAssigned  = 1;
        public static final int AssignmentProposed = 2;
        public static final int Assigned           = 3;
        public static final int Challenged         = 4;
        public static final int Reused             = 5;

        private CollStatusValues() {
        }

    }

    /**
     * Values for DeliveryType(919).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDeliveryType(2504)</li>
     * </ul>
     */
    public static class DeliveryTypeValues {

        public static final int VersusPayment  = 0;
        public static final int Free           = 1;
        public static final int TriParty       = 2;
        public static final int HoldInCustody  = 3;
        public static final int DeliverByValue = 4;

        private DeliveryTypeValues() {
        }

    }

    /**
     * Values for UserRequestType(924).
     */
    public static class UserRequestTypeValues {

        public static final int LogOnUser                   = 1;
        public static final int LogOffUser                  = 2;
        public static final int ChangePasswordForUser       = 3;
        public static final int RequestIndividualUserStatus = 4;
        public static final int RequestThrottleLimit        = 5;

        private UserRequestTypeValues() {
        }

    }

    /**
     * Values for UserStatus(926).
     */
    public static class UserStatusValues {

        public static final int LoggedIn                   = 1;
        public static final int NotLoggedIn                = 2;
        public static final int UserNotRecognised          = 3;
        public static final int PasswordIncorrect          = 4;
        public static final int PasswordChanged            = 5;
        public static final int Other                      = 6;
        public static final int ForcedUserLogoutByExchange = 7;
        public static final int SessionShutdownWarning     = 8;
        public static final int ThrottleParametersChanged  = 9;

        private UserStatusValues() {
        }

    }

    /**
     * Values for StatusValue(928).
     */
    public static class StatusValueValues {

        public static final int Connected              = 1;
        public static final int NotConnectedUnexpected = 2;
        public static final int NotConnectedExpected   = 3;
        public static final int InProcess              = 4;

        private StatusValueValues() {
        }

    }

    /**
     * Values for NetworkRequestType(935).
     */
    public static class NetworkRequestTypeValues {

        public static final int Snapshot        = 1;
        public static final int Subscribe       = 2;
        public static final int StopSubscribing = 4;
        public static final int LevelOfDetail   = 8;

        private NetworkRequestTypeValues() {
        }

    }

    /**
     * Values for NetworkStatusResponseType(937).
     */
    public static class NetworkStatusResponseTypeValues {

        public static final int Full              = 1;
        public static final int IncrementalUpdate = 2;

        private NetworkStatusResponseTypeValues() {
        }

    }

    /**
     * Values for TrdRptStatus(939).
     */
    public static class TrdRptStatusValues {

        public static final int Accepted            = 0;
        public static final int Rejected            = 1;
        public static final int Cancelled           = 2;
        public static final int AcceptedWithErrors  = 3;
        public static final int PendingNew          = 4;
        public static final int PendingCancel       = 5;
        public static final int PendingReplace      = 6;
        public static final int Terminated          = 7;
        public static final int PendingVerification = 8;
        public static final int DeemedVerified      = 9;
        public static final int Verified            = 10;
        public static final int Disputed            = 11;

        private TrdRptStatusValues() {
        }

    }

    /**
     * Values for AffirmStatus(940).
     */
    public static class AffirmStatusValues {

        public static final int Received        = 1;
        public static final int ConfirmRejected = 2;
        public static final int Affirmed        = 3;

        private AffirmStatusValues() {
        }

    }

    /**
     * Values for CollAction(944).
     */
    public static class CollActionValues {

        public static final int Retain = 0;
        public static final int Add    = 1;
        public static final int Remove = 2;

        private CollActionValues() {
        }

    }

    /**
     * Values for CollInquiryStatus(945).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>MarginReqmtInqStatus(1640)</li>
     * </ul>
     */
    public static class CollInquiryStatusValues {

        public static final int Accepted              = 0;
        public static final int AcceptedWithWarnings  = 1;
        public static final int Completed             = 2;
        public static final int CompletedWithWarnings = 3;
        public static final int Rejected              = 4;

        private CollInquiryStatusValues() {
        }

    }

    /**
     * Values for CollInquiryResult(946).
     */
    public static class CollInquiryResultValues {

        public static final int Successful                            = 0;
        public static final int InvalidOrUnknownInstrument            = 1;
        public static final int InvalidOrUnknownCollateralType        = 2;
        public static final int InvalidParties                        = 3;
        public static final int InvalidTransportTypeRequested         = 4;
        public static final int InvalidDestinationRequested           = 5;
        public static final int NoCollateralFoundForTheTradeSpecified = 6;
        public static final int NoCollateralFoundForTheOrderSpecified = 7;
        public static final int CollateralInquiryTypeNotSupported     = 8;
        public static final int UnauthorizedForCollateralInquiry      = 9;
        public static final int Other                                 = 99;

        private CollInquiryResultValues() {
        }

    }

    /**
     * Values for StrategyParameterType(959).
     */
    public static class StrategyParameterTypeValues {

        public static final int Int                 = 1;
        public static final int Length              = 2;
        public static final int NumInGroup          = 3;
        public static final int SeqNum              = 4;
        public static final int TagNum              = 5;
        public static final int Float               = 6;
        public static final int Qty                 = 7;
        public static final int Price               = 8;
        public static final int PriceOffset         = 9;
        public static final int Amt                 = 10;
        public static final int Percentage          = 11;
        public static final int Char                = 12;
        public static final int Boolean             = 13;
        public static final int String              = 14;
        public static final int MultipleCharValue   = 15;
        public static final int Currency            = 16;
        public static final int Exchange            = 17;
        public static final int MonthYear           = 18;
        public static final int UTCTimestamp        = 19;
        public static final int UTCTimeOnly         = 20;
        public static final int LocalMktDate        = 21;
        public static final int UTCDateOnly         = 22;
        public static final int Data                = 23;
        public static final int MultipleStringValue = 24;
        public static final int Country             = 25;
        public static final int Language            = 26;
        public static final int TZTimeOnly          = 27;
        public static final int TZTimestamp         = 28;
        public static final int Tenor               = 29;

        private StrategyParameterTypeValues() {
        }

    }

    /**
     * Values for SecurityStatus(965).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DerivativeSecurityStatus(1256)</li>
     *   <li>UnderlyingSecurityStatus(2011)</li>
     *   <li>LegSecurityStatus(2148)</li>
     * </ul>
     */
    public static class SecurityStatusValues {

        public static final String Active                  = "1";
        public static final String Inactive                = "2";
        public static final String ActiveClosingOrdersOnly = "3";
        public static final String Expired                 = "4";
        public static final String Delisted                = "5";
        public static final String KnockedOut              = "6";
        public static final String KnockOutRevoked         = "7";
        public static final String PendingExpiry           = "8";
        public static final String Suspended               = "9";
        public static final String Published               = "10";
        public static final String PendingDeletion         = "11";

        private SecurityStatusValues() {
        }

    }

    /**
     * Values for UnderlyingCashType(974).
     */
    public static class UnderlyingCashTypeValues {

        public static final String FIXED = "FIXED";
        public static final String DIFF  = "DIFF";

        private UnderlyingCashTypeValues() {
        }

    }

    /**
     * Values for UnderlyingSettlementType(975).
     */
    public static class UnderlyingSettlementTypeValues {

        public static final int TPlus1 = 2;
        public static final int TPlus3 = 4;
        public static final int TPlus4 = 5;

        private UnderlyingSettlementTypeValues() {
        }

    }

    /**
     * Values for SecurityUpdateAction(980).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>TradSesUpdateAction(1327)</li>
     *   <li>MarketUpdateAction(1395)</li>
     * </ul>
     */
    public static class SecurityUpdateActionValues {

        public static final char Add    = 'A';
        public static final char Delete = 'D';
        public static final char Modify = 'M';

        private SecurityUpdateActionValues() {
        }

    }

    /**
     * Values for ExpirationQtyType(982).
     */
    public static class ExpirationQtyTypeValues {

        public static final int AutoExercise         = 1;
        public static final int NonAutoExercise      = 2;
        public static final int FinalWillBeExercised = 3;
        public static final int ContraryIntention    = 4;
        public static final int Difference           = 5;

        private ExpirationQtyTypeValues() {
        }

    }

    /**
     * Values for IndividualAllocType(992).
     */
    public static class IndividualAllocTypeValues {

        public static final int SubAllocate          = 1;
        public static final int ThirdPartyAllocation = 2;

        private IndividualAllocTypeValues() {
        }

    }

    /**
     * Values for UnitOfMeasure(996).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingUnitOfMeasure(998)</li>
     *   <li>LegUnitOfMeasure(999)</li>
     *   <li>PriceUnitOfMeasure(1191)</li>
     *   <li>CommUnitOfMeasure(1238)</li>
     *   <li>DerivativeUnitOfMeasure(1269)</li>
     *   <li>DerivativePriceUnitOfMeasure(1315)</li>
     *   <li>LegPriceUnitOfMeasure(1421)</li>
     *   <li>UnderlyingPriceUnitOfMeasure(1424)</li>
     *   <li>StrikeUnitOfMeasure(1698)</li>
     *   <li>PosQtyUnitOfMeasure(1836)</li>
     *   <li>SettlPriceUnitOfMeasure(1886)</li>
     *   <li>LegStrikeUnitOfMeasure(2183)</li>
     *   <li>UnderlyingStrikeUnitOfMeasure(2290)</li>
     *   <li>CommissionUnitOfMeasure(2644)</li>
     *   <li>AllocCommissionUnitOfMeasure(2658)</li>
     *   <li>DeliveryScheduleNotionalUnitOfMeasure(41041)</li>
     *   <li>DeliveryScheduleToleranceUnitOfMeasure(41045)</li>
     *   <li>DeliveryStreamToleranceUnitOfMeasure(41073)</li>
     *   <li>PaymentUnitOfMeasure(41155)</li>
     *   <li>PaymentScheduleRateUnitOfMeasure(41167)</li>
     *   <li>PaymentScheduleSettlPeriodPriceUnitOfMeasure(41172)</li>
     *   <li>PaymentScheduleStepUnitOfMeasure(41173)</li>
     *   <li>PaymentStreamFixedAmountUnitOfMeasure(41187)</li>
     *   <li>PaymentStreamRateIndexUnitOfMeasure(41198)</li>
     *   <li>PaymentStreamReferenceLevelUnitOfMeasure(41201)</li>
     *   <li>PaymentStreamRateSpreadUnitOfMeasure(41204)</li>
     *   <li>StreamCommodityUnitOfMeasure(41258)</li>
     *   <li>StreamCommoditySettlPeriodNotionalUnitOfMeasure(41294)</li>
     *   <li>StreamCommoditySettlPeriodPriceUnitOfMeasure(41298)</li>
     *   <li>StreamNotionalUnitOfMeasure(41309)</li>
     *   <li>StreamTotalNotionalUnitOfMeasure(41311)</li>
     *   <li>LegDeliveryScheduleNotionalUnitOfMeasure(41412)</li>
     *   <li>LegDeliveryScheduleToleranceUnitOfMeasure(41416)</li>
     *   <li>LegDeliveryStreamToleranceUnitOfMeasure(41444)</li>
     *   <li>LegPaymentScheduleRateUnitOfMeasure(41536)</li>
     *   <li>LegPaymentScheduleSettlPeriodPriceUnitOfMeasure(41541)</li>
     *   <li>LegPaymentScheduleStepUnitOfMeasure(41542)</li>
     *   <li>LegPaymentStreamFixedAmountUnitOfMeasure(41556)</li>
     *   <li>LegPaymentStreamRateIndexUnitOfMeasure(41567)</li>
     *   <li>LegPaymentStreamReferenceLevelUnitOfMeasure(41570)</li>
     *   <li>LegPaymentStreamRateSpreadUnitOfMeasure(41573)</li>
     *   <li>LegStreamCommodityUnitOfMeasure(41655)</li>
     *   <li>LegStreamCommoditySettlPeriodNotionalUnitOfMeasure(41691)</li>
     *   <li>LegStreamCommoditySettlPeriodPriceUnitOfMeasure(41695)</li>
     *   <li>LegStreamNotionalUnitOfMeasure(41706)</li>
     *   <li>LegStreamTotalNotionalUnitOfMeasure(41708)</li>
     *   <li>UnderlyingDeliveryScheduleNotionalUnitOfMeasure(41760)</li>
     *   <li>UnderlyingDeliveryScheduleToleranceUnitOfMeasure(41764)</li>
     *   <li>UnderlyingDeliveryStreamToleranceUnitOfMeasure(41792)</li>
     *   <li>UnderlyingPaymentScheduleRateUnitOfMeasure(41884)</li>
     *   <li>UnderlyingPaymentScheduleSettlPeriodPriceUnitOfMeasure(41889)</li>
     *   <li>UnderlyingPaymentScheduleStepUnitOfMeasure(41890)</li>
     *   <li>UnderlyingPaymentStreamFixedAmountUnitOfMeasure(41904)</li>
     *   <li>UnderlyingPaymentStreamRateIndexUnitOfMeasure(41915)</li>
     *   <li>UnderlyingPaymentStreamReferenceLevelUnitOfMeasure(41918)</li>
     *   <li>UnderlyingPaymentStreamRateSpreadUnitOfMeasure(41921)</li>
     *   <li>UnderlyingStreamCommodityUnitOfMeasure(41971)</li>
     *   <li>UnderlyingStreamCommoditySettlPeriodNotionalUnitOfMeasure(42007)</li>
     *   <li>UnderlyingStreamCommoditySettlPeriodPriceUnitOfMeasure(42011)</li>
     *   <li>UnderlyingStreamNotionalUnitOfMeasure(42022)</li>
     *   <li>UnderlyingStreamTotalNotionalUnitOfMeasure(42024)</li>
     * </ul>
     */
    public static class UnitOfMeasureValues {

        public static final String BillionCubicFeet                      = "Bcf";
        public static final String Allowances                            = "Alw";
        public static final String CubicMeters                           = "CBM";
        public static final String Barrels                               = "Bbl";
        public static final String Gigajoules                            = "GJ";
        public static final String BoardFeet                             = "BDFT";
        public static final String HeatRate                              = "kHR";
        public static final String Bushels                               = "Bu";
        public static final String KilowattHours                         = "kWh";
        public static final String Currency                              = "Ccy";
        public static final String MegaHeatRate                          = "MHR";
        public static final String CoolingDegreeDay                      = "CDD";
        public static final String OneMillionBTU                         = "MMBtu";
        public static final String CertifiedEmissionsReduction           = "CER";
        public static final String MegawattHours                         = "MWh";
        public static final String CriticalPrecipDay                     = "CPD";
        public static final String Therms                                = "thm";
        public static final String ClimateReserveTonnes                  = "CRT";
        public static final String TonsOfCarbonDioxide                   = "tnCO2";
        public static final String Hundredweight                         = "cwt";
        public static final String Day                                   = "day";
        public static final String DryMetricTons                         = "dt";
        public static final String EnvAllwncCert                         = "EnvAllwnc";
        public static final String EnvironmentalCredit                   = "EnvCrd";
        public static final String EnvironmentalOffset                   = "EnvOfst";
        public static final String Grams                                 = "g";
        public static final String Gallons                               = "Gal";
        public static final String GrossTons                             = "GT";
        public static final String HeatingDegreeDay                      = "HDD";
        public static final String IndexPoint                            = "IPNT";
        public static final String Kilograms                             = "kg";
        public static final String Kiloliters                            = "kL";
        public static final String KilowattYear                          = "kW-a";
        public static final String KilowattDay                           = "kW-d";
        public static final String KilowattHour                          = "kW-h";
        public static final String KilowattMonth                         = "kW-M";
        public static final String KilowattMinute                        = "kW-min";
        public static final String Liters                                = "L";
        public static final String Pounds                                = "lbs";
        public static final String MegawattYear                          = "MW-a";
        public static final String MegawattDay                           = "MW-d";
        public static final String MegawattHour                          = "MW-h";
        public static final String MegawattMonth                         = "MW-M";
        public static final String MegawattMinute                        = "MW-min";
        public static final String TroyOunces                            = "oz_tr";
        public static final String PrincipalWithRelationToDebtInstrument = "PRINC";
        public static final String MetricTons                            = "t";
        public static final String Tons                                  = "tn";
        public static final String Are                                   = "a";
        public static final String Acre                                  = "ac";
        public static final String Centiliter                            = "cL";
        public static final String Centimeter                            = "cM";
        public static final String DieselGallonEquivalent                = "DGE";
        public static final String Foot                                  = "ft";
        public static final String GBGallon                              = "Gal_gb";
        public static final String GasolineGallonEquivalent              = "GGE";
        public static final String Hectare                               = "ha";
        public static final String Inch                                  = "in";
        public static final String Kilometer                             = "kM";
        public static final String Meter                                 = "M";
        public static final String Mile                                  = "mi";
        public static final String Milliliter                            = "mL";
        public static final String Millimeter                            = "mM";
        public static final String USOunce                               = "oz";
        public static final String Piece                                 = "pc";
        public static final String USPint                                = "pt";
        public static final String GBPint                                = "pt_gb";
        public static final String USQuart                               = "qt";
        public static final String GBQuart                               = "qt_gb";
        public static final String SquareCentimeter                      = "SqcM";
        public static final String SquareFoot                            = "Sqft";
        public static final String SquareInch                            = "Sqin";
        public static final String SquareKilometer                       = "SqkM";
        public static final String SquareMeter                           = "SqM";
        public static final String SquareMile                            = "Sqmi";
        public static final String SquareMillimeter                      = "SqmM";
        public static final String SquareYard                            = "Sqyd";
        public static final String Yard                                  = "yd";
        public static final String MillionBarrels                        = "MMbbl";
        public static final String USDollars                             = "USD";

        private UnitOfMeasureValues() {
        }

    }

    /**
     * Values for TimeUnit(997).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingTimeUnit(1000)</li>
     *   <li>LegTimeUnit(1001)</li>
     *   <li>DerivativeTimeUnit(1271)</li>
     *   <li>RiskLimitVelocityUnit(2337)</li>
     *   <li>MDStatisticIntervalTypeUnit(2465)</li>
     *   <li>StreamNotionalFrequencyUnit(41307)</li>
     *   <li>LegStreamNotionalFrequencyUnit(41704)</li>
     *   <li>UnderlyingStreamNotionalFrequencyUnit(42020)</li>
     * </ul>
     */
    public static class TimeUnitValues {

        public static final String Hour    = "H";
        public static final String Minute  = "Min";
        public static final String Second  = "S";
        public static final String Day     = "D";
        public static final String Week    = "Wk";
        public static final String Month   = "Mo";
        public static final String Year    = "Yr";
        public static final String Quarter = "Q";

        private TimeUnitValues() {
        }

    }

    /**
     * Values for AllocMethod(1002).
     */
    public static class AllocMethodValues {

        public static final int Automatic      = 1;
        public static final int Guarantor      = 2;
        public static final int Manual         = 3;
        public static final int BrokerAssigned = 4;

        private AllocMethodValues() {
        }

    }

    /**
     * Values for AsOfIndicator(1015).
     */
    public static class AsOfIndicatorValues {

        public static final char False = '0';
        public static final char True  = '1';

        private AsOfIndicatorValues() {
        }

    }

    /**
     * Values for MDBookType(1021).
     */
    public static class MDBookTypeValues {

        public static final int TopOfBook  = 1;
        public static final int PriceDepth = 2;
        public static final int OrderDepth = 3;

        private MDBookTypeValues() {
        }

    }

    /**
     * Values for MDOriginType(1024).
     */
    public static class MDOriginTypeValues {

        public static final int Book                = 0;
        public static final int OffBook             = 1;
        public static final int Cross               = 2;
        public static final int QuoteDrivenMarket   = 3;
        public static final int DarkOrderBook       = 4;
        public static final int AuctionDrivenMarket = 5;
        public static final int QuoteNegotiation    = 6;
        public static final int VoiceNegotiation    = 7;
        public static final int HybridMarket        = 8;

        private MDOriginTypeValues() {
        }

    }

    /**
     * Values for CustOrderHandlingInst(1031).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DeskOrderHandlingInst(1035)</li>
     * </ul>
     */
    public static class CustOrderHandlingInstValues {

        public static final String PhoneSimple                            = "A";
        public static final String GOrderAndFCMAPIorFIX                   = "G";
        public static final String PhoneComplex                           = "B";
        public static final String AddOnOrder                             = "ADD";
        public static final String FCMProvidedScreen                      = "C";
        public static final String AllOrNone                              = "AON";
        public static final String OtherProvidedScreen                    = "D";
        public static final String ConditionalOrder                       = "CND";
        public static final String ClientProvidedPlatformControlledByFCM  = "E";
        public static final String CashNotHeld                            = "CNH";
        public static final String ClientProvidedPlatformDirectToExchange = "F";
        public static final String DeliveryInstructionsCash               = "CSH";
        public static final String DirectedOrder                          = "DIR";
        public static final String AlgoEngine                             = "H";
        public static final String DiscretionaryLimitOrder                = "DLO";
        public static final String PriceAtExecution                       = "J";
        public static final String ExchangeForPhysicalTransaction         = "E.W";
        public static final String DeskElectronic                         = "W";
        public static final String FillOrKill                             = "FOK";
        public static final String DeskPit                                = "X";
        public static final String ClientElectronic                       = "Y";
        public static final String IntraDayCross                          = "IDX";
        public static final String ClientPit                              = "Z";
        public static final String ImbalanceOnly                          = "IO";
        public static final String ImmediateOrCancel                      = "IOC";
        public static final String IntermarketSweepOrder                  = "ISO";
        public static final String LimitOnOpen                            = "LOO";
        public static final String LimitOnClose                           = "LOC";
        public static final String MarketAtOpen                           = "MAO";
        public static final String MarketAtClose                          = "MAC";
        public static final String MarketOnOpen                           = "MOO";
        public static final String MarketOnClose                          = "MOC";
        public static final String MergerRelatedTransferPosition          = "MPT";
        public static final String MinimumQuantity                        = "MQT";
        public static final String MarketToLimit                          = "MTL";
        public static final String DeliveryInstructionsNextDay            = "ND";
        public static final String NotHeld                                = "NH";
        public static final String OptionsRelatedTransaction              = "OPT";
        public static final String OverTheDay                             = "OVD";
        public static final String Pegged                                 = "PEG";
        public static final String ReserveSizeOrder                       = "RSV";
        public static final String StopStockTransaction                   = "S.W";
        public static final String Scale                                  = "SCL";
        public static final String DeliveryInstructionsSellersOption      = "SLR";
        public static final String TimeOrder                              = "TMO";
        public static final String TrailingStop                           = "TS";
        public static final String Work                                   = "WRK";
        public static final String StayOnOfferside                        = "F0";
        public static final String GoAlong                                = "F3";
        public static final String ParticipateDoNotInitiate               = "F6";
        public static final String StrictScale                            = "F7";
        public static final String TryToScale                             = "F8";
        public static final String StayOnBidside                          = "F9";
        public static final String NoCross                                = "FA";
        public static final String OKToCross                              = "FB";
        public static final String CallFirst                              = "FC";
        public static final String PercentOfVolume                        = "FD";
        public static final String ReinstateOnSystemFailure               = "FH";
        public static final String InstitutionOnly                        = "FI";
        public static final String ReinstateOnTradingHalt                 = "FJ";
        public static final String CancelOnTradingHalf                    = "FK";
        public static final String LastPeg                                = "FL";
        public static final String MidPricePeg                            = "FM";
        public static final String NonNegotiable                          = "FN";
        public static final String OpeningPeg                             = "FO";
        public static final String MarketPeg                              = "FP";
        public static final String CancelOnSystemFailure                  = "FQ";
        public static final String PrimaryPeg                             = "FR";
        public static final String Suspend                                = "FS";
        public static final String FixedPegToLocalBBO                     = "FT";
        public static final String PegToVWAP                              = "FW";
        public static final String TradeAlong                             = "FX";
        public static final String TryToStop                              = "FY";
        public static final String CancelIfNotBest                        = "FZ";
        public static final String StrictLimit                            = "Fb";
        public static final String IgnorePriceValidityChecks              = "Fc";
        public static final String PegToLimitPrice                        = "Fd";
        public static final String WorkToTargetStrategy                   = "Fe";

        private CustOrderHandlingInstValues() {
        }

    }

    /**
     * Values for OrderHandlingInstSource(1032).
     */
    public static class OrderHandlingInstSourceValues {

        public static final int FINRAOATS              = 1;
        public static final int FIAExecutionSourceCode = 2;

        private OrderHandlingInstSourceValues() {
        }

    }

    /**
     * Values for DeskType(1033).
     */
    public static class DeskTypeValues {

        public static final String Agency               = "A";
        public static final String Arbitrage            = "AR";
        public static final String BlockTrading         = "B";
        public static final String ConvertibleDesk      = "C";
        public static final String CentralRiskBooks     = "CR";
        public static final String Derivatives          = "D";
        public static final String EquityCapitalMarkets = "EC";
        public static final String International        = "IN";
        public static final String Institutional        = "IS";
        public static final String Other                = "O";
        public static final String PreferredTrading     = "PF";
        public static final String Proprietary          = "PR";
        public static final String ProgramTrading       = "PT";
        public static final String Sales                = "S";
        public static final String Swaps                = "SW";
        public static final String TradingDeskSystem    = "T";
        public static final String Treasury             = "TR";
        public static final String FloorBroker          = "FB";

        private DeskTypeValues() {
        }

    }

    /**
     * Values for DeskTypeSource(1034).
     */
    public static class DeskTypeSourceValues {

        public static final int FINRAOATS = 1;

        private DeskTypeSourceValues() {
        }

    }

    /**
     * Values for ExecAckStatus(1036).
     */
    public static class ExecAckStatusValues {

        public static final char Received = '0';
        public static final char Accepted = '1';
        public static final char DontKnow = '2';

        private ExecAckStatusValues() {
        }

    }

    /**
     * Values for CollApplType(1043).
     */
    public static class CollApplTypeValues {

        public static final int SpecificDeposit = 0;
        public static final int General         = 1;

        private CollApplTypeValues() {
        }

    }

    /**
     * Values for UnderlyingFXRateCalc(1046).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>MarginAmtFXRateCalc(2089)</li>
     *   <li>CollateralFXRateCalc(2091)</li>
     *   <li>PayCollectFXRateCalc(2095)</li>
     *   <li>PositionFXRateCalc(2098)</li>
     *   <li>SideCollateralFXRateCalc(2697)</li>
     * </ul>
     */
    public static class UnderlyingFXRateCalcValues {

        public static final char Divide   = 'D';
        public static final char Multiply = 'M';

        private UnderlyingFXRateCalcValues() {
        }

    }

    /**
     * Values for AllocPositionEffect(1047).
     */
    public static class AllocPositionEffectValues {

        public static final char Open   = 'O';
        public static final char Close  = 'C';
        public static final char Rolled = 'R';
        public static final char FIFO   = 'F';

        private AllocPositionEffectValues() {
        }

    }

    /**
     * Values for DealingCapacity(1048).
     */
    public static class DealingCapacityValues {

        public static final char Agent             = 'A';
        public static final char Principal         = 'P';
        public static final char RisklessPrincipal = 'R';

        private DealingCapacityValues() {
        }

    }

    /**
     * Values for InstrmtAssignmentMethod(1049).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DerivativeInstrmtAssignmentMethod(1255)</li>
     *   <li>UnderlyingAssignmentMethod(2010)</li>
     *   <li>LegInstrmtAssignmentMethod(2147)</li>
     * </ul>
     */
    public static class InstrmtAssignmentMethodValues {

        public static final char ProRata = 'P';
        public static final char Random  = 'R';

        private InstrmtAssignmentMethodValues() {
        }

    }

    /**
     * Values for MDQuoteType(1070).
     */
    public static class MDQuoteTypeValues {

        public static final int Indicative             = 0;
        public static final int Tradeable              = 1;
        public static final int RestrictedTradeable    = 2;
        public static final int Counter                = 3;
        public static final int IndicativeAndTradeable = 4;

        private MDQuoteTypeValues() {
        }

    }

    /**
     * Values for RefOrderIDSource(1081).
     */
    public static class RefOrderIDSourceValues {

        public static final char SecondaryOrderID        = '0';
        public static final char OrderID                 = '1';
        public static final char MDEntryID               = '2';
        public static final char QuoteEntryID            = '3';
        public static final char OriginalOrderID         = '4';
        public static final char QuoteID                 = '5';
        public static final char QuoteReqID              = '6';
        public static final char PreviousOrderIdentifier = '7';
        public static final char PreviousQuoteIdentifier = '8';
        public static final char ParentOrderIdentifier   = '9';
        public static final char ManualOrderIdentifier   = 'A';

        private RefOrderIDSourceValues() {
        }

    }

    /**
     * Values for DisplayWhen(1083).
     */
    public static class DisplayWhenValues {

        public static final char Immediate = '1';
        public static final char Exhaust   = '2';

        private DisplayWhenValues() {
        }

    }

    /**
     * Values for DisplayMethod(1084).
     */
    public static class DisplayMethodValues {

        public static final char Initial     = '1';
        public static final char New         = '2';
        public static final char Random      = '3';
        public static final char Undisclosed = '4';

        private DisplayMethodValues() {
        }

    }

    /**
     * Values for PriceProtectionScope(1092).
     */
    public static class PriceProtectionScopeValues {

        public static final char None     = '0';
        public static final char Local    = '1';
        public static final char National = '2';
        public static final char Global   = '3';

        private PriceProtectionScopeValues() {
        }

    }

    /**
     * Values for LotType(1093).
     */
    public static class LotTypeValues {

        public static final char OddLot            = '1';
        public static final char RoundLot          = '2';
        public static final char BlockLot          = '3';
        public static final char RoundLotBasedUpon = '4';

        private LotTypeValues() {
        }

    }

    /**
     * Values for PegPriceType(1094).
     */
    public static class PegPriceTypeValues {

        public static final int LastPeg              = 1;
        public static final int MidPricePeg          = 2;
        public static final int OpeningPeg           = 3;
        public static final int MarketPeg            = 4;
        public static final int PrimaryPeg           = 5;
        public static final int PegToVWAP            = 7;
        public static final int TrailingStopPeg      = 8;
        public static final int PegToLimitPrice      = 9;
        public static final int ShortSaleMinPricePeg = 10;

        private PegPriceTypeValues() {
        }

    }

    /**
     * Values for TriggerType(1100).
     */
    public static class TriggerTypeValues {

        public static final char PartialExecution           = '1';
        public static final char SpecifiedTradingSession    = '2';
        public static final char NextAuction                = '3';
        public static final char PriceMovement              = '4';
        public static final char OnOrderEntryOrModification = '5';

        private TriggerTypeValues() {
        }

    }

    /**
     * Values for TriggerAction(1101).
     */
    public static class TriggerActionValues {

        public static final char Activate = '1';
        public static final char Modify   = '2';
        public static final char Cancel   = '3';

        private TriggerActionValues() {
        }

    }

    /**
     * Values for TriggerPriceType(1107).
     */
    public static class TriggerPriceTypeValues {

        public static final char BestOffer            = '1';
        public static final char LastTrade            = '2';
        public static final char BestBid              = '3';
        public static final char BestBidOrLastTrade   = '4';
        public static final char BestOfferOrLastTrade = '5';
        public static final char BestMid              = '6';

        private TriggerPriceTypeValues() {
        }

    }

    /**
     * Values for TriggerPriceTypeScope(1108).
     */
    public static class TriggerPriceTypeScopeValues {

        public static final char None     = '0';
        public static final char Local    = '1';
        public static final char National = '2';
        public static final char Global   = '3';

        private TriggerPriceTypeScopeValues() {
        }

    }

    /**
     * Values for TriggerPriceDirection(1109).
     */
    public static class TriggerPriceDirectionValues {

        public static final char Up   = 'U';
        public static final char Down = 'D';

        private TriggerPriceDirectionValues() {
        }

    }

    /**
     * Values for TriggerOrderType(1111).
     */
    public static class TriggerOrderTypeValues {

        public static final char Market = '1';
        public static final char Limit  = '2';

        private TriggerOrderTypeValues() {
        }

    }

    /**
     * Values for OrderCategory(1115).
     */
    public static class OrderCategoryValues {

        public static final char Order                    = '1';
        public static final char Quote                    = '2';
        public static final char PrivatelyNegotiatedTrade = '3';
        public static final char MultilegOrder            = '4';
        public static final char LinkedOrder              = '5';
        public static final char QuoteRequest             = '6';
        public static final char ImpliedOrder             = '7';
        public static final char CrossOrder               = '8';
        public static final char StreamingPrice           = '9';
        public static final char InternalCrossOrder       = 'A';

        private OrderCategoryValues() {
        }

    }

    /**
     * Values for TradeHandlingInstr(1123).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>OrigTradeHandlingInstr(1124)</li>
     * </ul>
     */
    public static class TradeHandlingInstrValues {

        public static final char TradeConfirmation            = '0';
        public static final char TwoPartyReport               = '1';
        public static final char OnePartyReportForMatching    = '2';
        public static final char OnePartyReportForPassThrough = '3';
        public static final char AutomatedFloorOrderRouting   = '4';
        public static final char TwoPartyReportForClaim       = '5';
        public static final char OnePartyReport               = '6';
        public static final char ThirdPtyRptForPassThrough    = '7';
        public static final char OnePartyReportAutoMatch      = '8';

        private TradeHandlingInstrValues() {
        }

    }

    /**
     * Values for ApplVerID(1128).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>RefApplVerID(1130)</li>
     *   <li>DefaultApplVerID(1137)</li>
     * </ul>
     */
    public static class ApplVerIDValues {

        public static final String FIX27     = "0";
        public static final String FIX30     = "1";
        public static final String FIX40     = "2";
        public static final String FIX41     = "3";
        public static final String FIX42     = "4";
        public static final String FIX43     = "5";
        public static final String FIX44     = "6";
        public static final String FIX50     = "7";
        public static final String FIX50SP1  = "8";
        public static final String FIX50SP2  = "9";
        public static final String FIXLatest = "10";

        private ApplVerIDValues() {
        }

    }

    /**
     * Values for ExDestinationIDSource(1133).
     */
    public static class ExDestinationIDSourceValues {

        public static final char BIC               = 'B';
        public static final char GeneralIdentifier = 'C';
        public static final char Proprietary       = 'D';
        public static final char ISOCountryCode    = 'E';
        public static final char MIC               = 'G';

        private ExDestinationIDSourceValues() {
        }

    }

    /**
     * Values for ImpliedMarketIndicator(1144).
     */
    public static class ImpliedMarketIndicatorValues {

        public static final int NotImplied                 = 0;
        public static final int ImpliedIn                  = 1;
        public static final int ImpliedOut                 = 2;
        public static final int BothImpliedInAndImpliedOut = 3;

        private ImpliedMarketIndicatorValues() {
        }

    }

    /**
     * Values for SettlObligMode(1159).
     */
    public static class SettlObligModeValues {

        public static final int Preliminary = 1;
        public static final int Final       = 2;

        private SettlObligModeValues() {
        }

    }

    /**
     * Values for SettlObligTransType(1162).
     */
    public static class SettlObligTransTypeValues {

        public static final char Cancel  = 'C';
        public static final char New     = 'N';
        public static final char Replace = 'R';
        public static final char Restate = 'T';

        private SettlObligTransTypeValues() {
        }

    }

    /**
     * Values for SettlObligSource(1164).
     */
    public static class SettlObligSourceValues {

        public static final char InstructionsOfBroker          = '1';
        public static final char InstructionsForInstitution    = '2';
        public static final char Investor                      = '3';
        public static final char BuyersSettlementInstructions  = '4';
        public static final char SellersSettlementInstructions = '5';

        private SettlObligSourceValues() {
        }

    }

    /**
     * Values for QuoteEntryStatus(1167).
     */
    public static class QuoteEntryStatusValues {

        public static final int Accepted                 = 0;
        public static final int Rejected                 = 5;
        public static final int RemovedFromMarket        = 6;
        public static final int Expired                  = 7;
        public static final int LockedMarketWarning      = 12;
        public static final int CrossMarketWarning       = 13;
        public static final int CanceledDueToLockMarket  = 14;
        public static final int CanceledDueToCrossMarket = 15;
        public static final int Active                   = 16;

        private QuoteEntryStatusValues() {
        }

    }

    /**
     * Values for RespondentType(1172).
     */
    public static class RespondentTypeValues {

        public static final int AllMarketParticipants       = 1;
        public static final int SpecifiedMarketParticipants = 2;
        public static final int AllMarketMakers             = 3;
        public static final int PrimaryMarketMaker          = 4;

        private RespondentTypeValues() {
        }

    }

    /**
     * Values for SecurityTradingEvent(1174).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SecurityMassTradingEvent(1680)</li>
     * </ul>
     */
    public static class SecurityTradingEventValues {

        public static final int OrderImbalance                = 1;
        public static final int TradingResumes                = 2;
        public static final int PriceVolatilityInterruption   = 3;
        public static final int ChangeOfTradingSession        = 4;
        public static final int ChangeOfTradingSubsession     = 5;
        public static final int ChangeOfSecurityTradingStatus = 6;
        public static final int ChangeOfBookType              = 7;
        public static final int ChangeOfMarketDepth           = 8;
        public static final int CorporateAction               = 9;

        private SecurityTradingEventValues() {
        }

    }

    /**
     * Values for StatsType(1176).
     */
    public static class StatsTypeValues {

        public static final int ExchangeLast = 1;
        public static final int High         = 2;
        public static final int AveragePrice = 3;
        public static final int Turnover     = 4;

        private StatsTypeValues() {
        }

    }

    /**
     * Values for MDSecSizeType(1178).
     */
    public static class MDSecSizeTypeValues {

        public static final int Customer             = 1;
        public static final int CustomerProfessional = 2;
        public static final int DoNotTradeThrough    = 3;

        private MDSecSizeTypeValues() {
        }

    }

    /**
     * Values for SettlMethod(1193).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingSettlMethod(1039)</li>
     *   <li>DerivativeSettlMethod(1317)</li>
     *   <li>LegSettlMethod(2192)</li>
     * </ul>
     */
    public static class SettlMethodValues {

        public static final String CashSettlementRequired     = "C";
        public static final String PhysicalSettlementRequired = "P";
        public static final String Election                   = "E";

        private SettlMethodValues() {
        }

    }

    /**
     * Values for ExerciseStyle(1194).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DerivativeExerciseStyle(1299)</li>
     *   <li>StrikeExerciseStyle(1304)</li>
     *   <li>UnderlyingExerciseStyle(1419)</li>
     *   <li>LegExerciseStyle(1420)</li>
     *   <li>ProvisionOptionExerciseStyle(40101)</li>
     *   <li>LegProvisionOptionExerciseStyle(40459)</li>
     *   <li>UnderlyingProvisionOptionExerciseStyle(42159)</li>
     * </ul>
     */
    public static class ExerciseStyleValues {

        public static final int European = 0;
        public static final int American = 1;
        public static final int Bermuda  = 2;
        public static final int Other    = 99;

        private ExerciseStyleValues() {
        }

    }

    /**
     * Values for PriceQuoteMethod(1196).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DerivativePriceQuoteMethod(1318)</li>
     *   <li>UnderlyingPriceQuoteMethod(2030)</li>
     *   <li>LegPriceQuoteMethod(2195)</li>
     * </ul>
     */
    public static class PriceQuoteMethodValues {

        public static final String Standard          = "STD";
        public static final String Index             = "INX";
        public static final String InterestRateIndex = "INT";
        public static final String PercentOfPar      = "PCTPAR";

        private PriceQuoteMethodValues() {
        }

    }

    /**
     * Values for ValuationMethod(1197).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DerivativeValuationMethod(1319)</li>
     *   <li>UnderlyingValuationMethod(2031)</li>
     *   <li>LegValuationMethod(2196)</li>
     * </ul>
     */
    public static class ValuationMethodValues {

        public static final String PremiumStyle                             = "EQTY";
        public static final String FuturesStyleMarkToMarket                 = "FUT";
        public static final String FuturesStyleWithAnAttachedCashAdjustment = "FUTDA";
        public static final String CDSStyleCollateralization                = "CDS";
        public static final String CDSInDeliveryUseRecoveryRateToCalculate  = "CDSD";

        private ValuationMethodValues() {
        }

    }

    /**
     * Values for ListMethod(1198).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DerivativeListMethod(1320)</li>
     *   <li>UnderlyingListMethod(2032)</li>
     *   <li>LegListMethod(2199)</li>
     * </ul>
     */
    public static class ListMethodValues {

        public static final int PreListedOnly = 0;
        public static final int UserRequested = 1;

        private ListMethodValues() {
        }

    }

    /**
     * Values for TickRuleType(1209).
     */
    public static class TickRuleTypeValues {

        public static final int RegularTrading      = 0;
        public static final int VariableCabinet     = 1;
        public static final int FixedCabinet        = 2;
        public static final int TradedAsASpreadLeg  = 3;
        public static final int SettledAsASpreadLeg = 4;
        public static final int TradedAsSpread      = 5;

        private TickRuleTypeValues() {
        }

    }

    /**
     * Values for MaturityMonthYearIncrementUnits(1302).
     */
    public static class MaturityMonthYearIncrementUnitsValues {

        public static final int Months = 0;
        public static final int Days   = 1;
        public static final int Weeks  = 2;
        public static final int Years  = 3;

        private MaturityMonthYearIncrementUnitsValues() {
        }

    }

    /**
     * Values for MaturityMonthYearFormat(1303).
     */
    public static class MaturityMonthYearFormatValues {

        public static final int YearMonthOnly = 0;
        public static final int YearMonthDay  = 1;
        public static final int YearMonthWeek = 2;

        private MaturityMonthYearFormatValues() {
        }

    }

    /**
     * Values for PriceLimitType(1306).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SecondaryPriceLimitType(1305)</li>
     * </ul>
     */
    public static class PriceLimitTypeValues {

        public static final int Price      = 0;
        public static final int Ticks      = 1;
        public static final int Percentage = 2;

        private PriceLimitTypeValues() {
        }

    }

    /**
     * Values for ListUpdateAction(1324).
     */
    public static class ListUpdateActionValues {

        public static final char Add      = 'A';
        public static final char Delete   = 'D';
        public static final char Modify   = 'M';
        public static final char Snapshot = 'S';

        private ListUpdateActionValues() {
        }

    }

    /**
     * Values for ApplReqType(1347).
     */
    public static class ApplReqTypeValues {

        public static final int Retransmission                  = 0;
        public static final int Subscription                    = 1;
        public static final int RequestLastSeqNum               = 2;
        public static final int RequestApplications             = 3;
        public static final int Unsubscribe                     = 4;
        public static final int CancelRetransmission            = 5;
        public static final int CancelRetransmissionUnsubscribe = 6;

        private ApplReqTypeValues() {
        }

    }

    /**
     * Values for ApplResponseType(1348).
     */
    public static class ApplResponseTypeValues {

        public static final int RequestSuccessfullyProcessed = 0;
        public static final int ApplicationDoesNotExist      = 1;
        public static final int MessagesNotAvailable         = 2;

        private ApplResponseTypeValues() {
        }

    }

    /**
     * Values for ApplResponseError(1354).
     */
    public static class ApplResponseErrorValues {

        public static final int ApplicationDoesNotExist          = 0;
        public static final int MessagesRequestedAreNotAvailable = 1;
        public static final int UserNotAuthorizedForApplication  = 2;

        private ApplResponseErrorValues() {
        }

    }

    /**
     * Values for TradSesEvent(1368).
     */
    public static class TradSesEventValues {

        public static final int TradingResumes            = 0;
        public static final int ChangeOfTradingSession    = 1;
        public static final int ChangeOfTradingSubsession = 2;
        public static final int ChangeOfTradingStatus     = 3;

        private TradSesEventValues() {
        }

    }

    /**
     * Values for MassActionType(1373).
     */
    public static class MassActionTypeValues {

        public static final int SuspendOrders               = 1;
        public static final int ReleaseOrdersFromSuspension = 2;
        public static final int CancelOrders                = 3;

        private MassActionTypeValues() {
        }

    }

    /**
     * Values for MassActionScope(1374).
     */
    public static class MassActionScopeValues {

        public static final int AllOrdersForASecurity               = 1;
        public static final int AllOrdersForAnUnderlyingSecurity    = 2;
        public static final int AllOrdersForAProduct                = 3;
        public static final int AllOrdersForACFICode                = 4;
        public static final int AllOrdersForASecurityType           = 5;
        public static final int AllOrdersForATradingSession         = 6;
        public static final int AllOrders                           = 7;
        public static final int AllOrdersForAMarket                 = 8;
        public static final int AllOrdersForAMarketSegment          = 9;
        public static final int AllOrdersForASecurityGroup          = 10;
        public static final int CancelForSecurityIssuer             = 11;
        public static final int CancelForIssuerOfUnderlyingSecurity = 12;

        private MassActionScopeValues() {
        }

    }

    /**
     * Values for MassActionResponse(1375).
     */
    public static class MassActionResponseValues {

        public static final int Rejected  = 0;
        public static final int Accepted  = 1;
        public static final int Completed = 2;

        private MassActionResponseValues() {
        }

    }

    /**
     * Values for MassActionRejectReason(1376).
     */
    public static class MassActionRejectReasonValues {

        public static final int MassActionNotSupported                     = 0;
        public static final int InvalidOrUnknownSecurity                   = 1;
        public static final int InvalidOrUnknownUnderlyingSecurity         = 2;
        public static final int InvalidOrUnknownProduct                    = 3;
        public static final int InvalidOrUnknownCFICode                    = 4;
        public static final int InvalidOrUnknownSecurityType               = 5;
        public static final int InvalidOrUnknownTradingSession             = 6;
        public static final int InvalidOrUnknownMarket                     = 7;
        public static final int InvalidOrUnknownMarketSegment              = 8;
        public static final int InvalidOrUnknownSecurityGroup              = 9;
        public static final int InvalidOrUnknownSecurityIssuer             = 10;
        public static final int InvalidOrUnknownIssuerOfUnderlyingSecurity = 11;
        public static final int Other                                      = 99;

        private MassActionRejectReasonValues() {
        }

    }

    /**
     * Values for MultilegModel(1377).
     */
    public static class MultilegModelValues {

        public static final int PredefinedMultilegSecurity  = 0;
        public static final int UserDefinedMultilegSecurity = 1;
        public static final int UserDefined                 = 2;

        private MultilegModelValues() {
        }

    }

    /**
     * Values for MultilegPriceMethod(1378).
     */
    public static class MultilegPriceMethodValues {

        public static final int NetPrice                     = 0;
        public static final int ReversedNetPrice             = 1;
        public static final int YieldDifference              = 2;
        public static final int Individual                   = 3;
        public static final int ContractWeightedAveragePrice = 4;
        public static final int MultipliedPrice              = 5;

        private MultilegPriceMethodValues() {
        }

    }

    /**
     * Values for ContingencyType(1385).
     */
    public static class ContingencyTypeValues {

        public static final int OneCancelsTheOther             = 1;
        public static final int OneTriggersTheOther            = 2;
        public static final int OneUpdatesTheOtherAbsolute     = 3;
        public static final int OneUpdatesTheOtherProportional = 4;
        public static final int BidAndOffer                    = 5;
        public static final int BidAndOfferOCO                 = 6;

        private ContingencyTypeValues() {
        }

    }

    /**
     * Values for ListRejectReason(1386).
     */
    public static class ListRejectReasonValues {

        public static final int BrokerCredit                   = 0;
        public static final int ExchangeClosed                 = 2;
        public static final int TooLateToEnter                 = 4;
        public static final int UnknownOrder                   = 5;
        public static final int DuplicateOrder                 = 6;
        public static final int UnsupportedOrderCharacteristic = 11;
        public static final int Other                          = 99;

        private ListRejectReasonValues() {
        }

    }

    /**
     * Values for TradePublishIndicator(1390).
     */
    public static class TradePublishIndicatorValues {

        public static final int DoNotPublishTrade   = 0;
        public static final int PublishTrade        = 1;
        public static final int DeferredPublication = 2;
        public static final int Published           = 3;

        private TradePublishIndicatorValues() {
        }

    }

    /**
     * Values for SessionStatus(1409).
     */
    public static class SessionStatusValues {

        public static final int SessionActive                             = 0;
        public static final int SessionPasswordChanged                    = 1;
        public static final int SessionPasswordDueToExpire                = 2;
        public static final int NewSessionPasswordDoesNotComplyWithPolicy = 3;
        public static final int SessionLogoutComplete                     = 4;
        public static final int InvalidUsernameOrPassword                 = 5;
        public static final int AccountLocked                             = 6;
        public static final int LogonsAreNotAllowedAtThisTime             = 7;
        public static final int PasswordExpired                           = 8;
        public static final int ReceivedMsgSeqNumTooLow                   = 9;
        public static final int ReceivedNextExpectedMsgSeqNumTooHigh      = 10;

        private SessionStatusValues() {
        }

    }

    /**
     * Values for ApplReportType(1426).
     */
    public static class ApplReportTypeValues {

        public static final int ApplSeqNumReset  = 0;
        public static final int LastMessageSent  = 1;
        public static final int ApplicationAlive = 2;
        public static final int ResendComplete   = 3;

        private ApplReportTypeValues() {
        }

    }

    /**
     * Values for OrderDelayUnit(1429).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ThrottleTimeUnit(1615)</li>
     *   <li>ExposureDurationUnit(1916)</li>
     *   <li>MDStatisticFrequencyUnit(2461)</li>
     *   <li>MDStatisticDelayUnit(2463)</li>
     *   <li>MDStatisticIntervalUnit(2467)</li>
     *   <li>MDStatisticValueUnit(2480)</li>
     *   <li>MarketDepthTimeIntervalUnit(2564)</li>
     *   <li>MDRecoveryTimeIntervalUnit(2566)</li>
     * </ul>
     */
    public static class OrderDelayUnitValues {

        public static final int Seconds             = 0;
        public static final int TenthsOfASecond     = 1;
        public static final int HundredthsOfASecond = 2;
        public static final int Milliseconds        = 3;
        public static final int Microseconds        = 4;
        public static final int Nanoseconds         = 5;
        public static final int Minutes             = 10;
        public static final int Hours               = 11;
        public static final int Days                = 12;
        public static final int Weeks               = 13;
        public static final int Months              = 14;
        public static final int Years               = 15;

        private OrderDelayUnitValues() {
        }

    }

    /**
     * Values for VenueType(1430).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SideVenueType(1899)</li>
     * </ul>
     */
    public static class VenueTypeValues {

        public static final char Electronic            = 'E';
        public static final char Pit                   = 'P';
        public static final char ExPit                 = 'X';
        public static final char ClearingHouse         = 'C';
        public static final char RegisteredMarket      = 'R';
        public static final char OffMarket             = 'O';
        public static final char CentralLimitOrderBook = 'B';
        public static final char QuoteDrivenMarket     = 'Q';
        public static final char DarkOrderBook         = 'D';
        public static final char AuctionDrivenMarket   = 'A';
        public static final char QuoteNegotiation      = 'N';
        public static final char VoiceNegotiation      = 'V';
        public static final char HybridMarket          = 'H';

        private VenueTypeValues() {
        }

    }

    /**
     * Values for RefOrdIDReason(1431).
     */
    public static class RefOrdIDReasonValues {

        public static final int GTCFromPreviousDay   = 0;
        public static final int PartialFillRemaining = 1;
        public static final int OrderChanged         = 2;

        private RefOrdIDReasonValues() {
        }

    }

    /**
     * Values for OrigCustOrderCapacity(1432).
     */
    public static class OrigCustOrderCapacityValues {

        public static final int MemberTradingForTheirOwnAccount             = 1;
        public static final int ClearingFirmTradingForItsProprietaryAccount = 2;
        public static final int MemberTradingForAnotherMember               = 3;
        public static final int AllOther                                    = 4;

        private OrigCustOrderCapacityValues() {
        }

    }

    /**
     * Values for ModelType(1434).
     */
    public static class ModelTypeValues {

        public static final int UtilityProvidedStandardModel = 0;
        public static final int ProprietaryModel             = 1;

        private ModelTypeValues() {
        }

    }

    /**
     * Values for ContractMultiplierUnit(1435).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegContractMultiplierUnit(1436)</li>
     *   <li>UnderlyingContractMultiplierUnit(1437)</li>
     *   <li>DerivativeContractMultiplierUnit(1438)</li>
     * </ul>
     */
    public static class ContractMultiplierUnitValues {

        public static final int Shares = 0;
        public static final int Hours  = 1;
        public static final int Days   = 2;

        private ContractMultiplierUnitValues() {
        }

    }

    /**
     * Values for FlowScheduleType(1439).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegFlowScheduleType(1440)</li>
     *   <li>UnderlyingFlowScheduleType(1441)</li>
     *   <li>DerivativeFlowScheduleType(1442)</li>
     * </ul>
     */
    public static class FlowScheduleTypeValues {

        public static final int NERCEasternOffPeak         = 0;
        public static final int NERCWesternOffPeak         = 1;
        public static final int NERCCalendarAllDaysInMonth = 2;
        public static final int NERCEasternPeak            = 3;
        public static final int NERCWesternPeak            = 4;
        public static final int AllTimes                   = 5;
        public static final int OnPeak                     = 6;
        public static final int OffPeak                    = 7;
        public static final int Base                       = 8;
        public static final int Block                      = 9;
        public static final int Other                      = 99;

        private FlowScheduleTypeValues() {
        }

    }

    /**
     * Values for RateSource(1446).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamNonDeliverableSettlRateSource(40087)</li>
     *   <li>LegSettlRateFallbackRateSource(40366)</li>
     *   <li>PaymentStreamNonDeliverableSettlRateSource(40371)</li>
     *   <li>SettlRateFallbackRateSource(40373)</li>
     *   <li>LegPaymentScheduleRateSource(40415)</li>
     *   <li>UnderlyingPaymentStreamNonDeliverableSettlRateSource(40661)</li>
     *   <li>UnderlyingPaymentScheduleRateSource(40705)</li>
     *   <li>PaymentScheduleRateSource(40869)</li>
     *   <li>UnderlyingSettlRateFallbackRateSource(40904)</li>
     *   <li>ComplexEventRateSource(41014)</li>
     *   <li>LegComplexEventRateSource(41383)</li>
     *   <li>UnderlyingComplexEventRateSource(41733)</li>
     *   <li>LegReturnRateInformationSource(42561)</li>
     *   <li>ReturnRateInformationSource(42762)</li>
     *   <li>UnderlyingReturnRateInformationSource(43061)</li>
     * </ul>
     */
    public static class RateSourceValues {

        public static final int Bloomberg      = 0;
        public static final int Reuters        = 1;
        public static final int Telerate       = 2;
        public static final int ISDARateOption = 3;
        public static final int Other          = 99;

        private RateSourceValues() {
        }

    }

    /**
     * Values for RateSourceType(1447).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentScheduleRateSourceType(40416)</li>
     *   <li>UnderlyingPaymentScheduleRateSourceType(40706)</li>
     *   <li>PaymentScheduleRateSourceType(40870)</li>
     *   <li>ComplexEventRateSourceType(41015)</li>
     *   <li>LegComplexEventRateSourceType(41384)</li>
     *   <li>UnderlyingComplexEventRateSourceType(41734)</li>
     * </ul>
     */
    public static class RateSourceTypeValues {

        public static final int Primary   = 0;
        public static final int Secondary = 1;

        private RateSourceTypeValues() {
        }

    }

    /**
     * Values for RestructuringType(1449).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingRestructuringType(1453)</li>
     *   <li>LegRestructuringType(2149)</li>
     * </ul>
     */
    public static class RestructuringTypeValues {

        public static final String FullRestructuring        = "FR";
        public static final String ModifiedRestructuring    = "MR";
        public static final String ModifiedModRestructuring = "MM";
        public static final String NoRestructuringSpecified = "XR";

        private RestructuringTypeValues() {
        }

    }

    /**
     * Values for Seniority(1450).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingSeniority(1454)</li>
     *   <li>LegSeniority(2150)</li>
     *   <li>AdditionalTermBondSeniority(40010)</li>
     *   <li>LegAdditionalTermBondSeniority(41326)</li>
     *   <li>UnderlyingAdditionalTermBondSeniority(42027)</li>
     * </ul>
     */
    public static class SeniorityValues {

        public static final String SeniorSecured      = "SD";
        public static final String Senior             = "SR";
        public static final String Subordinated       = "SB";
        public static final String Junior             = "JR";
        public static final String Mezzanine          = "MZ";
        public static final String SeniorNonPreferred = "SN";

        private SeniorityValues() {
        }

    }

    /**
     * Values for SecurityListType(1470).
     */
    public static class SecurityListTypeValues {

        public static final int IndustryClassification = 1;
        public static final int TradingList            = 2;
        public static final int Market                 = 3;
        public static final int NewspaperList          = 4;

        private SecurityListTypeValues() {
        }

    }

    /**
     * Values for SecurityListTypeSource(1471).
     */
    public static class SecurityListTypeSourceValues {

        public static final int ICB   = 1;
        public static final int NAICS = 2;
        public static final int GICS  = 3;

        private SecurityListTypeSourceValues() {
        }

    }

    /**
     * Values for NewsCategory(1473).
     */
    public static class NewsCategoryValues {

        public static final int CompanyNews         = 0;
        public static final int MarketplaceNews     = 1;
        public static final int FinancialMarketNews = 2;
        public static final int TechnicalNews       = 3;
        public static final int OtherNews           = 99;

        private NewsCategoryValues() {
        }

    }

    /**
     * Values for NewsRefType(1477).
     */
    public static class NewsRefTypeValues {

        public static final int Replacement   = 0;
        public static final int OtherLanguage = 1;
        public static final int Complimentary = 2;
        public static final int Withdrawal    = 3;

        private NewsRefTypeValues() {
        }

    }

    /**
     * Values for StrikePriceDeterminationMethod(1478).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingStrikePriceDeterminationMethod(2023)</li>
     *   <li>LegStrikePriceDeterminationMethod(2186)</li>
     * </ul>
     */
    public static class StrikePriceDeterminationMethodValues {

        public static final int FixedStrike                  = 1;
        public static final int StrikeSetAtExpiration        = 2;
        public static final int StrikeSetToAverageAcrossLife = 3;
        public static final int StrikeSetToOptimalValue      = 4;

        private StrikePriceDeterminationMethodValues() {
        }

    }

    /**
     * Values for StrikePriceBoundaryMethod(1479).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingStrikePriceBoundaryMethod(2024)</li>
     *   <li>LegStrikePriceBoundaryMethod(2187)</li>
     * </ul>
     */
    public static class StrikePriceBoundaryMethodValues {

        public static final int LessThan           = 1;
        public static final int LessThanOrEqual    = 2;
        public static final int Equal              = 3;
        public static final int GreaterThanOrEqual = 4;
        public static final int GreaterThan        = 5;

        private StrikePriceBoundaryMethodValues() {
        }

    }

    /**
     * Values for UnderlyingPriceDeterminationMethod(1481).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegUnderlyingPriceDeterminationMethod(2189)</li>
     * </ul>
     */
    public static class UnderlyingPriceDeterminationMethodValues {

        public static final int Regular          = 1;
        public static final int SpecialReference = 2;
        public static final int OptimalValue     = 3;
        public static final int AverageValue     = 4;

        private UnderlyingPriceDeterminationMethodValues() {
        }

    }

    /**
     * Values for OptPayoutType(1482).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingOptPayoutType(2028)</li>
     *   <li>LegOptPayoutType(2193)</li>
     * </ul>
     */
    public static class OptPayoutTypeValues {

        public static final int Vanilla            = 1;
        public static final int Capped             = 2;
        public static final int Binary             = 3;
        public static final int Asian              = 4;
        public static final int Barrier            = 5;
        public static final int DigitalBarrier     = 6;
        public static final int Lookback           = 7;
        public static final int OtherPathDependent = 8;
        public static final int Other              = 99;

        private OptPayoutTypeValues() {
        }

    }

    /**
     * Values for ComplexEventType(1484).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingComplexEventType(2046)</li>
     *   <li>LegComplexEventType(2219)</li>
     * </ul>
     */
    public static class ComplexEventTypeValues {

        public static final int Capped            = 1;
        public static final int Trigger           = 2;
        public static final int KnockInUp         = 3;
        public static final int KnockInDown       = 4;
        public static final int KnockOutUp        = 5;
        public static final int KnockOutDown      = 6;
        public static final int Underlying        = 7;
        public static final int ResetBarrier      = 8;
        public static final int RollingBarrier    = 9;
        public static final int OneTouch          = 10;
        public static final int NoTouch           = 11;
        public static final int DblOneTouch       = 12;
        public static final int DblNoTouch        = 13;
        public static final int FXComposite       = 14;
        public static final int FXQuanto          = 15;
        public static final int FXCrssCcy         = 16;
        public static final int StrkSpread        = 17;
        public static final int ClndrSpread       = 18;
        public static final int PxObsvtn          = 19;
        public static final int PassThrough       = 20;
        public static final int StrkSched         = 21;
        public static final int EquityValuation   = 22;
        public static final int DividendValuation = 23;

        private ComplexEventTypeValues() {
        }

    }

    /**
     * Values for ComplexEventPriceBoundaryMethod(1487).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingComplexEventPriceBoundaryMethod(2049)</li>
     *   <li>LegComplexEventPriceBoundaryMethod(2229)</li>
     * </ul>
     */
    public static class ComplexEventPriceBoundaryMethodValues {

        public static final int LessThanComplexEventPrice             = 1;
        public static final int LessThanOrEqualToComplexEventPrice    = 2;
        public static final int EqualToComplexEventPrice              = 3;
        public static final int GreaterThanOrEqualToComplexEventPrice = 4;
        public static final int GreaterThanComplexEventPrice          = 5;

        private ComplexEventPriceBoundaryMethodValues() {
        }

    }

    /**
     * Values for ComplexEventPriceTimeType(1489).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingComplexEventPriceTimeType(2051)</li>
     *   <li>LegComplexEventPriceTimeType(2231)</li>
     * </ul>
     */
    public static class ComplexEventPriceTimeTypeValues {

        public static final int Expiration                    = 1;
        public static final int Immediate                     = 2;
        public static final int SpecifiedDate                 = 3;
        public static final int Close                         = 4;
        public static final int Open                          = 5;
        public static final int OfficialSettlPrice            = 6;
        public static final int DerivativesClose              = 7;
        public static final int AsSpecifiedMasterConfirmation = 8;

        private ComplexEventPriceTimeTypeValues() {
        }

    }

    /**
     * Values for ComplexEventCondition(1490).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingComplexEventCondition(2052)</li>
     *   <li>LegComplexEventCondition(2232)</li>
     * </ul>
     */
    public static class ComplexEventConditionValues {

        public static final int And = 1;
        public static final int Or  = 2;

        private ComplexEventConditionValues() {
        }

    }

    /**
     * Values for StreamAsgnReqType(1498).
     */
    public static class StreamAsgnReqTypeValues {

        public static final int StreamAssignmentForNewCustomer      = 1;
        public static final int StreamAssignmentForExistingCustomer = 2;

        private StreamAsgnReqTypeValues() {
        }

    }

    /**
     * Values for StreamAsgnRejReason(1502).
     */
    public static class StreamAsgnRejReasonValues {

        public static final int UnknownClient                = 0;
        public static final int ExceedsMaximumSize           = 1;
        public static final int UnknownOrInvalidCurrencyPair = 2;
        public static final int NoAvailableStream            = 3;
        public static final int Other                        = 99;

        private StreamAsgnRejReasonValues() {
        }

    }

    /**
     * Values for StreamAsgnAckType(1503).
     */
    public static class StreamAsgnAckTypeValues {

        public static final int AssignmentAccepted = 0;
        public static final int AssignmentRejected = 1;

        private StreamAsgnAckTypeValues() {
        }

    }

    /**
     * Values for RequestResult(1511).
     */
    public static class RequestResultValues {

        public static final int ValidRequest                = 0;
        public static final int InvalidOrUnsupportedRequest = 1;
        public static final int NoDataFound                 = 2;
        public static final int NotAuthorized               = 3;
        public static final int DataTemporarilyUnavailable  = 4;
        public static final int RequestForDataNotSupported  = 5;
        public static final int Other                       = 99;

        private RequestResultValues() {
        }

    }

    /**
     * Values for PartyRelationship(1515).
     */
    public static class PartyRelationshipValues {

        public static final int IsAlso                     = 0;
        public static final int ClearsFor                  = 1;
        public static final int ClearsThrough              = 2;
        public static final int TradesFor                  = 3;
        public static final int TradesThrough              = 4;
        public static final int Sponsors                   = 5;
        public static final int SponsoredThrough           = 6;
        public static final int ProvidesGuaranteeFor       = 7;
        public static final int IsGuaranteedBy             = 8;
        public static final int MemberOf                   = 9;
        public static final int HasMembers                 = 10;
        public static final int ProvidesMarketplaceFor     = 11;
        public static final int ParticipantOfMarketplace   = 12;
        public static final int CarriesPositionsFor        = 13;
        public static final int PostsTradesTo              = 14;
        public static final int EntersTradesFor            = 15;
        public static final int EntersTradesThrough        = 16;
        public static final int ProvidesQuotesTo           = 17;
        public static final int RequestsQuotesFrom         = 18;
        public static final int InvestsFor                 = 19;
        public static final int InvestsThrough             = 20;
        public static final int BrokersTradesFor           = 21;
        public static final int BrokersTradesThrough       = 22;
        public static final int ProvidesTradingServicesFor = 23;
        public static final int UsesTradingServicesOf      = 24;
        public static final int ApprovesOf                 = 25;
        public static final int ApprovedBy                 = 26;
        public static final int ParentFirmFor              = 27;
        public static final int SubsidiaryOf               = 28;
        public static final int RegulatoryOwnerOf          = 29;
        public static final int OwnedByRegulatory          = 30;
        public static final int Controls                   = 31;
        public static final int IsControlledBy             = 32;
        public static final int LegalOwnerOf               = 33;
        public static final int OwnedByLegal               = 34;
        public static final int BeneficialOwnerOf          = 35;
        public static final int OwnedByBeneficial          = 36;
        public static final int SettlesFor                 = 37;
        public static final int SettlesThrough             = 38;

        private PartyRelationshipValues() {
        }

    }

    /**
     * Values for TrdAckStatus(1523).
     */
    public static class TrdAckStatusValues {

        public static final int Accepted = 0;
        public static final int Rejected = 1;
        public static final int Received = 2;

        private TrdAckStatusValues() {
        }

    }

    /**
     * Values for RiskLimitType(1530).
     */
    public static class RiskLimitTypeValues {

        public static final int CreditLimit                            = 0;
        public static final int GrossLimit                             = 1;
        public static final int NetLimit                               = 2;
        public static final int Exposure                               = 3;
        public static final int LongLimit                              = 4;
        public static final int ShortLimit                             = 5;
        public static final int CashMargin                             = 6;
        public static final int AdditionalMargin                       = 7;
        public static final int TotalMargin                            = 8;
        public static final int LimitConsumed                          = 9;
        public static final int ClipSize                               = 10;
        public static final int MaxNotionalOrderSize                   = 11;
        public static final int DV01PV01Limit                          = 12;
        public static final int CS01Limit                              = 13;
        public static final int VolumeLimitPerTimePeriod               = 14;
        public static final int VolFilledPctOrdVolTmPeriod             = 15;
        public static final int NotlFilledPctNotlTmPeriod              = 16;
        public static final int TransactionExecutionLimitPerTimePeriod = 17;

        private RiskLimitTypeValues() {
        }

    }

    /**
     * Values for InstrumentScopeOperator(1535).
     */
    public static class InstrumentScopeOperatorValues {

        public static final int Include = 1;
        public static final int Exclude = 2;

        private InstrumentScopeOperatorValues() {
        }

    }

    /**
     * Values for SwapSubClass(1575).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegSwapSubClass(2156)</li>
     *   <li>UnderlyingSwapSubClass(2289)</li>
     * </ul>
     */
    public static class SwapSubClassValues {

        public static final String Amortizing                = "AMTZ";
        public static final String Compounding               = "COMP";
        public static final String ConstantNotionalSchedule  = "CNST";
        public static final String AccretingNotionalSchedule = "ACRT";
        public static final String CustomNotionalSchedule    = "CUST";

        private SwapSubClassValues() {
        }

    }

    /**
     * Values for SecurityClassificationReason(1583).
     */
    public static class SecurityClassificationReasonValues {

        public static final int Fee                      = 0;
        public static final int CreditControls           = 1;
        public static final int Margin                   = 2;
        public static final int EntitlementOrEligibility = 3;
        public static final int MarketData               = 4;
        public static final int AccountSelection         = 5;
        public static final int DeliveryProcess          = 6;
        public static final int Sector                   = 7;

        private SecurityClassificationReasonValues() {
        }

    }

    /**
     * Values for PosAmtReason(1585).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPosAmtReason(1590)</li>
     *   <li>TradeAllocAmtReason(1850)</li>
     * </ul>
     */
    public static class PosAmtReasonValues {

        public static final int OptionsSettlement        = 0;
        public static final int PendingErosionAdjustment = 1;
        public static final int FinalErosionAdjustment   = 2;
        public static final int TearUpCouponAmount       = 3;
        public static final int PriceAlignmentInterest   = 4;
        public static final int DeliveryInvoiceCharges   = 5;
        public static final int DeliveryStorageCharges   = 6;

        private PosAmtReasonValues() {
        }

    }

    /**
     * Values for SideClearingTradePriceType(1598).
     */
    public static class SideClearingTradePriceTypeValues {

        public static final int TradeClearingAtExecutionPrice         = 0;
        public static final int TradeClearingAtAlternateClearingPrice = 1;

        private SideClearingTradePriceTypeValues() {
        }

    }

    /**
     * Values for SecurityRejectReason(1607).
     */
    public static class SecurityRejectReasonValues {

        public static final int InvalidInstrumentRequested             = 1;
        public static final int InstrumentAlreadyExists                = 2;
        public static final int RequestTypeNotSupported                = 3;
        public static final int SystemUnavailableForInstrumentCreation = 4;
        public static final int IneligibleInstrumentGroup              = 5;
        public static final int InstrumentIDUnavailable                = 6;
        public static final int InvalidOrMissingDataOnOptionLeg        = 7;
        public static final int InvalidOrMissingDataOnFutureLeg        = 8;
        public static final int InvalidOrMissingDataOnFXLeg            = 10;
        public static final int InvalidLegPriceSpecified               = 11;
        public static final int InvalidInstrumentStructureSpecified    = 12;

        private SecurityRejectReasonValues() {
        }

    }

    /**
     * Values for ThrottleStatus(1609).
     */
    public static class ThrottleStatusValues {

        public static final int ThrottleLimitNotExceededNotQueued = 0;
        public static final int QueuedDueToThrottleLimitExceeded  = 1;

        private ThrottleStatusValues() {
        }

    }

    /**
     * Values for ThrottleAction(1611).
     */
    public static class ThrottleActionValues {

        public static final int QueueInbound  = 0;
        public static final int QueueOutbound = 1;
        public static final int Reject        = 2;
        public static final int Disconnect    = 3;
        public static final int Warning       = 4;

        private ThrottleActionValues() {
        }

    }

    /**
     * Values for ThrottleType(1612).
     */
    public static class ThrottleTypeValues {

        public static final int InboundRate         = 0;
        public static final int OutstandingRequests = 1;

        private ThrottleTypeValues() {
        }

    }

    /**
     * Values for StreamAsgnType(1617).
     */
    public static class StreamAsgnTypeValues {

        public static final int Assignment = 1;
        public static final int Rejected   = 2;
        public static final int Terminate  = 3;

        private StreamAsgnTypeValues() {
        }

    }

    /**
     * Values for MatchInst(1625).
     */
    public static class MatchInstValues {

        public static final int Match      = 1;
        public static final int DoNotMatch = 2;

        private MatchInstValues() {
        }

    }

    /**
     * Values for TriggerScope(1628).
     */
    public static class TriggerScopeValues {

        public static final int ThisOrder                                  = 0;
        public static final int OtherOrder                                 = 1;
        public static final int AllOtherOrdersForGivenSecurity             = 2;
        public static final int AllOtherOrdersForGivenSecurityAndPrice     = 3;
        public static final int AllOtherOrdersForGivenSecurityAndSide      = 4;
        public static final int AllOtherOrdersForGivenSecurityPriceAndSide = 5;

        private TriggerScopeValues() {
        }

    }

    /**
     * Values for LimitAmtType(1631).
     */
    public static class LimitAmtTypeValues {

        public static final int CreditLimit        = 0;
        public static final int GrossPositionLimit = 1;
        public static final int NetPositionLimit   = 2;
        public static final int RiskExposureLimit  = 3;
        public static final int LongPositionLimit  = 4;
        public static final int ShortPositionLimit = 5;

        private LimitAmtTypeValues() {
        }

    }

    /**
     * Values for MarginReqmtInqQualifier(1637).
     */
    public static class MarginReqmtInqQualifierValues {

        public static final int Summary       = 0;
        public static final int Detail        = 1;
        public static final int ExcessDeficit = 2;
        public static final int NetPosition   = 3;

        private MarginReqmtInqQualifierValues() {
        }

    }

    /**
     * Values for MarginReqmtRptType(1638).
     */
    public static class MarginReqmtRptTypeValues {

        public static final int Summary       = 0;
        public static final int Detail        = 1;
        public static final int ExcessDeficit = 2;

        private MarginReqmtRptTypeValues() {
        }

    }

    /**
     * Values for MarginReqmtInqResult(1641).
     */
    public static class MarginReqmtInqResultValues {

        public static final int Successful                            = 0;
        public static final int InvalidOrUnknownInstrument            = 1;
        public static final int InvalidOrUnknownMarginClass           = 2;
        public static final int InvalidParties                        = 3;
        public static final int InvalidTransportTypeReq               = 4;
        public static final int InvalidDestinationReq                 = 5;
        public static final int NoMarginReqFound                      = 6;
        public static final int MarginReqInquiryQualifierNotSupported = 7;
        public static final int UnauthorizedForMarginReqInquiry       = 8;
        public static final int Other                                 = 99;

        private MarginReqmtInqResultValues() {
        }

    }

    /**
     * Values for MarginAmtType(1644).
     */
    public static class MarginAmtTypeValues {

        public static final int AdditionalMargin         = 1;
        public static final int AdjustedMargin           = 2;
        public static final int UnadjustedMargin         = 3;
        public static final int BinaryAddOnAmount        = 4;
        public static final int CashBalanceAmount        = 5;
        public static final int ConcentrationMargin      = 6;
        public static final int CoreMargin               = 7;
        public static final int DeliveryMargin           = 8;
        public static final int DiscretionaryMargin      = 9;
        public static final int FuturesSpreadMargin      = 10;
        public static final int InitialMargin            = 11;
        public static final int LiquidatingMargin        = 12;
        public static final int MarginCallAmount         = 13;
        public static final int MarginDeficitAmount      = 14;
        public static final int MarginExcessAmount       = 15;
        public static final int OptionPremiumAmount      = 16;
        public static final int PremiumMargin            = 17;
        public static final int ReserveMargin            = 18;
        public static final int SecurityCollateralAmount = 19;
        public static final int StressTestAddOnAmount    = 20;
        public static final int SuperMargin              = 21;
        public static final int TotalMargin              = 22;
        public static final int VariationMargin          = 23;
        public static final int SecondaryVariationMargin = 24;
        public static final int RolledUpMarginDeficit    = 25;
        public static final int SpreadResponseMargin     = 26;
        public static final int SystemicRiskMargin       = 27;
        public static final int CurveRiskMargin          = 28;
        public static final int IndexSpreadRiskMargin    = 29;
        public static final int SectorRiskMargin         = 30;
        public static final int JumpToDefaultRiskMargin  = 31;
        public static final int BasisRiskMargin          = 32;
        public static final int InterestRateRiskMargin   = 33;
        public static final int JumpToHealthRiskMargin   = 34;
        public static final int OtherRiskMargin          = 35;

        private MarginAmtTypeValues() {
        }

    }

    /**
     * Values for RelatedInstrumentType(1648).
     */
    public static class RelatedInstrumentTypeValues {

        public static final int HedgesForInstrument           = 1;
        public static final int Underlier                     = 2;
        public static final int EquityEquivalent              = 3;
        public static final int NearestExchangeTradedContract = 4;
        public static final int RetailEquivalent              = 5;
        public static final int Leg                           = 6;

        private RelatedInstrumentTypeValues() {
        }

    }

    /**
     * Values for MarketMakerActivity(1655).
     */
    public static class MarketMakerActivityValues {

        public static final int NoParticipation             = 0;
        public static final int BuyParticipation            = 1;
        public static final int SellParticipation           = 2;
        public static final int BothBuyAndSellParticipation = 3;

        private MarketMakerActivityValues() {
        }

    }

    /**
     * Values for PartyDetailStatus(1672).
     */
    public static class PartyDetailStatusValues {

        public static final int Active    = 0;
        public static final int Suspended = 1;
        public static final int Halted    = 2;

        private PartyDetailStatusValues() {
        }

    }

    /**
     * Values for PartyDetailRoleQualifier(1674).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>RelatedPartyDetailRoleQualifier(1675)</li>
     *   <li>TargetPartyRoleQualifier(1818)</li>
     *   <li>RequestingPartyRoleQualifier(2338)</li>
     *   <li>PartyRoleQualifier(2376)</li>
     *   <li>DerivativeInstrumentPartyRoleQualifier(2377)</li>
     *   <li>InstrumentPartyRoleQualifier(2378)</li>
     *   <li>LegInstrumentPartyRoleQualifier(2379)</li>
     *   <li>LegProvisionPartyRoleQualifier(2380)</li>
     *   <li>Nested2PartyRoleQualifier(2381)</li>
     *   <li>Nested3PartyRoleQualifier(2382)</li>
     *   <li>Nested4PartyRoleQualifier(2383)</li>
     *   <li>NestedPartyRoleQualifier(2384)</li>
     *   <li>ProvisionPartyRoleQualifier(2385)</li>
     *   <li>RequestedPartyRoleQualifier(2386)</li>
     *   <li>RootPartyRoleQualifier(2388)</li>
     *   <li>SettlPartyRoleQualifier(2389)</li>
     *   <li>UnderlyingInstrumentPartyRoleQualifier(2391)</li>
     *   <li>PaymentSettlPartyRoleQualifier(40237)</li>
     *   <li>UnderlyingProvisionPartyRoleQualifier(40918)</li>
     * </ul>
     */
    public static class PartyDetailRoleQualifierValues {

        public static final int Agency                      = 0;
        public static final int Principal                   = 1;
        public static final int RisklessPrincipal           = 2;
        public static final int GeneralClearingMember       = 3;
        public static final int IndividualClearingMember    = 4;
        public static final int PreferredMarketMaker        = 5;
        public static final int DirectedMarketMaker         = 6;
        public static final int Bank                        = 7;
        public static final int Hub                         = 8;
        public static final int PrimaryTrdRepository        = 9;
        public static final int OrigTrdRepository           = 10;
        public static final int AddtnlIntlTrdRepository     = 11;
        public static final int AddtnlDomesticTrdRepository = 12;
        public static final int RelatedExchange             = 13;
        public static final int OptionsExchange             = 14;
        public static final int SpecifiedExchange           = 15;
        public static final int ConstituentExchange         = 16;
        public static final int ExemptFromTradeReporting    = 17;
        public static final int Current                     = 18;
        public static final int New                         = 19;
        public static final int DesignatedSponsor           = 20;
        public static final int Specialist                  = 21;
        public static final int Algorithm                   = 22;
        public static final int FirmOrLegalEntity           = 23;
        public static final int NaturalPerson               = 24;
        public static final int RegularTrader               = 25;
        public static final int HeadTrader                  = 26;
        public static final int Supervisor                  = 27;
        public static final int TriParty                    = 28;
        public static final int Lender                      = 29;

        private PartyDetailRoleQualifierValues() {
        }

    }

    /**
     * Values for ThrottleInst(1685).
     */
    public static class ThrottleInstValues {

        public static final int RejectIfThrottleLimitExceeded = 0;
        public static final int QueueIfThrottleLimitExceeded  = 1;

        private ThrottleInstValues() {
        }

    }

    /**
     * Values for ThrottleCountIndicator(1686).
     */
    public static class ThrottleCountIndicatorValues {

        public static final int OutstandingRequestsUnchanged = 0;
        public static final int OutstandingRequestsDecreased = 1;

        private ThrottleCountIndicatorValues() {
        }

    }

    /**
     * Values for ShortSaleRestriction(1687).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingShortSaleRestriction(2043)</li>
     *   <li>LegShortSaleRestriction(2209)</li>
     * </ul>
     */
    public static class ShortSaleRestrictionValues {

        public static final int NoRestrictions                       = 0;
        public static final int SecurityNotShortable                 = 1;
        public static final int SecurityNotShortableAtOrBelowBestBid = 2;
        public static final int SecurityNotShortableWithoutPreBorrow = 3;

        private ShortSaleRestrictionValues() {
        }

    }

    /**
     * Values for ShortSaleExemptionReason(1688).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegShortSaleExemptionReason(1689)</li>
     *   <li>SideShortSaleExemptionReason(1690)</li>
     * </ul>
     */
    public static class ShortSaleExemptionReasonValues {

        public static final int ExemptionReasonUnknown             = 0;
        public static final int IncomingSSE                        = 1;
        public static final int AboveNationalBestBid               = 2;
        public static final int DelayedDelivery                    = 3;
        public static final int OddLot                             = 4;
        public static final int DomesticArbitrage                  = 5;
        public static final int InternationalArbitrage             = 6;
        public static final int UnderwriterOrSyndicateDistribution = 7;
        public static final int RisklessPrincipal                  = 8;
        public static final int VWAP                               = 9;

        private ShortSaleExemptionReasonValues() {
        }

    }

    /**
     * Values for OrderOrigination(1724).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ContraOrderOrigination(2882)</li>
     * </ul>
     */
    public static class OrderOriginationValues {

        public static final int OrderReceivedFromCustomer                = 1;
        public static final int OrderReceivedFromWithinFirm              = 2;
        public static final int OrderReceivedFromAnotherBrokerDealer     = 3;
        public static final int OrderReceivedFromCustomerOrWithFirm      = 4;
        public static final int OrderReceivedFromDirectAccessCustomer    = 5;
        public static final int OrderReceivedFromForeignDealerEquivalent = 6;
        public static final int OrderReceivedFromExecutionOnlyService    = 7;

        private OrderOriginationValues() {
        }

    }

    /**
     * Values for AllocationRollupInstruction(1735).
     */
    public static class AllocationRollupInstructionValues {

        public static final int Rollup      = 0;
        public static final int DoNotRollUp = 1;

        private AllocationRollupInstructionValues() {
        }

    }

    /**
     * Values for AllocReversalStatus(1738).
     */
    public static class AllocReversalStatusValues {

        public static final int Completed = 0;
        public static final int Refused   = 1;
        public static final int Cancelled = 2;

        private AllocReversalStatusValues() {
        }

    }

    /**
     * Values for ObligationType(1739).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegObligationType(2155)</li>
     * </ul>
     */
    public static class ObligationTypeValues {

        public static final String Bond        = "0";
        public static final String ConvertBond = "1";
        public static final String Mortgage    = "2";
        public static final String Loan        = "3";

        private ObligationTypeValues() {
        }

    }

    /**
     * Values for TradePriceNegotiationMethod(1740).
     */
    public static class TradePriceNegotiationMethodValues {

        public static final int PercentPar       = 0;
        public static final int DealSpread       = 1;
        public static final int UpfrontPnts      = 2;
        public static final int UpfrontAmt       = 3;
        public static final int ParUpfrontAmt    = 4;
        public static final int SpreadUpfrontAmt = 5;
        public static final int UpfrontPntsAmt   = 6;

        private TradePriceNegotiationMethodValues() {
        }

    }

    /**
     * Values for UpfrontPriceType(1741).
     */
    public static class UpfrontPriceTypeValues {

        public static final int Percentage  = 1;
        public static final int FixedAmount = 3;

        private UpfrontPriceTypeValues() {
        }

    }

    /**
     * Values for ApplLevelRecoveryIndicator(1744).
     */
    public static class ApplLevelRecoveryIndicatorValues {

        public static final int NoApplRecoveryNeeded = 0;
        public static final int ApplRecoveryNeeded   = 1;

        private ApplLevelRecoveryIndicatorValues() {
        }

    }

    /**
     * Values for RiskLimitRequestType(1760).
     */
    public static class RiskLimitRequestTypeValues {

        public static final int Definitions                = 1;
        public static final int Utilization                = 2;
        public static final int DefinitionsAndUtilizations = 3;

        private RiskLimitRequestTypeValues() {
        }

    }

    /**
     * Values for RiskLimitRequestResult(1761).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>RiskLimitResult(1764)</li>
     * </ul>
     */
    public static class RiskLimitRequestResultValues {

        public static final int Successful                      = 0;
        public static final int InvalidParty                    = 1;
        public static final int InvalidRelatedParty             = 2;
        public static final int InvalidRiskLimitType            = 3;
        public static final int InvalidRiskLimitID              = 4;
        public static final int InvalidRiskLimitAmount          = 5;
        public static final int InvalidRiskWarningLevelAction   = 6;
        public static final int InvalidRiskInstrumentScope      = 7;
        public static final int RiskLimitActionsNotSupported    = 8;
        public static final int WarningLevelsNotSupported       = 9;
        public static final int WarningLevelActionsNotSupported = 10;
        public static final int RiskInstrumentScopeNotSupported = 11;
        public static final int RiskLimitNotApprovedForParty    = 12;
        public static final int RiskLimitAlreadyDefinedForParty = 13;
        public static final int InstrumentNotApprovedForParty   = 14;
        public static final int NotAuthorized                   = 98;
        public static final int Other                           = 99;

        private RiskLimitRequestResultValues() {
        }

    }

    /**
     * Values for RiskLimitAction(1767).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>RiskWarningLevelAction(1769)</li>
     * </ul>
     */
    public static class RiskLimitActionValues {

        public static final int QueueInbound                    = 0;
        public static final int QueueOutbound                   = 1;
        public static final int Reject                          = 2;
        public static final int Disconnect                      = 3;
        public static final int Warning                         = 4;
        public static final int PingCreditCheckWithRevalidation = 5;
        public static final int PingCreditCheckNoRevalidation   = 6;
        public static final int PushCreditCheckWithRevalidation = 7;
        public static final int PushCreditCheckNoRevalidation   = 8;
        public static final int Suspend                         = 9;
        public static final int HaltTrading                     = 10;

        private RiskLimitActionValues() {
        }

    }

    /**
     * Values for EntitlementType(1775).
     */
    public static class EntitlementTypeValues {

        public static final int Trade                  = 0;
        public static final int MakeMarkets            = 1;
        public static final int HoldPositions          = 2;
        public static final int PerformGiveUps         = 3;
        public static final int SubmitIOIs             = 4;
        public static final int SubscribeMarketData    = 5;
        public static final int ShortWithPreBorrow     = 6;
        public static final int SubmitQuoteRequests    = 7;
        public static final int RespondToQuoteRequests = 8;

        private EntitlementTypeValues() {
        }

    }

    /**
     * Values for EntitlementAttribDatatype(1779).
     */
    public static class EntitlementAttribDatatypeValues {

        public static final int Int                 = 1;
        public static final int Length              = 2;
        public static final int NumInGroup          = 3;
        public static final int SeqNum              = 4;
        public static final int TagNum              = 5;
        public static final int Float               = 6;
        public static final int Qty                 = 7;
        public static final int Price               = 8;
        public static final int PriceOffset         = 9;
        public static final int Amt                 = 10;
        public static final int Percentage          = 11;
        public static final int Char                = 12;
        public static final int Boolean             = 13;
        public static final int String              = 14;
        public static final int MultipleCharValue   = 15;
        public static final int Currency            = 16;
        public static final int Exchange            = 17;
        public static final int MonthYear           = 18;
        public static final int UTCTimestamp        = 19;
        public static final int UTCTimeOnly         = 20;
        public static final int LocalMktDate        = 21;
        public static final int UTCDateOnly         = 22;
        public static final int Data                = 23;
        public static final int MultipleStringValue = 24;
        public static final int Country             = 25;
        public static final int Language            = 26;
        public static final int TZTimeOnly          = 27;
        public static final int TZTimestamp         = 28;
        public static final int Tenor               = 29;
        public static final int DayOfMonth          = 30;
        public static final int XMLData             = 31;
        public static final int Pattern             = 32;
        public static final int Reserved100Plus     = 33;
        public static final int Reserved1000Plus    = 34;
        public static final int Reserved4000Plus    = 35;

        private EntitlementAttribDatatypeValues() {
        }

    }

    /**
     * Values for TradSesControl(1785).
     */
    public static class TradSesControlValues {

        public static final int Automatic = 0;
        public static final int Manual    = 1;

        private TradSesControlValues() {
        }

    }

    /**
     * Values for TradeVolType(1786).
     */
    public static class TradeVolTypeValues {

        public static final int NumberOfUnits     = 0;
        public static final int NumberOfRoundLots = 1;

        private TradeVolTypeValues() {
        }

    }

    /**
     * Values for OrderEventType(1796).
     */
    public static class OrderEventTypeValues {

        public static final int Added           = 1;
        public static final int Modified        = 2;
        public static final int Deleted         = 3;
        public static final int PartiallyFilled = 4;
        public static final int Filled          = 5;
        public static final int Suspended       = 6;
        public static final int Released        = 7;
        public static final int Restated        = 8;
        public static final int Locked          = 9;
        public static final int Triggered       = 10;
        public static final int Activated       = 11;

        private OrderEventTypeValues() {
        }

    }

    /**
     * Values for OrderEventReason(1798).
     */
    public static class OrderEventReasonValues {

        public static final int AddOrderRequest           = 1;
        public static final int ModifyOrderRequest        = 2;
        public static final int DeleteOrderRequest        = 3;
        public static final int OrderEnteredOOB           = 4;
        public static final int OrderModifiedOOB          = 5;
        public static final int OrderDeletedOOB           = 6;
        public static final int OrderActivatedOrTriggered = 7;
        public static final int OrderExpired              = 8;
        public static final int ReserveOrderRefreshed     = 9;
        public static final int AwayMarketBetter          = 10;
        public static final int CorporateAction           = 11;
        public static final int StartOfDay                = 12;
        public static final int EndOfDay                  = 13;

        private OrderEventReasonValues() {
        }

    }

    /**
     * Values for AuctionType(1803).
     */
    public static class AuctionTypeValues {

        public static final int None                                   = 0;
        public static final int BlockOrderAuction                      = 1;
        public static final int DirectedOrderAuction                   = 2;
        public static final int ExposureOrderAuction                   = 3;
        public static final int FlashOrderAuction                      = 4;
        public static final int FacilitationOrderAuction               = 5;
        public static final int SolicitationOrderAuction               = 6;
        public static final int PriceImprovementMechanism              = 7;
        public static final int DirectedOrderPriceImprovementMechanism = 8;

        private AuctionTypeValues() {
        }

    }

    /**
     * Values for AuctionInstruction(1805).
     */
    public static class AuctionInstructionValues {

        public static final int AutomatedAuctionPermitted    = 0;
        public static final int AutomatedAuctionNotPermitted = 1;

        private AuctionInstructionValues() {
        }

    }

    /**
     * Values for LockType(1807).
     */
    public static class LockTypeValues {

        public static final int NotLocked           = 0;
        public static final int AwayMarketNetter    = 1;
        public static final int ThreeTickLocked     = 2;
        public static final int LockedByMarketMaker = 3;
        public static final int DirectedOrderLock   = 4;
        public static final int MultilegLock        = 5;
        public static final int MarketOrderLock     = 6;
        public static final int PreAssignmentLock   = 7;

        private LockTypeValues() {
        }

    }

    /**
     * Values for ReleaseInstruction(1810).
     */
    public static class ReleaseInstructionValues {

        public static final int ISO                     = 1;
        public static final int NoAwayMarketBetterCheck = 2;

        private ReleaseInstructionValues() {
        }

    }

    /**
     * Values for DisclosureType(1813).
     */
    public static class DisclosureTypeValues {

        public static final int Volume          = 1;
        public static final int Price           = 2;
        public static final int Side            = 3;
        public static final int AON             = 4;
        public static final int General         = 5;
        public static final int ClearingAccount = 6;
        public static final int CMTAAccount     = 7;

        private DisclosureTypeValues() {
        }

    }

    /**
     * Values for DisclosureInstruction(1814).
     */
    public static class DisclosureInstructionValues {

        public static final int No                = 0;
        public static final int Yes               = 1;
        public static final int UseDefaultSetting = 2;

        private DisclosureInstructionValues() {
        }

    }

    /**
     * Values for TradingCapacity(1815).
     */
    public static class TradingCapacityValues {

        public static final int Customer               = 1;
        public static final int CustomerProfessional   = 2;
        public static final int BrokerDealer           = 3;
        public static final int CustomerBrokerDealer   = 4;
        public static final int Principal              = 5;
        public static final int MarketMaker            = 6;
        public static final int AwayMarketMaker        = 7;
        public static final int SystematicInternaliser = 8;

        private TradingCapacityValues() {
        }

    }

    /**
     * Values for ClearingAccountType(1816).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegClearingAccountType(1817)</li>
     * </ul>
     */
    public static class ClearingAccountTypeValues {

        public static final int Customer    = 1;
        public static final int Firm        = 2;
        public static final int MarketMaker = 3;

        private ClearingAccountTypeValues() {
        }

    }

    /**
     * Values for RelatedPriceSource(1821).
     */
    public static class RelatedPriceSourceValues {

        public static final int NBBid   = 1;
        public static final int NBOffer = 2;

        private RelatedPriceSourceValues() {
        }

    }

    /**
     * Values for MinQtyMethod(1822).
     */
    public static class MinQtyMethodValues {

        public static final int Once     = 1;
        public static final int Multiple = 2;

        private MinQtyMethodValues() {
        }

    }

    /**
     * Values for Triggered(1823).
     */
    public static class TriggeredValues {

        public static final int NotTriggered       = 0;
        public static final int Triggered          = 1;
        public static final int StopOrderTriggered = 2;
        public static final int OCOOrderTriggered  = 3;
        public static final int OTOOrderTriggered  = 4;
        public static final int OUOOrderTriggered  = 5;

        private TriggeredValues() {
        }

    }

    /**
     * Values for EventTimeUnit(1827).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegEventTimeUnit(2063)</li>
     * </ul>
     */
    public static class EventTimeUnitValues {

        public static final String Hour   = "H";
        public static final String Minute = "Min";
        public static final String Second = "S";
        public static final String Day    = "D";
        public static final String Week   = "Wk";
        public static final String Month  = "Mo";
        public static final String Year   = "Yr";

        private EventTimeUnitValues() {
        }

    }

    /**
     * Values for ClearedIndicator(1832).
     */
    public static class ClearedIndicatorValues {

        public static final int NotCleared = 0;
        public static final int Cleared    = 1;
        public static final int Submitted  = 2;
        public static final int Rejected   = 3;

        private ClearedIndicatorValues() {
        }

    }

    /**
     * Values for ContractRefPosType(1833).
     */
    public static class ContractRefPosTypeValues {

        public static final int TwoComponentIntercommoditySpread = 0;
        public static final int IndexOrBasket                    = 1;
        public static final int TwoComponentLocationBasis        = 2;
        public static final int Other                            = 99;

        private ContractRefPosTypeValues() {
        }

    }

    /**
     * Values for PositionCapacity(1834).
     */
    public static class PositionCapacityValues {

        public static final int Principal    = 0;
        public static final int Agent        = 1;
        public static final int Customer     = 2;
        public static final int Counterparty = 3;

        private PositionCapacityValues() {
        }

    }

    /**
     * Values for TradePriceCondition(1839).
     */
    public static class TradePriceConditionValues {

        public static final int SpecialCumDividend                 = 0;
        public static final int SpecialCumRights                   = 1;
        public static final int SpecialExDividend                  = 2;
        public static final int SpecialExRights                    = 3;
        public static final int SpecialCumCoupon                   = 4;
        public static final int SpecialCumCapitalRepayments        = 5;
        public static final int SpecialExCoupon                    = 6;
        public static final int SpecialExCapitalRepayments         = 7;
        public static final int CashSettlement                     = 8;
        public static final int SpecialCumBonus                    = 9;
        public static final int SpecialPrice                       = 10;
        public static final int SpecialExBonus                     = 11;
        public static final int GuaranteedDelivery                 = 12;
        public static final int SpecialDividend                    = 13;
        public static final int PriceImprovement                   = 14;
        public static final int NonPriceFormingTrade               = 15;
        public static final int TradeExemptedFromTradingObligation = 16;
        public static final int PricePending                       = 17;
        public static final int PriceNotApplicable                 = 18;

        private TradePriceConditionValues() {
        }

    }

    /**
     * Values for TradeAllocStatus(1840).
     */
    public static class TradeAllocStatusValues {

        public static final int PendingClear = 0;
        public static final int Claimed      = 1;
        public static final int Cleared      = 2;
        public static final int Rejected     = 3;

        private TradeAllocStatusValues() {
        }

    }

    /**
     * Values for TradeQtyType(1842).
     */
    public static class TradeQtyTypeValues {

        public static final int ClearedQuantity           = 0;
        public static final int LongSideClaimedQuantity   = 1;
        public static final int ShortSideClaimedQuantity  = 2;
        public static final int LongSideRejectedQuantity  = 3;
        public static final int ShortSideRejectedQuantity = 4;
        public static final int PendingQuantity           = 5;
        public static final int TransactionQuantity       = 6;
        public static final int RemainingQuantity         = 7;
        public static final int PreviousRemainingQuantity = 8;

        private TradeQtyTypeValues() {
        }

    }

    /**
     * Values for TradeAllocGroupInstruction(1848).
     */
    public static class TradeAllocGroupInstructionValues {

        public static final int Add      = 0;
        public static final int DoNotAdd = 1;

        private TradeAllocGroupInstructionValues() {
        }

    }

    /**
     * Values for OffsetInstruction(1849).
     */
    public static class OffsetInstructionValues {

        public static final int Offset = 0;
        public static final int Onset  = 1;

        private OffsetInstructionValues() {
        }

    }

    /**
     * Values for SideAvgPxIndicator(1853).
     */
    public static class SideAvgPxIndicatorValues {

        public static final int NoAvgPricing               = 0;
        public static final int TradeIsPartAvgPriceGrp     = 1;
        public static final int LastTradeIsPartAvgPriceGrp = 2;

        private SideAvgPxIndicatorValues() {
        }

    }

    /**
     * Values for RelatedTradeIDSource(1857).
     */
    public static class RelatedTradeIDSourceValues {

        public static final int NonFIXSource         = 0;
        public static final int TradeID              = 1;
        public static final int SecondaryTradeID     = 2;
        public static final int TradeReportID        = 3;
        public static final int FirmTradeID          = 4;
        public static final int SecondaryFirmTradeID = 5;
        public static final int RegulatoryTradeID    = 6;

        private RelatedTradeIDSourceValues() {
        }

    }

    /**
     * Values for RelatedPositionIDSource(1863).
     */
    public static class RelatedPositionIDSourceValues {

        public static final int PosMaintRptID    = 1;
        public static final int TransferID       = 2;
        public static final int PositionEntityID = 3;

        private RelatedPositionIDSourceValues() {
        }

    }

    /**
     * Values for QuoteAckStatus(1865).
     */
    public static class QuoteAckStatusValues {

        public static final int ReceivedNotYetProcessed = 0;
        public static final int Accepted                = 1;
        public static final int Rejected                = 2;

        private QuoteAckStatusValues() {
        }

    }

    /**
     * Values for ValueCheckType(1869).
     */
    public static class ValueCheckTypeValues {

        public static final int PriceCheck         = 1;
        public static final int NotionalValueCheck = 2;
        public static final int QuantityCheck      = 3;

        private ValueCheckTypeValues() {
        }

    }

    /**
     * Values for ValueCheckAction(1870).
     */
    public static class ValueCheckActionValues {

        public static final int DoNotCheck = 0;
        public static final int Check      = 1;
        public static final int BestEffort = 2;

        private ValueCheckActionValues() {
        }

    }

    /**
     * Values for PartyDetailRequestResult(1877).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>PartyDetailDefinitionResult(1880)</li>
     * </ul>
     */
    public static class PartyDetailRequestResultValues {

        public static final int Successful          = 0;
        public static final int InvalidParty        = 1;
        public static final int InvalidRelatedParty = 2;
        public static final int InvalidPartyStatus  = 3;
        public static final int NotAuthorized       = 98;
        public static final int Other               = 99;

        private PartyDetailRequestResultValues() {
        }

    }

    /**
     * Values for PartyDetailRequestStatus(1878).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>RiskLimitRequestStatus(1762)</li>
     *   <li>EntitlementRequestStatus(1882)</li>
     * </ul>
     */
    public static class PartyDetailRequestStatusValues {

        public static final int Accepted            = 0;
        public static final int AcceptedWithChanges = 1;
        public static final int Rejected            = 2;
        public static final int AcceptancePending   = 3;

        private PartyDetailRequestStatusValues() {
        }

    }

    /**
     * Values for PartyDetailDefinitionStatus(1879).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>RiskLimitStatus(1763)</li>
     * </ul>
     */
    public static class PartyDetailDefinitionStatusValues {

        public static final int Accepted            = 0;
        public static final int AcceptedWithChanges = 1;
        public static final int Rejected            = 2;

        private PartyDetailDefinitionStatusValues() {
        }

    }

    /**
     * Values for EntitlementRequestResult(1881).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>EntitlementResult(1884)</li>
     * </ul>
     */
    public static class EntitlementRequestResultValues {

        public static final int Successful                        = 0;
        public static final int InvalidParty                      = 1;
        public static final int InvalidRelatedParty               = 2;
        public static final int InvalidEntitlementType            = 3;
        public static final int InvalidEntitlementID              = 4;
        public static final int InvalidEntitlementAttribute       = 5;
        public static final int InvalidInstrumentScope            = 6;
        public static final int InvalidMarketSegmentScope         = 7;
        public static final int InvalidStartDate                  = 8;
        public static final int InvalidEndDate                    = 9;
        public static final int InstrumentScopeNotSupported       = 10;
        public static final int MarketSegmentScopeNotSupported    = 11;
        public static final int EntitlementNotApprovedForParty    = 12;
        public static final int EntitlementAlreadyDefinedForParty = 13;
        public static final int InstrumentNotApprovedForParty     = 14;
        public static final int NotAuthorized                     = 98;
        public static final int Other                             = 99;

        private EntitlementRequestResultValues() {
        }

    }

    /**
     * Values for EntitlementStatus(1883).
     */
    public static class EntitlementStatusValues {

        public static final int Accepted            = 0;
        public static final int AcceptedWithChanges = 1;
        public static final int Rejected            = 2;
        public static final int Pending             = 3;
        public static final int Requested           = 4;
        public static final int Deferred            = 5;

        private EntitlementStatusValues() {
        }

    }

    /**
     * Values for TradeMatchAckStatus(1896).
     */
    public static class TradeMatchAckStatusValues {

        public static final int ReceivedNotProcessed = 0;
        public static final int Accepted             = 1;
        public static final int Rejected             = 2;

        private TradeMatchAckStatusValues() {
        }

    }

    /**
     * Values for TradeMatchRejectReason(1897).
     */
    public static class TradeMatchRejectReasonValues {

        public static final int Successful              = 0;
        public static final int InvalidPartyInformation = 1;
        public static final int UnknownInstrument       = 2;
        public static final int Unauthorized            = 3;
        public static final int InvalidTradeType        = 4;
        public static final int Other                   = 99;

        private TradeMatchRejectReasonValues() {
        }

    }

    /**
     * Values for RegulatoryTradeIDEvent(1904).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>AllocRegulatoryTradeIDEvent(1911)</li>
     *   <li>SideRegulatoryTradeIDEvent(1974)</li>
     * </ul>
     */
    public static class RegulatoryTradeIDEventValues {

        public static final int InitialBlockTrade = 0;
        public static final int Allocation        = 1;
        public static final int Clearing          = 2;
        public static final int Compression       = 3;
        public static final int Novation          = 4;
        public static final int Termination       = 5;
        public static final int PostTrdVal        = 6;

        private RegulatoryTradeIDEventValues() {
        }

    }

    /**
     * Values for RegulatoryTradeIDType(1906).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>AllocRegulatoryTradeIDType(1912)</li>
     *   <li>SideRegulatoryTradeIDType(1975)</li>
     * </ul>
     */
    public static class RegulatoryTradeIDTypeValues {

        public static final int Current                           = 0;
        public static final int Previous                          = 1;
        public static final int Block                             = 2;
        public static final int Related                           = 3;
        public static final int ClearedBlockTrade                 = 4;
        public static final int TradingVenueTransactionIdentifier = 5;

        private RegulatoryTradeIDTypeValues() {
        }

    }

    /**
     * Values for PriceMovementType(1923).
     */
    public static class PriceMovementTypeValues {

        public static final int Amount     = 0;
        public static final int Percentage = 1;

        private PriceMovementTypeValues() {
        }

    }

    /**
     * Values for ClearingIntention(1924).
     */
    public static class ClearingIntentionValues {

        public static final int DoNotIntendToClear = 0;
        public static final int IntendToClear      = 1;

        private ClearingIntentionValues() {
        }

    }

    /**
     * Values for ConfirmationMethod(1927).
     */
    public static class ConfirmationMethodValues {

        public static final int NonElectronic = 0;
        public static final int Electronic    = 1;
        public static final int Unconfirmed   = 2;

        private ConfirmationMethodValues() {
        }

    }

    /**
     * Values for VerificationMethod(1931).
     */
    public static class VerificationMethodValues {

        public static final int NonElectronic = 0;
        public static final int Electronic    = 1;

        private VerificationMethodValues() {
        }

    }

    /**
     * Values for ClearingRequirementException(1932).
     */
    public static class ClearingRequirementExceptionValues {

        public static final int NoException                = 0;
        public static final int Exception                  = 1;
        public static final int EndUserException           = 2;
        public static final int InterAffiliateException    = 3;
        public static final int TreasuryAffiliateException = 4;
        public static final int CooperativeException       = 5;

        private ClearingRequirementExceptionValues() {
        }

    }

    /**
     * Values for IRSDirection(1933).
     */
    public static class IRSDirectionValues {

        public static final String Pay = "PAY";
        public static final String Rcv = "RCV";
        public static final String NA  = "NA";

        private IRSDirectionValues() {
        }

    }

    /**
     * Values for RegulatoryReportType(1934).
     */
    public static class RegulatoryReportTypeValues {

        public static final int RT                          = 0;
        public static final int PET                         = 1;
        public static final int Snapshot                    = 2;
        public static final int Confirmation                = 3;
        public static final int RTPET                       = 4;
        public static final int PETConfirmation             = 5;
        public static final int RTPETConfirmation           = 6;
        public static final int PostTrade                   = 7;
        public static final int Verification                = 8;
        public static final int PstTrdEvnt                  = 9;
        public static final int PstTrdEvntRTReportable      = 10;
        public static final int LMTF                        = 11;
        public static final int DATF                        = 12;
        public static final int VOLO                        = 13;
        public static final int FWAF                        = 14;
        public static final int IDAF                        = 15;
        public static final int VOLW                        = 16;
        public static final int FULF                        = 17;
        public static final int FULA                        = 18;
        public static final int FULV                        = 19;
        public static final int FULJ                        = 20;
        public static final int COAF                        = 21;
        public static final int Order                       = 22;
        public static final int ChildOrder                  = 23;
        public static final int OrderRoute                  = 24;
        public static final int Trade                       = 25;
        public static final int Quote                       = 26;
        public static final int Supplement                  = 27;
        public static final int NewTransaction              = 28;
        public static final int TransactionCorrection       = 29;
        public static final int TransactionModification     = 30;
        public static final int CollateralUpdate            = 31;
        public static final int MarginUpdate                = 32;
        public static final int TransactionReportedInError  = 33;
        public static final int TerminationEarlyTermination = 34;

        private RegulatoryReportTypeValues() {
        }

    }

    /**
     * Values for TradeCollateralization(1936).
     */
    public static class TradeCollateralizationValues {

        public static final int Uncollateralized         = 0;
        public static final int PartiallyCollateralized  = 1;
        public static final int OneWayCollaterallization = 2;
        public static final int FullyCollateralized      = 3;
        public static final int NetExposure              = 4;

        private TradeCollateralizationValues() {
        }

    }

    /**
     * Values for TradeContinuation(1937).
     */
    public static class TradeContinuationValues {

        public static final int Novation                      = 0;
        public static final int PartialNovation               = 1;
        public static final int TradeUnwind                   = 2;
        public static final int PartialTradeUnwind            = 3;
        public static final int Exercise                      = 4;
        public static final int Netting                       = 5;
        public static final int FullNetting                   = 6;
        public static final int PartialNetting                = 7;
        public static final int Amendment                     = 8;
        public static final int Increase                      = 9;
        public static final int CreditEvent                   = 10;
        public static final int StrategicRestructuring        = 11;
        public static final int SuccessionEventReorganization = 12;
        public static final int SuccessionEventRenaming       = 13;
        public static final int Porting                       = 14;
        public static final int Withdrawl                     = 15;
        public static final int Void                          = 16;
        public static final int AccountTransfer               = 17;
        public static final int GiveUp                        = 18;
        public static final int TakeUp                        = 19;
        public static final int AveragePricing                = 20;
        public static final int Reversal                      = 21;
        public static final int AllocTrdPosting               = 22;
        public static final int Cascade                       = 23;
        public static final int Delivery                      = 24;
        public static final int OptionAsgn                    = 25;
        public static final int Expiration                    = 26;
        public static final int Maturity                      = 27;
        public static final int EqualPosAdj                   = 28;
        public static final int UnequalPosAdj                 = 29;
        public static final int Correction                    = 30;
        public static final int EarlyTermination              = 31;
        public static final int Rerate                        = 32;
        public static final int Other                         = 99;

        private TradeContinuationValues() {
        }

    }

    /**
     * Values for AssetClass(1938).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SecondaryAssetClass(1977)</li>
     *   <li>UnderlyingAssetClass(2013)</li>
     *   <li>LegAssetClass(2067)</li>
     *   <li>LegSecondaryAssetClass(2077)</li>
     *   <li>UnderlyingSecondaryAssetClass(2081)</li>
     * </ul>
     */
    public static class AssetClassValues {

        public static final int InterestRate = 1;
        public static final int Currency     = 2;
        public static final int Credit       = 3;
        public static final int Equity       = 4;
        public static final int Commodity    = 5;
        public static final int Other        = 6;
        public static final int Cash         = 7;
        public static final int Debt         = 8;
        public static final int Fund         = 9;
        public static final int LoanFacility = 10;
        public static final int Index        = 11;

        private AssetClassValues() {
        }

    }

    /**
     * Values for AssetSubClass(1939).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SecondaryAssetSubClass(1978)</li>
     *   <li>UnderlyingAssetSubClass(2014)</li>
     *   <li>LegAssetSubClass(2068)</li>
     *   <li>LegSecondaryAssetSubClass(2078)</li>
     *   <li>UnderlyingSecondaryAssetSubClass(2082)</li>
     * </ul>
     */
    public static class AssetSubClassValues {

        public static final int SingleCurrency              = 1;
        public static final int CrossCurrency               = 2;
        public static final int Basket                      = 3;
        public static final int SingleName                  = 4;
        public static final int CreditIndex                 = 5;
        public static final int IndexTranche                = 6;
        public static final int CreditBasket                = 7;
        public static final int Exotic                      = 8;
        public static final int Common                      = 9;
        public static final int Preferred                   = 10;
        public static final int EquityIndex                 = 11;
        public static final int EquityBasket                = 12;
        public static final int Metals                      = 13;
        public static final int Bullion                     = 14;
        public static final int Energy                      = 15;
        public static final int CommodityIndex              = 16;
        public static final int Agricultural                = 17;
        public static final int Environmental               = 18;
        public static final int Freight                     = 19;
        public static final int Government                  = 20;
        public static final int Agency                      = 21;
        public static final int Corporate                   = 22;
        public static final int Financing                   = 23;
        public static final int MoneyMarket                 = 24;
        public static final int Mortgage                    = 25;
        public static final int Municipal                   = 26;
        public static final int MutualFund                  = 27;
        public static final int CollectiveInvestmentVehicle = 28;
        public static final int InvestmentProgram           = 29;
        public static final int SpecializedAccountProgram   = 30;
        public static final int TermLoan                    = 31;
        public static final int BridgeLoan                  = 32;
        public static final int LetterOfCredit              = 33;
        public static final int DividendIndex               = 34;
        public static final int StockDividend               = 35;
        public static final int ExchangeTradedFund          = 36;
        public static final int VolatilityIndex             = 37;
        public static final int FXCrossRates                = 38;
        public static final int FXEmergingMarkets           = 39;
        public static final int FXMajors                    = 40;
        public static final int Fertilizer                  = 41;
        public static final int IndustrialProduct           = 42;
        public static final int Inflation                   = 43;
        public static final int Paper                       = 44;
        public static final int Polypropylene               = 45;
        public static final int OfficialEconomicStatistics  = 46;
        public static final int OtherC10                    = 47;
        public static final int Other                       = 48;

        private AssetSubClassValues() {
        }

    }

    /**
     * Values for SwapClass(1941).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingSwapClass(2016)</li>
     *   <li>LegSwapClass(2070)</li>
     * </ul>
     */
    public static class SwapClassValues {

        public static final String BasisSwap              = "BS";
        public static final String IndexSwap              = "IX";
        public static final String BroadBasedSecuritySwap = "BB";
        public static final String BasketSwap             = "SK";

        private SwapClassValues() {
        }

    }

    /**
     * Values for CouponType(1946).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingCouponType(1989)</li>
     *   <li>LegCouponType(2161)</li>
     *   <li>AdditionalTermBondCouponType(40011)</li>
     *   <li>LegAdditionalTermBondCouponType(41327)</li>
     *   <li>UnderlyingAdditionalTermBondCouponType(42028)</li>
     * </ul>
     */
    public static class CouponTypeValues {

        public static final int Zero         = 0;
        public static final int FixedRate    = 1;
        public static final int FloatingRate = 2;
        public static final int Structured   = 3;

        private CouponTypeValues() {
        }

    }

    /**
     * Values for CouponFrequencyUnit(1949).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingCouponFrequencyUnit(1992)</li>
     *   <li>LegCouponFrequencyUnit(2164)</li>
     *   <li>AdditionalTermBondCouponFrequencyUnit(40017)</li>
     *   <li>StreamCalculationFrequencyUnit(40083)</li>
     *   <li>ProvisionOptionExerciseFrequencyUnit(40128)</li>
     *   <li>LegStreamCalculationFrequencyUnit(40275)</li>
     *   <li>LegPaymentStreamResetFrequencyUnit(40307)</li>
     *   <li>LegPaymentScheduleStepFrequencyUnit(40391)</li>
     *   <li>LegProvisionOptionExerciseFrequencyUnit(40481)</li>
     *   <li>UnderlyingStreamCalculationFrequencyUnit(40566)</li>
     *   <li>UnderlyingPaymentStreamResetFrequencyUnit(40596)</li>
     *   <li>UnderlyingPaymentScheduleStepFrequencyUnit(40681)</li>
     *   <li>PaymentStreamResetFrequencyUnit(40765)</li>
     *   <li>PaymentScheduleStepFrequencyUnit(40845)</li>
     *   <li>LegAdditionalTermBondCouponFrequencyUnit(41333)</li>
     *   <li>UnderlyingAdditionalTermBondCouponFrequencyUnit(42034)</li>
     *   <li>UnderlyingProvisionOptionExerciseFrequencyUnit(42119)</li>
     *   <li>LegPaymentStreamCompoundingFrequencyUnit(42415)</li>
     *   <li>LegReturnRateValuationFrequencyUnit(42527)</li>
     *   <li>PaymentStreamCompoundingFrequencyUnit(42616)</li>
     *   <li>ReturnRateValuationFrequencyUnit(42728)</li>
     *   <li>UnderlyingPaymentStreamCompoundingFrequencyUnit(42911)</li>
     *   <li>UnderlyingReturnRateValuationFrequencyUnit(43027)</li>
     * </ul>
     */
    public static class CouponFrequencyUnitValues {

        public static final String Day    = "D";
        public static final String Week   = "Wk";
        public static final String Month  = "Mo";
        public static final String Year   = "Yr";
        public static final String Hour   = "H";
        public static final String Minute = "Min";
        public static final String Second = "S";
        public static final String Term   = "T";

        private CouponFrequencyUnitValues() {
        }

    }

    /**
     * Values for CouponDayCount(1950).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingCouponDayCount(1993)</li>
     *   <li>LegCouponDayCount(2165)</li>
     *   <li>AdditionalTermBondDayCount(40018)</li>
     *   <li>LegPaymentStreamDayCount(40283)</li>
     *   <li>LegPaymentStreamDiscountRateDayCount(40287)</li>
     *   <li>UnderlyingPaymentStreamDayCount(40572)</li>
     *   <li>UnderlyingPaymentStreamDiscountRateDayCount(40576)</li>
     *   <li>PaymentStreamDayCount(40742)</li>
     *   <li>PaymentStreamDiscountRateDayCount(40746)</li>
     *   <li>LegAdditionalTermBondDayCount(41334)</li>
     *   <li>UnderlyingAdditionalTermBondDayCount(42035)</li>
     * </ul>
     */
    public static class CouponDayCountValues {

        public static final int OneOne                 = 0;
        public static final int ThirtyThreeSixtyUS     = 1;
        public static final int ThirtyThreeSixtySIA    = 2;
        public static final int ThirtyThreeSixtyM      = 3;
        public static final int ThirtyEThreeSixty      = 4;
        public static final int ThirtyEThreeSixtyISDA  = 5;
        public static final int ActThreeSixty          = 6;
        public static final int ActThreeSixtyFiveFixed = 7;
        public static final int ActActAFB              = 8;
        public static final int ActActICMA             = 9;
        public static final int ActActISMAUltimo       = 10;
        public static final int ActActISDA             = 11;
        public static final int BusTwoFiftyTwo         = 12;
        public static final int ThirtyEPlusThreeSixty  = 13;
        public static final int ActThreeSixtyFiveL     = 14;
        public static final int NLThreeSixtyFive       = 15;
        public static final int NLThreeSixty           = 16;
        public static final int Act364                 = 17;
        public static final int ThirtyThreeSixtyFive   = 18;
        public static final int ThirtyActual           = 19;
        public static final int ThirtyThreeSixtyICMA   = 20;
        public static final int ThirtyETwoThreeSixty   = 21;
        public static final int ThirtyEThreeThreeSixty = 22;
        public static final int Other                  = 99;

        private CouponDayCountValues() {
        }

    }

    /**
     * Values for LienSeniority(1954).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingLienSeniority(1998)</li>
     *   <li>LegLienSeniority(2169)</li>
     * </ul>
     */
    public static class LienSeniorityValues {

        public static final int Unknown    = 0;
        public static final int FirstLien  = 1;
        public static final int SecondLien = 2;
        public static final int ThirdLien  = 3;

        private LienSeniorityValues() {
        }

    }

    /**
     * Values for LoanFacility(1955).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingLoanFacility(1999)</li>
     *   <li>LegLoanFacility(2170)</li>
     * </ul>
     */
    public static class LoanFacilityValues {

        public static final int BridgeLoan       = 0;
        public static final int LetterOfCredit   = 1;
        public static final int RevolvingLoan    = 2;
        public static final int SwinglineFunding = 3;
        public static final int TermLoan         = 4;
        public static final int TradeClaim       = 5;

        private LoanFacilityValues() {
        }

    }

    /**
     * Values for ReferenceEntityType(1956).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingReferenceEntityType(2000)</li>
     *   <li>LegReferenceEntityType(2171)</li>
     * </ul>
     */
    public static class ReferenceEntityTypeValues {

        public static final int Asian                        = 1;
        public static final int AustralianNewZealand         = 2;
        public static final int EuropeanEmergingMarkets      = 3;
        public static final int Japanese                     = 4;
        public static final int NorthAmericanHighYield       = 5;
        public static final int NorthAmericanInsurance       = 6;
        public static final int NorthAmericanInvestmentGrade = 7;
        public static final int Singaporean                  = 8;
        public static final int WesternEuropean              = 9;
        public static final int WesternEuropeanInsurance     = 10;

        private ReferenceEntityTypeValues() {
        }

    }

    /**
     * Values for BlockTrdAllocIndicator(1980).
     */
    public static class BlockTrdAllocIndicatorValues {

        public static final int BlockToBeAllocated    = 0;
        public static final int BlockNotToBeAllocated = 1;
        public static final int AllocatedTrade        = 2;

        private BlockTrdAllocIndicatorValues() {
        }

    }

    /**
     * Values for UnderlyingObligationType(2012).
     */
    public static class UnderlyingObligationTypeValues {

        public static final String Bond            = "0";
        public static final String ConvertibleBond = "1";
        public static final String Mortgage        = "2";
        public static final String Loan            = "3";

        private UnderlyingObligationTypeValues() {
        }

    }

    /**
     * Values for AttachmentEncodingType(2109).
     */
    public static class AttachmentEncodingTypeValues {

        public static final int Base64    = 0;
        public static final int RawBinary = 1;

        private AttachmentEncodingTypeValues() {
        }

    }

    /**
     * Values for NegotiationMethod(2115).
     */
    public static class NegotiationMethodValues {

        public static final int AutoSpot       = 0;
        public static final int NegotiatedSpot = 1;
        public static final int PhoneSpot      = 2;

        private NegotiationMethodValues() {
        }

    }

    /**
     * Values for ComplexOptPayoutTime(2121).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegComplexOptPayoutTime(2225)</li>
     *   <li>UnderlyingComplexOptPayoutTime(2265)</li>
     * </ul>
     */
    public static class ComplexOptPayoutTimeValues {

        public static final int Close             = 0;
        public static final int Open              = 1;
        public static final int OfficialSettl     = 2;
        public static final int ValuationTime     = 3;
        public static final int ExcahgneSettlTime = 4;
        public static final int DerivativesClose  = 5;
        public static final int AsSpecified       = 6;

        private ComplexOptPayoutTimeValues() {
        }

    }

    /**
     * Values for ComplexEventQuoteBasis(2126).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegComplexEventQuoteBasis(2235)</li>
     *   <li>UnderlyingComplexEventQuoteBasis(2270)</li>
     * </ul>
     */
    public static class ComplexEventQuoteBasisValues {

        public static final int Currency1PerCurrency2 = 0;
        public static final int Currency2PerCurrency1 = 1;

        private ComplexEventQuoteBasisValues() {
        }

    }

    /**
     * Values for ComplexEventCreditEventNotifyingParty(2134).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegComplexEventCreditEventNotifyingParty(2243)</li>
     *   <li>UnderlyingComplexEventCreditEventNotifyingParty(2278)</li>
     * </ul>
     */
    public static class ComplexEventCreditEventNotifyingPartyValues {

        public static final int SellerNotifies        = 0;
        public static final int BuyerNotifies         = 1;
        public static final int SellerOrBuyerNotifies = 2;

        private ComplexEventCreditEventNotifyingPartyValues() {
        }

    }

    /**
     * Values for StrategyType(2141).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegStrategyType(2211)</li>
     *   <li>UnderlyingStrategyType(2295)</li>
     * </ul>
     */
    public static class StrategyTypeValues {

        public static final String Straddle                   = "STD";
        public static final String Strangle                   = "STG";
        public static final String Butterfly                  = "BF";
        public static final String Condor                     = "CNDR";
        public static final String CallableInversibleSnowball = "CISN";
        public static final String Other                      = "OTHER";

        private StrategyTypeValues() {
        }

    }

    /**
     * Values for SettlDisruptionProvision(2143).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegSettlDisruptionProvision(2213)</li>
     *   <li>UnderlyingSettlDisruptionProvision(2297)</li>
     * </ul>
     */
    public static class SettlDisruptionProvisionValues {

        public static final int Negotiation  = 1;
        public static final int Cancellation = 2;

        private SettlDisruptionProvisionValues() {
        }

    }

    /**
     * Values for AssetGroup(2210).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegAssetGroup(2348)</li>
     *   <li>UnderlyingAssetGroup(2491)</li>
     * </ul>
     */
    public static class AssetGroupValues {

        public static final int Financials             = 1;
        public static final int Commodities            = 2;
        public static final int AlternativeInvestments = 3;

        private AssetGroupValues() {
        }

    }

    /**
     * Values for RiskLimitReportStatus(2316).
     */
    public static class RiskLimitReportStatusValues {

        public static final int Accepted = 0;
        public static final int Rejected = 1;

        private RiskLimitReportStatusValues() {
        }

    }

    /**
     * Values for RiskLimitReportRejectReason(2317).
     */
    public static class RiskLimitReportRejectReasonValues {

        public static final int UnkRiskLmtRprtID = 0;
        public static final int UnkPty           = 1;
        public static final int Other            = 99;

        private RiskLimitReportRejectReasonValues() {
        }

    }

    /**
     * Values for RiskLimitCheckTransType(2320).
     */
    public static class RiskLimitCheckTransTypeValues {

        public static final int New     = 0;
        public static final int Cancel  = 1;
        public static final int Replace = 2;

        private RiskLimitCheckTransTypeValues() {
        }

    }

    /**
     * Values for RiskLimitCheckType(2321).
     */
    public static class RiskLimitCheckTypeValues {

        public static final int Submit        = 0;
        public static final int LimitConsumed = 1;

        private RiskLimitCheckTypeValues() {
        }

    }

    /**
     * Values for RiskLimitCheckRequestType(2323).
     */
    public static class RiskLimitCheckRequestTypeValues {

        public static final int AllOrNone = 0;
        public static final int Partial   = 1;

        private RiskLimitCheckRequestTypeValues() {
        }

    }

    /**
     * Values for RiskLimitCheckRequestStatus(2325).
     */
    public static class RiskLimitCheckRequestStatusValues {

        public static final int Approved          = 0;
        public static final int PartiallyApproved = 1;
        public static final int Rejected          = 2;
        public static final int ApprovalPending   = 3;
        public static final int Cancelled         = 4;

        private RiskLimitCheckRequestStatusValues() {
        }

    }

    /**
     * Values for RiskLimitCheckRequestResult(2326).
     */
    public static class RiskLimitCheckRequestResultValues {

        public static final int Successful              = 0;
        public static final int InvalidParty            = 1;
        public static final int ReqExceedsCreditLimit   = 2;
        public static final int ReqExceedsClipSizeLimit = 3;
        public static final int ReqExceedsMaxNotional   = 4;
        public static final int Other                   = 99;

        private RiskLimitCheckRequestResultValues() {
        }

    }

    /**
     * Values for PartyActionType(2329).
     */
    public static class PartyActionTypeValues {

        public static final int Suspend     = 0;
        public static final int HaltTrading = 1;
        public static final int Reinstate   = 2;

        private PartyActionTypeValues() {
        }

    }

    /**
     * Values for PartyActionResponse(2332).
     */
    public static class PartyActionResponseValues {

        public static final int Accepted  = 0;
        public static final int Completed = 1;
        public static final int Rejected  = 2;

        private PartyActionResponseValues() {
        }

    }

    /**
     * Values for PartyActionRejectReason(2333).
     */
    public static class PartyActionRejectReasonValues {

        public static final int InvalidParty  = 0;
        public static final int UnkReqParty   = 1;
        public static final int NotAuthorized = 98;
        public static final int Other         = 99;

        private PartyActionRejectReasonValues() {
        }

    }

    /**
     * Values for RefRiskLimitCheckIDType(2335).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>AllocRefRiskLimitCheckIDType(2393)</li>
     * </ul>
     */
    public static class RefRiskLimitCheckIDTypeValues {

        public static final int RiskLimitRequestID = 0;
        public static final int RiskLimitCheckID   = 1;
        public static final int OutOfBandID        = 3;

        private RefRiskLimitCheckIDTypeValues() {
        }

    }

    /**
     * Values for RiskLimitCheckModelType(2339).
     */
    public static class RiskLimitCheckModelTypeValues {

        public static final int None         = 0;
        public static final int PlusOneModel = 1;
        public static final int PingModel    = 2;
        public static final int PushModel    = 3;

        private RiskLimitCheckModelTypeValues() {
        }

    }

    /**
     * Values for RiskLimitCheckStatus(2343).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SideRiskLimitCheckStatus(2344)</li>
     *   <li>AllocRiskLimitCheckStatus(2483)</li>
     * </ul>
     */
    public static class RiskLimitCheckStatusValues {

        public static final int Accepted                        = 0;
        public static final int Rejected                        = 1;
        public static final int ClaimRequired                   = 2;
        public static final int PreDefinedLimitCheckSucceeded   = 3;
        public static final int PreDefinedLimitCheckFailed      = 4;
        public static final int PreDefinedAutoAcceptRuleInvoked = 5;
        public static final int PreDefinedAutoRejectRuleInvoked = 6;
        public static final int AcceptedByClearingFirm          = 7;
        public static final int RejectedByClearingFirm          = 8;
        public static final int Pending                         = 9;
        public static final int AcceptedByCreditHub             = 10;
        public static final int RejectedByCreditHub             = 11;
        public static final int PendingCreditHubCheck           = 12;
        public static final int AcceptedByExecVenue             = 13;
        public static final int RejectedByExecVenue             = 14;

        private RiskLimitCheckStatusValues() {
        }

    }

    /**
     * Values for RegulatoryTransactionType(2347).
     */
    public static class RegulatoryTransactionTypeValues {

        public static final int None                    = 0;
        public static final int SEFRequiredTransaction  = 1;
        public static final int SEFPermittedTransaction = 2;

        private RegulatoryTransactionTypeValues() {
        }

    }

    /**
     * Values for PartyRiskLimitStatus(2355).
     */
    public static class PartyRiskLimitStatusValues {

        public static final int Disabled = 0;
        public static final int Enabled  = 1;

        private PartyRiskLimitStatusValues() {
        }

    }

    /**
     * Values for RemunerationIndicator(2356).
     */
    public static class RemunerationIndicatorValues {

        public static final int NoRemunerationPaid = 0;
        public static final int RemunerationPaid   = 1;

        private RemunerationIndicatorValues() {
        }

    }

    /**
     * Values for TaxonomyType(2375).
     */
    public static class TaxonomyTypeValues {

        public static final char ISINOrAltInstrmtID = 'I';
        public static final char InterimTaxonomy    = 'E';

        private TaxonomyTypeValues() {
        }

    }

    /**
     * Values for TradeContingency(2387).
     */
    public static class TradeContingencyValues {

        public static final int DoesNotApply       = 0;
        public static final int ContingentTrade    = 1;
        public static final int NonContingentTrade = 2;

        private TradeContingencyValues() {
        }

    }

    /**
     * Values for RegulatoryTradeIDScope(2397).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SideRegulatoryTradeIDScope(2398)</li>
     *   <li>AllocRegulatoryTradeIDScope(2399)</li>
     * </ul>
     */
    public static class RegulatoryTradeIDScopeValues {

        public static final int ClearingMember = 1;
        public static final int Client         = 2;

        private RegulatoryTradeIDScopeValues() {
        }

    }

    /**
     * Values for EntitlementSubType(2402).
     */
    public static class EntitlementSubTypeValues {

        public static final int OrderEntry       = 1;
        public static final int HItLift          = 2;
        public static final int ViewIndicativePx = 3;
        public static final int ViewExecutablePx = 4;
        public static final int SingleQuote      = 5;
        public static final int StreamingQuotes  = 6;
        public static final int SingleBroker     = 7;
        public static final int MultiBrokers     = 8;

        private EntitlementSubTypeValues() {
        }

    }

    /**
     * Values for QuoteModelType(2403).
     */
    public static class QuoteModelTypeValues {

        public static final int QuoteEntry        = 1;
        public static final int QuoteModification = 2;

        private QuoteModelTypeValues() {
        }

    }

    /**
     * Values for ExecMethod(2405).
     */
    public static class ExecMethodValues {

        public static final int Unspecified   = 0;
        public static final int Manual        = 1;
        public static final int Automated     = 2;
        public static final int VoiceBrokered = 3;

        private ExecMethodValues() {
        }

    }

    /**
     * Values for MassOrderRequestStatus(2425).
     */
    public static class MassOrderRequestStatusValues {

        public static final int Accepted                     = 1;
        public static final int AcceptedWithAdditionalEvents = 2;
        public static final int Rejected                     = 3;

        private MassOrderRequestStatusValues() {
        }

    }

    /**
     * Values for MassOrderRequestResult(2426).
     */
    public static class MassOrderRequestResultValues {

        public static final int Successful                = 0;
        public static final int ResponseLevelNotSupported = 1;
        public static final int InvalidMarket             = 2;
        public static final int InvalidMarketSegment      = 3;
        public static final int Other                     = 99;

        private MassOrderRequestResultValues() {
        }

    }

    /**
     * Values for OrderResponseLevel(2427).
     */
    public static class OrderResponseLevelValues {

        public static final int NoAck      = 0;
        public static final int MinimumAck = 1;
        public static final int AckEach    = 2;
        public static final int SummaryAck = 3;

        private OrderResponseLevelValues() {
        }

    }

    /**
     * Values for OrderEntryAction(2429).
     */
    public static class OrderEntryActionValues {

        public static final char Add     = '1';
        public static final char Modify  = '2';
        public static final char Delete  = '3';
        public static final char Suspend = '4';
        public static final char Release = '5';

        private OrderEntryActionValues() {
        }

    }

    /**
     * Values for ExecTypeReason(2431).
     */
    public static class ExecTypeReasonValues {

        public static final int OrdAddedOnRequest                     = 1;
        public static final int OrdReplacedOnRequest                  = 2;
        public static final int OrdCxldOnRequest                      = 3;
        public static final int UnsolicitedOrdCxl                     = 4;
        public static final int NonRestingOrdAddedOnRequest           = 5;
        public static final int OrdReplacedWithNonRestingOrdOnRequest = 6;
        public static final int TriggerOrdReplacedOnRequest           = 7;
        public static final int SuspendedOrdReplacedOnRequest         = 8;
        public static final int SuspendedOrdCxldOnRequest             = 9;
        public static final int OrdCxlPending                         = 10;
        public static final int PendingCxlExecuted                    = 11;
        public static final int RestingOrdTriggered                   = 12;
        public static final int SuspendedOrdActivated                 = 13;
        public static final int ActiveOrdSuspended                    = 14;
        public static final int OrdExpired                            = 15;

        private ExecTypeReasonValues() {
        }

    }

    /**
     * Values for TransferTransType(2439).
     */
    public static class TransferTransTypeValues {

        public static final int New     = 0;
        public static final int Replace = 1;
        public static final int Cancel  = 2;

        private TransferTransTypeValues() {
        }

    }

    /**
     * Values for TransferType(2440).
     */
    public static class TransferTypeValues {

        public static final int RequestTransfer = 0;
        public static final int AcceptTransfer  = 1;
        public static final int DeclineTransfer = 2;

        private TransferTypeValues() {
        }

    }

    /**
     * Values for TransferScope(2441).
     */
    public static class TransferScopeValues {

        public static final int InterFirmTransfer = 0;
        public static final int IntraFirmTransfer = 1;
        public static final int CMTA              = 2;

        private TransferScopeValues() {
        }

    }

    /**
     * Values for TransferStatus(2442).
     */
    public static class TransferStatusValues {

        public static final int Received               = 0;
        public static final int RejectedByIntermediary = 1;
        public static final int AcceptPending          = 2;
        public static final int Accepted               = 3;
        public static final int Declined               = 4;
        public static final int Cancelled              = 5;

        private TransferStatusValues() {
        }

    }

    /**
     * Values for TransferRejectReason(2443).
     */
    public static class TransferRejectReasonValues {

        public static final int Success                  = 0;
        public static final int InvalidParty             = 1;
        public static final int UnknownInstrument        = 2;
        public static final int UnauthorizedToSubmitXfer = 3;
        public static final int UnknownPosition          = 4;
        public static final int Other                    = 99;

        private TransferRejectReasonValues() {
        }

    }

    /**
     * Values for TransferReportType(2444).
     */
    public static class TransferReportTypeValues {

        public static final int Submit  = 0;
        public static final int Alleged = 1;

        private TransferReportTypeValues() {
        }

    }

    /**
     * Values for MDStatisticType(2456).
     */
    public static class MDStatisticTypeValues {

        public static final int Count                      = 1;
        public static final int AverageVolume              = 2;
        public static final int TotalVolume                = 3;
        public static final int Distribution               = 4;
        public static final int Ratio                      = 5;
        public static final int Liquidity                  = 6;
        public static final int VWAP                       = 7;
        public static final int Volatility                 = 8;
        public static final int Duration                   = 9;
        public static final int Tick                       = 10;
        public static final int AverageValue               = 11;
        public static final int TotalValue                 = 12;
        public static final int High                       = 13;
        public static final int Low                        = 14;
        public static final int Midpoint                   = 15;
        public static final int First                      = 16;
        public static final int Last                       = 17;
        public static final int Final                      = 18;
        public static final int ExchangeBest               = 19;
        public static final int ExchangeBestWithVolume     = 20;
        public static final int ConsolidatedBest           = 21;
        public static final int ConsolidatedBestWithVolume = 22;
        public static final int TWAP                       = 23;
        public static final int AverageDuration            = 24;
        public static final int AveragePrice               = 25;
        public static final int TotalFees                  = 26;
        public static final int TotalBenefits              = 27;
        public static final int MedianValue                = 28;
        public static final int AverageLiquidity           = 29;
        public static final int MedianDuration             = 30;

        private MDStatisticTypeValues() {
        }

    }

    /**
     * Values for MDStatisticScope(2457).
     */
    public static class MDStatisticScopeValues {

        public static final int BidPrices            = 1;
        public static final int OfferPrices          = 2;
        public static final int BidDepth             = 3;
        public static final int OfferDepth           = 4;
        public static final int Orders               = 5;
        public static final int Quotes               = 6;
        public static final int OrdersAndQuotes      = 7;
        public static final int Trades               = 8;
        public static final int TradePrices          = 9;
        public static final int AuctionPrices        = 10;
        public static final int OpeningPrices        = 11;
        public static final int ClosingPrices        = 12;
        public static final int SettlementPrices     = 13;
        public static final int UnderlyingPrices     = 14;
        public static final int OpenInterest         = 15;
        public static final int IndexValues          = 16;
        public static final int MarginRates          = 17;
        public static final int Outages              = 18;
        public static final int ScheduledAuctions    = 19;
        public static final int ReferencePrices      = 20;
        public static final int TradeValue           = 21;
        public static final int MarketDataFeeItems   = 22;
        public static final int Rebates              = 23;
        public static final int Discounts            = 24;
        public static final int Payments             = 25;
        public static final int Taxes                = 26;
        public static final int Levies               = 27;
        public static final int Benefits             = 28;
        public static final int Fees                 = 29;
        public static final int OrdersRFQs           = 30;
        public static final int MarketMakers         = 31;
        public static final int TradingInterruptions = 32;
        public static final int TradingSuspensions   = 33;
        public static final int NoQuotes             = 34;
        public static final int RequestForQuotes     = 35;
        public static final int TradeVolume          = 36;

        private MDStatisticScopeValues() {
        }

    }

    /**
     * Values for MDStatisticSubScope(2458).
     */
    public static class MDStatisticSubScopeValues {

        public static final int Visible                      = 1;
        public static final int Hidden                       = 2;
        public static final int Indicative                   = 3;
        public static final int Tradeable                    = 4;
        public static final int Passive                      = 5;
        public static final int MarketConsensus              = 6;
        public static final int Power                        = 7;
        public static final int HardwareError                = 8;
        public static final int SoftwareError                = 9;
        public static final int NetworkError                 = 10;
        public static final int Failed                       = 11;
        public static final int Executed                     = 12;
        public static final int Entered                      = 13;
        public static final int Modified                     = 14;
        public static final int Cancelled                    = 15;
        public static final int MarketDataAccess             = 16;
        public static final int TerminalAccess               = 17;
        public static final int Volume                       = 18;
        public static final int Cleared                      = 19;
        public static final int Settled                      = 20;
        public static final int Other                        = 21;
        public static final int Monetary                     = 22;
        public static final int NonMonetary                  = 23;
        public static final int Gross                        = 24;
        public static final int LargeInScale                 = 25;
        public static final int NeitherHiddenNorLargeInScale = 26;
        public static final int CorporateAction              = 27;
        public static final int VenueDecision                = 28;
        public static final int MinimumTimePeriod            = 29;
        public static final int Open                         = 30;
        public static final int NotExecuted                  = 31;
        public static final int Aggressive                   = 32;
        public static final int Directed                     = 33;

        private MDStatisticSubScopeValues() {
        }

    }

    /**
     * Values for MDStatisticScopeType(2459).
     */
    public static class MDStatisticScopeTypeValues {

        public static final int EntryRate        = 1;
        public static final int ModificationRate = 2;
        public static final int CancelRate       = 3;
        public static final int DownwardMove     = 4;
        public static final int UpwardMove       = 5;

        private MDStatisticScopeTypeValues() {
        }

    }

    /**
     * Values for MDStatisticIntervalType(2464).
     */
    public static class MDStatisticIntervalTypeValues {

        public static final int SlidingWindow                    = 1;
        public static final int SlidingWindowPeak                = 2;
        public static final int FixedDateRange                   = 3;
        public static final int FixedTimeRange                   = 4;
        public static final int CurrentTimeUnit                  = 5;
        public static final int PreviousTimeUnit                 = 6;
        public static final int MaximumRange                     = 7;
        public static final int MaximumRangeUpToPreviousTimeUnit = 8;

        private MDStatisticIntervalTypeValues() {
        }

    }

    /**
     * Values for MDStatisticRatioType(2472).
     */
    public static class MDStatisticRatioTypeValues {

        public static final int BuyersToSellers                = 1;
        public static final int UpticksToDownticks             = 2;
        public static final int MarketMakerToNonMarketMaker    = 3;
        public static final int AutomatedToNonAutomated        = 4;
        public static final int OrdersToTrades                 = 5;
        public static final int QuotesToTrades                 = 6;
        public static final int OrdersAndQuotesToTrades        = 7;
        public static final int FailedToTotalTradedValue       = 8;
        public static final int BenefitsToTotalTradedValue     = 9;
        public static final int FeesToTotalTradedValue         = 10;
        public static final int TradeVolumeToTotalTradedVolume = 11;
        public static final int OrdersToTotalNumberOrders      = 12;

        private MDStatisticRatioTypeValues() {
        }

    }

    /**
     * Values for MDStatisticRequestResult(2473).
     */
    public static class MDStatisticRequestResultValues {

        public static final int Successful                       = 0;
        public static final int InvalidOrUnknownMarket           = 1;
        public static final int InvalidOrUnknownMarketSegment    = 2;
        public static final int InvalidOrUnknownSecurityList     = 3;
        public static final int InvalidOrUnknownInstruments      = 4;
        public static final int InvalidParties                   = 5;
        public static final int TradeDateOutOfSupportedRange     = 6;
        public static final int UnsupportedStatisticType         = 7;
        public static final int UnsupportedScopeOrSubScope       = 8;
        public static final int UnsupportedScopeType             = 9;
        public static final int MarketDepthNotSupported          = 10;
        public static final int FrequencyNotSupported            = 11;
        public static final int UnsupportedStatisticInterval     = 12;
        public static final int UnsupportedStatisticDateRange    = 13;
        public static final int UnsupportedStatisticTimeRange    = 14;
        public static final int UnsupportedRatioType             = 15;
        public static final int InvalidOrUnknownTradeInputSource = 16;
        public static final int InvalidOrUnknownTradingSession   = 17;
        public static final int UnauthorizedForStatisticRequest  = 18;
        public static final int Other                            = 99;

        private MDStatisticRequestResultValues() {
        }

    }

    /**
     * Values for MDStatisticStatus(2477).
     */
    public static class MDStatisticStatusValues {

        public static final int Active   = 1;
        public static final int Inactive = 2;

        private MDStatisticStatusValues() {
        }

    }

    /**
     * Values for MDStatisticValueType(2479).
     */
    public static class MDStatisticValueTypeValues {

        public static final int Absolute   = 1;
        public static final int Percentage = 2;

        private MDStatisticValueTypeValues() {
        }

    }

    /**
     * Values for CollRptRejectReason(2487).
     */
    public static class CollRptRejectReasonValues {

        public static final int UnknownTrade           = 0;
        public static final int UnknownInstrument      = 1;
        public static final int UnknownCounterparty    = 2;
        public static final int UnknownPosition        = 3;
        public static final int UnacceptableCollateral = 4;
        public static final int Other                  = 99;

        private CollRptRejectReasonValues() {
        }

    }

    /**
     * Values for CollRptStatus(2488).
     */
    public static class CollRptStatusValues {

        public static final int Accepted = 0;
        public static final int Received = 1;
        public static final int Rejected = 2;

        private CollRptStatusValues() {
        }

    }

    /**
     * Values for CrossedIndicator(2523).
     */
    public static class CrossedIndicatorValues {

        public static final int NoCross       = 0;
        public static final int CrossRejected = 1;
        public static final int CrossAccepted = 2;

        private CrossedIndicatorValues() {
        }

    }

    /**
     * Values for TradeReportingIndicator(2524).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SideTradeReportingIndicator(2671)</li>
     * </ul>
     */
    public static class TradeReportingIndicatorValues {

        public static final int NotReported         = 0;
        public static final int OnBook              = 1;
        public static final int SISeller            = 2;
        public static final int SIBuyer             = 3;
        public static final int NonSISeller         = 4;
        public static final int SubDelegationByFirm = 5;
        public static final int Reportable          = 6;
        public static final int NonSIBuyer          = 7;
        public static final int OffBook             = 8;
        public static final int NotReportable       = 9;

        private TradeReportingIndicatorValues() {
        }

    }

    /**
     * Values for RelativeValueType(2530).
     */
    public static class RelativeValueTypeValues {

        public static final int ASWSpread            = 1;
        public static final int OIS                  = 2;
        public static final int ZSpread              = 3;
        public static final int DiscountMargin       = 4;
        public static final int ISpread              = 5;
        public static final int OAS                  = 6;
        public static final int GSpread              = 7;
        public static final int CDSBasis             = 8;
        public static final int CDSInterpolatedBasis = 9;
        public static final int DV01                 = 10;
        public static final int PV01                 = 11;
        public static final int CS01                 = 12;

        private RelativeValueTypeValues() {
        }

    }

    /**
     * Values for RelativeValueSide(2532).
     */
    public static class RelativeValueSideValues {

        public static final int Bid   = 1;
        public static final int Mid   = 2;
        public static final int Offer = 3;

        private RelativeValueSideValues() {
        }

    }

    /**
     * Values for MDReportEvent(2535).
     */
    public static class MDReportEventValues {

        public static final int StartInstrumentRefData = 1;
        public static final int EndInstrumentRefData   = 2;
        public static final int StartOffMarketTrades   = 3;
        public static final int EndOffMarketTrades     = 4;
        public static final int StartOrderBookTrades   = 5;
        public static final int EndOrderBookTrades     = 6;
        public static final int StartOpenInterest      = 7;
        public static final int EndOpenInterest        = 8;
        public static final int StartSettlementPrices  = 9;
        public static final int EndSettlementPrices    = 10;
        public static final int StartStatsRefData      = 11;
        public static final int EndStatsRefData        = 12;
        public static final int StartStatistics        = 13;
        public static final int EndStatistics          = 14;

        private MDReportEventValues() {
        }

    }

    /**
     * Values for MarketSegmentStatus(2542).
     */
    public static class MarketSegmentStatusValues {

        public static final int Active    = 1;
        public static final int Inactive  = 2;
        public static final int Published = 3;

        private MarketSegmentStatusValues() {
        }

    }

    /**
     * Values for MarketSegmentType(2543).
     */
    public static class MarketSegmentTypeValues {

        public static final int Pool      = 1;
        public static final int Retail    = 2;
        public static final int Wholesale = 3;

        private MarketSegmentTypeValues() {
        }

    }

    /**
     * Values for MarketSegmentSubType(2544).
     */
    public static class MarketSegmentSubTypeValues {

        public static final int InterProductSpread = 1;

        private MarketSegmentSubTypeValues() {
        }

    }

    /**
     * Values for MarketSegmentRelationship(2547).
     */
    public static class MarketSegmentRelationshipValues {

        public static final int MarketSegmentPoolMember = 1;
        public static final int RetailSegment           = 2;
        public static final int WholesaleSegment        = 3;

        private MarketSegmentRelationshipValues() {
        }

    }

    /**
     * Values for CustomerPriority(2570).
     */
    public static class CustomerPriorityValues {

        public static final int NoPriority            = 0;
        public static final int UnconditionalPriority = 1;

        private CustomerPriorityValues() {
        }

    }

    /**
     * Values for SettlSubMethod(2579).
     */
    public static class SettlSubMethodValues {

        public static final int Shares           = 1;
        public static final int Derivatives      = 2;
        public static final int PaymentVsPayment = 3;
        public static final int Notional         = 4;
        public static final int Cascade          = 5;
        public static final int Repurchase       = 6;
        public static final int Other            = 99;

        private SettlSubMethodValues() {
        }

    }

    /**
     * Values for CalculationMethod(2592).
     */
    public static class CalculationMethodValues {

        public static final int Automatic = 0;
        public static final int Manual    = 1;

        private CalculationMethodValues() {
        }

    }

    /**
     * Values for OrderAttributeType(2594).
     */
    public static class OrderAttributeTypeValues {

        public static final int AggregatedOrder                  = 0;
        public static final int PendingAllocation                = 1;
        public static final int LiquidityProvisionActivityOrder  = 2;
        public static final int RiskReductionOrder               = 3;
        public static final int AlgorithmicOrder                 = 4;
        public static final int SystematicInternaliserOrder      = 5;
        public static final int AllExecutionsSubmittedToAPA      = 6;
        public static final int OrderExecutionInstructedByClient = 7;
        public static final int LargeInScale                     = 8;
        public static final int Hidden                           = 9;
        public static final int SubjectToEUSTO                   = 10;
        public static final int SubjectToUKSTO                   = 11;
        public static final int RepresentativeOrder              = 12;
        public static final int LinkageType                      = 13;
        public static final int ExemptFromSTO                    = 14;

        private OrderAttributeTypeValues() {
        }

    }

    /**
     * Values for ComplexEventPVFinalPriceElectionFallback(2599).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegComplexEventPVFinalPriceElectionFallback(2610)</li>
     *   <li>UnderlyingComplexEventPVFinalPriceElectionFallback(2613)</li>
     *   <li>LegReturnRateFinalPriceFallback(42559)</li>
     *   <li>ReturnRateFinalPriceFallback(42760)</li>
     *   <li>UnderlyingReturnRateFinalPriceFallback(43059)</li>
     * </ul>
     */
    public static class ComplexEventPVFinalPriceElectionFallbackValues {

        public static final int Close         = 0;
        public static final int HedgeElection = 1;

        private ComplexEventPVFinalPriceElectionFallbackValues() {
        }

    }

    /**
     * Values for StrikeIndexQuote(2601).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegStrikeIndexQuote(2605)</li>
     *   <li>UnderlyingStrikeIndexQuote(2623)</li>
     *   <li>LegMakeWholeBenchmarkQuote(42397)</li>
     *   <li>MakeWholeBenchmarkQuote(42596)</li>
     *   <li>UnderlyingMakeWholeBenchmarkQuote(42893)</li>
     * </ul>
     */
    public static class StrikeIndexQuoteValues {

        public static final int Bid   = 0;
        public static final int Mid   = 1;
        public static final int Offer = 2;

        private StrikeIndexQuoteValues() {
        }

    }

    /**
     * Values for ExtraordinaryEventAdjustmentMethod(2602).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegExtraordinaryEventAdjustmentMethod(2606)</li>
     *   <li>UnderlyingExtraordinaryEventAdjustmentMethod(2624)</li>
     * </ul>
     */
    public static class ExtraordinaryEventAdjustmentMethodValues {

        public static final int CalculationAgent = 0;
        public static final int OptionsExchange  = 1;

        private ExtraordinaryEventAdjustmentMethodValues() {
        }

    }

    /**
     * Values for UnderlyingNotionalAdjustments(2617).
     */
    public static class UnderlyingNotionalAdjustmentsValues {

        public static final int Execution            = 0;
        public static final int PortfolioRebalancing = 1;
        public static final int Standard             = 2;

        private UnderlyingNotionalAdjustmentsValues() {
        }

    }

    /**
     * Values for CollateralAmountType(2632).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SideCollateralAmountType(2694)</li>
     * </ul>
     */
    public static class CollateralAmountTypeValues {

        public static final int MarketValuation           = 0;
        public static final int PortfolioValue            = 1;
        public static final int ValueConfirmed            = 2;
        public static final int CollateralCreditValue     = 3;
        public static final int AdditionalCollateralValue = 4;
        public static final int EstimatedMarketValuation  = 5;

        private CollateralAmountTypeValues() {
        }

    }

    /**
     * Values for CommissionAmountType(2641).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>AllocCommissionAmountType(2655)</li>
     * </ul>
     */
    public static class CommissionAmountTypeValues {

        public static final int Unspecified     = 0;
        public static final int Acceptance      = 1;
        public static final int Broker          = 2;
        public static final int ClearingBroker  = 3;
        public static final int Retail          = 4;
        public static final int SalesCommission = 5;
        public static final int LocalCommission = 6;
        public static final int ResearchPayment = 7;

        private CommissionAmountTypeValues() {
        }

    }

    /**
     * Values for AlgorithmicTradeIndicator(2667).
     */
    public static class AlgorithmicTradeIndicatorValues {

        public static final int NonAlgorithmicTrade = 0;
        public static final int AlgorithmicTrade    = 1;

        private AlgorithmicTradeIndicatorValues() {
        }

    }

    /**
     * Values for TrdRegPublicationType(2669).
     */
    public static class TrdRegPublicationTypeValues {

        public static final int PreTradeTransparencyWaiver          = 0;
        public static final int PostTradeDeferral                   = 1;
        public static final int ExemptFromPublication               = 2;
        public static final int OrderLevelPublicationToSubscribers  = 3;
        public static final int PriceLevelPublicationToSubscribers  = 4;
        public static final int OrderLevelPublicationToThePublic    = 5;
        public static final int PublicationInternalToExecutionVenue = 6;

        private TrdRegPublicationTypeValues() {
        }

    }

    /**
     * Values for TrdRegPublicationReason(2670).
     */
    public static class TrdRegPublicationReasonValues {

        public static final int NoBookOrderDueToAverageSpreadPrice               = 0;
        public static final int NoBookOrderDueToRefPrice                         = 1;
        public static final int NoBookOrderDueToOtherConditions                  = 2;
        public static final int NoPublicPriceDueToRefPrice                       = 3;
        public static final int NoPublicPriceDueToIlliquid                       = 4;
        public static final int NoPublicPriceDueToOrderSize                      = 5;
        public static final int DeferralDueToLargeInScale                        = 6;
        public static final int DeferralDueToIlliquid                            = 7;
        public static final int DeferralDueToSizeSpecific                        = 8;
        public static final int NoPublicPriceDueToLargeInScale                   = 9;
        public static final int NoPublicPriceSizeDueToOrderHidden                = 10;
        public static final int ExemptedDueToSecuritiesFinancingTransaction      = 11;
        public static final int ExemptedDueToESCBPolicyTransaction               = 12;
        public static final int ExceptionDueToReportByPaper                      = 13;
        public static final int ExceptionDueToTradeExecutedWithNonReportingParty = 14;
        public static final int ExceptionDueToIntraFirmOrder                     = 15;
        public static final int ReportedOutsideReportingHours                    = 16;

        private TrdRegPublicationReasonValues() {
        }

    }

    /**
     * Values for MassActionReason(2675).
     */
    public static class MassActionReasonValues {

        public static final int None                    = 0;
        public static final int TradingRiskControl      = 1;
        public static final int ClearingRiskControl     = 2;
        public static final int MarketMakerProtection   = 3;
        public static final int StopTrading             = 4;
        public static final int EmergencyAction         = 5;
        public static final int SessionLossLogout       = 6;
        public static final int DuplicateLogin          = 7;
        public static final int ProductNotTraded        = 8;
        public static final int InstrumentNotTraded     = 9;
        public static final int CompleInstrumentDeleted = 10;
        public static final int CircuitBreakerActivated = 11;
        public static final int Other                   = 99;

        private MassActionReasonValues() {
        }

    }

    /**
     * Values for NotAffectedReason(2677).
     */
    public static class NotAffectedReasonValues {

        public static final int OrderSuspended      = 0;
        public static final int InstrumentSuspended = 1;

        private NotAffectedReasonValues() {
        }

    }

    /**
     * Values for OrderOwnershipIndicator(2679).
     */
    public static class OrderOwnershipIndicatorValues {

        public static final int NoChange             = 0;
        public static final int ExecutingPartyChange = 1;
        public static final int EnteringPartyChange  = 2;
        public static final int SpecifiedPartyChange = 3;

        private OrderOwnershipIndicatorValues() {
        }

    }

    /**
     * Values for InTheMoneyCondition(2681).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegInTheMoneyCondition(2682)</li>
     *   <li>UnderlyingInTheMoneyCondition(2683)</li>
     *   <li>DerivativeInTheMoneyCondition(2684)</li>
     * </ul>
     */
    public static class InTheMoneyConditionValues {

        public static final int StandardITM = 0;
        public static final int ATMITM      = 1;
        public static final int ATMCallITM  = 2;
        public static final int ATMPutITM   = 3;

        private InTheMoneyConditionValues() {
        }

    }

    /**
     * Values for ExDestinationType(2704).
     */
    public static class ExDestinationTypeValues {

        public static final int NoRestriction            = 0;
        public static final int TradedOnlyOnTradingVenue = 1;
        public static final int TradedOnlyOnSI           = 2;
        public static final int TradedOnTradingVenueOrSI = 3;

        private ExDestinationTypeValues() {
        }

    }

    /**
     * Values for MarketCondition(2705).
     */
    public static class MarketConditionValues {

        public static final int Normal      = 0;
        public static final int Stressed    = 1;
        public static final int Exceptional = 2;

        private MarketConditionValues() {
        }

    }

    /**
     * Values for QuoteAttributeType(2707).
     */
    public static class QuoteAttributeTypeValues {

        public static final int QuoteAboveStandardMarketSize                = 0;
        public static final int QuoteAboveSpecificInstrumentSize            = 1;
        public static final int QuoteApplicableForLiquidtyProvisionActivity = 2;
        public static final int QuoteIssuerStatus                           = 3;
        public static final int BidOrAskRequest                             = 4;

        private QuoteAttributeTypeValues() {
        }

    }

    /**
     * Values for PriceQualifier(2710).
     */
    public static class PriceQualifierValues {

        public static final int AccruedInterestIsFactored  = 0;
        public static final int TaxIsFactored              = 1;
        public static final int BondAmortizationIsFactored = 2;

        private PriceQualifierValues() {
        }

    }

    /**
     * Values for MDValueTier(2711).
     */
    public static class MDValueTierValues {

        public static final int Range1 = 1;
        public static final int Range2 = 2;
        public static final int Range3 = 3;

        private MDValueTierValues() {
        }

    }

    /**
     * Values for MiscFeeQualifier(2712).
     */
    public static class MiscFeeQualifierValues {

        public static final int Contributes       = 0;
        public static final int DoesNotContribute = 1;

        private MiscFeeQualifierValues() {
        }

    }

    /**
     * Values for CommissionAmountSubType(2725).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>AllocCommissionAmountSubType(2726)</li>
     * </ul>
     */
    public static class CommissionAmountSubTypeValues {

        public static final int ResearchPaymentAccount     = 0;
        public static final int CommissionSharingAgreement = 1;
        public static final int OtherTypeResearchPayment   = 2;

        private CommissionAmountSubTypeValues() {
        }

    }

    /**
     * Values for CommodityFinalPriceType(2736).
     */
    public static class CommodityFinalPriceTypeValues {

        public static final int ArgusMcCloskey = 0;
        public static final int Baltic         = 1;
        public static final int Exchange       = 2;
        public static final int GlobalCoal     = 3;
        public static final int IHSMcCloskey   = 4;
        public static final int Platts         = 5;
        public static final int Other          = 99;

        private CommodityFinalPriceTypeValues() {
        }

    }

    /**
     * Values for ReferenceDataDateType(2748).
     */
    public static class ReferenceDataDateTypeValues {

        public static final int AdmitToTradeRequestDate      = 0;
        public static final int AdmitToTradeApprovalDate     = 1;
        public static final int AdmitToTradeOrFirstTradeDate = 2;
        public static final int TerminationDate              = 3;

        private ReferenceDataDateTypeValues() {
        }

    }

    /**
     * Values for ReturnTrigger(2753).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegReturnTrigger(2755)</li>
     *   <li>UnderlyingReturnTrigger(2757)</li>
     * </ul>
     */
    public static class ReturnTriggerValues {

        public static final int Dividend                         = 1;
        public static final int Variance                         = 2;
        public static final int Volatility                       = 3;
        public static final int TotalReturn                      = 4;
        public static final int ContractForDifference            = 5;
        public static final int CreditDefault                    = 6;
        public static final int SpreadBet                        = 7;
        public static final int Price                            = 8;
        public static final int ForwardPriceUnderlyingInstrument = 9;
        public static final int Other                            = 99;

        private ReturnTriggerValues() {
        }

    }

    /**
     * Values for AveragePriceType(2763).
     */
    public static class AveragePriceTypeValues {

        public static final int TimeWeightedAveragePrice    = 0;
        public static final int VolumeWeightedAveragePrice  = 1;
        public static final int PercentOfVolumeAveragePrice = 2;
        public static final int LimitOrderAveragePrice      = 3;

        private AveragePriceTypeValues() {
        }

    }

    /**
     * Values for AllocGroupStatus(2767).
     */
    public static class AllocGroupStatusValues {

        public static final int Added    = 0;
        public static final int Canceled = 1;
        public static final int Replaced = 2;
        public static final int Changed  = 3;
        public static final int Pending  = 4;

        private AllocGroupStatusValues() {
        }

    }

    /**
     * Values for AllocRequestStatus(2768).
     */
    public static class AllocRequestStatusValues {

        public static final int Accepted = 0;
        public static final int Rejected = 1;

        private AllocRequestStatusValues() {
        }

    }

    /**
     * Values for MatchExceptionType(2773).
     */
    public static class MatchExceptionTypeValues {

        public static final int NoMatchingConfirmation           = 0;
        public static final int NoMatchingAllocation             = 1;
        public static final int AllocationDataElementMissing     = 2;
        public static final int ConfirmationDataElementMissing   = 3;
        public static final int DataDifferenceNotWithinTolerance = 4;
        public static final int MatchWithinTolerance             = 5;
        public static final int Other                            = 99;

        private MatchExceptionTypeValues() {
        }

    }

    /**
     * Values for MatchExceptionElementType(2774).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>MatchingDataPointType(2784)</li>
     * </ul>
     */
    public static class MatchExceptionElementTypeValues {

        public static final int AccruedInterest             = 1;
        public static final int DealPrice                   = 2;
        public static final int TradeDate                   = 3;
        public static final int SettlementDate              = 4;
        public static final int SideIndicator               = 5;
        public static final int TradedCurrency              = 6;
        public static final int AccountID                   = 7;
        public static final int ExecutingBrokerID           = 8;
        public static final int SettlementCurrencyAndAmount = 9;
        public static final int InvestmentManagerID         = 10;
        public static final int NetAmount                   = 11;
        public static final int PlaceOfSettlement           = 12;
        public static final int Commissions                 = 13;
        public static final int SecurityIdentifier          = 14;
        public static final int QualityAllocated            = 15;
        public static final int Principal                   = 16;
        public static final int Fees                        = 17;
        public static final int Tax                         = 18;

        private MatchExceptionElementTypeValues() {
        }

    }

    /**
     * Values for MatchExceptionToleranceValueType(2779).
     */
    public static class MatchExceptionToleranceValueTypeValues {

        public static final int FixedAmount = 1;
        public static final int Percentage  = 2;

        private MatchExceptionToleranceValueTypeValues() {
        }

    }

    /**
     * Values for MatchingDataPointIndicator(2782).
     */
    public static class MatchingDataPointIndicatorValues {

        public static final int Mandatory = 1;
        public static final int Optional  = 2;

        private MatchingDataPointIndicatorValues() {
        }

    }

    /**
     * Values for TradeAggregationTransType(2788).
     */
    public static class TradeAggregationTransTypeValues {

        public static final int New     = 0;
        public static final int Cancel  = 1;
        public static final int Replace = 2;

        private TradeAggregationTransTypeValues() {
        }

    }

    /**
     * Values for TradeAggregationRequestStatus(2790).
     */
    public static class TradeAggregationRequestStatusValues {

        public static final int Accepted = 0;
        public static final int Rejected = 1;

        private TradeAggregationRequestStatusValues() {
        }

    }

    /**
     * Values for TradeAggregationRejectReason(2791).
     */
    public static class TradeAggregationRejectReasonValues {

        public static final int UnknownOrders         = 0;
        public static final int UnknownExecutionFills = 1;
        public static final int Other                 = 99;

        private TradeAggregationRejectReasonValues() {
        }

    }

    /**
     * Values for OffshoreIndicator(2795).
     */
    public static class OffshoreIndicatorValues {

        public static final int Regular  = 0;
        public static final int Offshore = 1;
        public static final int Onshore  = 2;

        private OffshoreIndicatorValues() {
        }

    }

    /**
     * Values for PayReportTransType(2804).
     */
    public static class PayReportTransTypeValues {

        public static final int New     = 0;
        public static final int Replace = 1;
        public static final int Status  = 2;

        private PayReportTransTypeValues() {
        }

    }

    /**
     * Values for PayReportStatus(2806).
     */
    public static class PayReportStatusValues {

        public static final int Received = 0;
        public static final int Accepted = 1;
        public static final int Rejected = 2;
        public static final int Disputed = 3;

        private PayReportStatusValues() {
        }

    }

    /**
     * Values for PayRequestTransType(2811).
     */
    public static class PayRequestTransTypeValues {

        public static final int New    = 0;
        public static final int Cancel = 1;

        private PayRequestTransTypeValues() {
        }

    }

    /**
     * Values for PayRequestStatus(2813).
     */
    public static class PayRequestStatusValues {

        public static final int Received = 0;
        public static final int Accepted = 1;
        public static final int Rejected = 2;
        public static final int Disputed = 3;

        private PayRequestStatusValues() {
        }

    }

    /**
     * Values for PostTradePaymentDebitOrCredit(2819).
     */
    public static class PostTradePaymentDebitOrCreditValues {

        public static final int DebitPay      = 0;
        public static final int CreditReceive = 1;

        private PostTradePaymentDebitOrCreditValues() {
        }

    }

    /**
     * Values for PostTradePaymentStatus(2823).
     */
    public static class PostTradePaymentStatusValues {

        public static final int New       = 0;
        public static final int Initiated = 1;
        public static final int Pending   = 2;
        public static final int Confirmed = 3;
        public static final int Rejected  = 4;

        private PostTradePaymentStatusValues() {
        }

    }

    /**
     * Values for EventInitiatorType(2830).
     */
    public static class EventInitiatorTypeValues {

        public static final char CustomerOrClient         = 'C';
        public static final char ExchangeOrExecutionVenue = 'E';
        public static final char FirmOrBroker             = 'F';

        private EventInitiatorTypeValues() {
        }

    }

    /**
     * Values for NBBOEntryType(2831).
     */
    public static class NBBOEntryTypeValues {

        public static final int Bid      = 0;
        public static final int Offer    = 1;
        public static final int MidPrice = 2;

        private NBBOEntryTypeValues() {
        }

    }

    /**
     * Values for NBBOSource(2834).
     */
    public static class NBBOSourceValues {

        public static final int NotApplicable = 0;
        public static final int Direct        = 1;
        public static final int SIP           = 2;
        public static final int Hybrid        = 3;

        private NBBOSourceValues() {
        }

    }

    /**
     * Values for CollateralReinvestmentType(2844).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>SideCollateralReinvestmentType(2867)</li>
     * </ul>
     */
    public static class CollateralReinvestmentTypeValues {

        public static final int MoneyMarketFund            = 0;
        public static final int OtherComingledPool         = 1;
        public static final int RepoMarket                 = 2;
        public static final int DirectPurchaseOfSecurities = 3;
        public static final int OtherInvestments           = 4;

        private CollateralReinvestmentTypeValues() {
        }

    }

    /**
     * Values for FundingSource(2846).
     */
    public static class FundingSourceValues {

        public static final int Repo               = 0;
        public static final int Cash               = 1;
        public static final int FreeCedits         = 2;
        public static final int CustomerShortSales = 3;
        public static final int BrokerShortSales   = 4;
        public static final int UnsecuredBorrowing = 5;
        public static final int Other              = 99;

        private FundingSourceValues() {
        }

    }

    /**
     * Values for MarginDirection(2851).
     */
    public static class MarginDirectionValues {

        public static final int Posted   = 0;
        public static final int Received = 1;

        private MarginDirectionValues() {
        }

    }

    /**
     * Values for TransactionAttributeType(2872).
     */
    public static class TransactionAttributeTypeValues {

        public static final int ExclusiveArrangement     = 0;
        public static final int CollateralReuse          = 1;
        public static final int CollateralArrangmentType = 2;

        private TransactionAttributeTypeValues() {
        }

    }

    /**
     * Values for RoutingArrangmentIndicator(2883).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ContraRoutingArrangmentIndicator(2884)</li>
     * </ul>
     */
    public static class RoutingArrangmentIndicatorValues {

        public static final int NoRoutingArrangmentInPlace = 0;
        public static final int RoutingArrangementInPlace  = 1;

        private RoutingArrangmentIndicatorValues() {
        }

    }

    /**
     * Values for RelatedOrderIDSource(2888).
     */
    public static class RelatedOrderIDSourceValues {

        public static final int NonFIXSource                   = 0;
        public static final int SystemOrderIdentifier          = 1;
        public static final int ClientOrderIdentifier          = 2;
        public static final int SecondaryOrderIdentifier       = 3;
        public static final int SecondaryClientOrderIdentifier = 4;

        private RelatedOrderIDSourceValues() {
        }

    }

    /**
     * Values for OrderRelationship(2890).
     */
    public static class OrderRelationshipValues {

        public static final int NotSpecified     = 0;
        public static final int OrderAggregation = 1;
        public static final int OrderSplit       = 2;

        private OrderRelationshipValues() {
        }

    }

    /**
     * Values for CurrencyCodeSource(2897).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegCurrencyCodeSource(2898)</li>
     *   <li>SettlCurrencyCodeSource(2899)</li>
     *   <li>LegSettlCurrencyCodeSource(2900)</li>
     *   <li>SideCurrencyCodeSource(2901)</li>
     *   <li>SideSettlCurrencyCodeSource(2902)</li>
     *   <li>SettlementAmountCurrencyCodeSource(2903)</li>
     *   <li>StrikeCurrencyCodeSource(2904)</li>
     *   <li>UnitOfMeasureCurrencyCodeSource(2905)</li>
     *   <li>PriceUnitOfMeasureCurrencyCodeSource(2906)</li>
     *   <li>PriceQuoteCurrencyCodeSource(2907)</li>
     *   <li>LegStrikeCurrencyCodeSource(2908)</li>
     *   <li>LegUnitOfMeasureCurrencyCodeSource(2909)</li>
     *   <li>LegPriceUnitOfMeasureCurrencyCodeSource(2910)</li>
     *   <li>LegPriceQuoteCurrencyCodeSource(2911)</li>
     *   <li>DerivativeStrikeCurrencyCodeSource(2912)</li>
     *   <li>DerivativeUnitOfMeasureCurrencyCodeSource(2913)</li>
     *   <li>DerivativePriceUnitOfMeasureCurrencyCodeSource(2914)</li>
     *   <li>DerivativePriceQuoteCurrencyCodeSource(2915)</li>
     *   <li>UnderlyingCurrencyCodeSource(2916)</li>
     *   <li>UnderlyingStrikeCurrencyCodeSource(2917)</li>
     *   <li>UnderlyingUnitOfMeasureCurrencyCodeSource(2918)</li>
     *   <li>UnderlyingPriceUnitOfMeasureCurrencyCodeSource(2919)</li>
     *   <li>UnderlyingPriceQuoteCurrencyCodeSource(2920)</li>
     *   <li>UnderlyingNotionalCurrencyCodeSource(2921)</li>
     *   <li>CommCurrencyCodeSource(2922)</li>
     *   <li>CommissionCurrencyCodeSource(2923)</li>
     *   <li>CommissionUnitOfMeasureCurrencyCodeSource(2924)</li>
     *   <li>AllocCommissionCurrencyCodeSource(2925)</li>
     *   <li>AllocCommissionUnitOfMeasureCurrencyCodeSource(2926)</li>
     *   <li>AllocSettlCurrencyCodeSource(2927)</li>
     *   <li>LegAllocSettlCurrencyCodeSource(2928)</li>
     *   <li>CollateralCurrencyCodeSource(2929)</li>
     *   <li>SideCollateralCurrencyCodeSource(2930)</li>
     *   <li>CollateralReinvestmentCurrencyCodeSource(2931)</li>
     *   <li>SideCollateralReinvestmentCurrencyCodeSource(2932)</li>
     *   <li>TradeAllocCurrencyCodeSource(2933)</li>
     *   <li>TradingCurrencyCodeSource(2934)</li>
     *   <li>LimitAmtCurrencyCodeSource(2935)</li>
     *   <li>PosQtyUnitOfMeasureCurrencyCodeSource(2936)</li>
     *   <li>PositionCurrencyCodeSource(2937)</li>
     *   <li>LegPosCurrencyCodeSource(2938)</li>
     *   <li>RiskLimitCurrencyCodeSource(2939)</li>
     *   <li>EntitlementAttribCurrencyCodeSource(2940)</li>
     *   <li>ComplexOptPayoutCurrencyCodeSource(2941)</li>
     *   <li>ComplexEventCurrencyOneCodeSource(2942)</li>
     *   <li>ComplexEventCurrencyTwoCodeSource(2943)</li>
     *   <li>LegComplexOptPayoutCurrencyCodeSource(2944)</li>
     *   <li>LegComplexEventCurrencyOneCodeSource(2945)</li>
     *   <li>LegComplexEventCurrencyTwoCodeSource(2946)</li>
     *   <li>UnderlyingComplexOptPayoutCurrencyCodeSource(2947)</li>
     *   <li>UnderlyingComplexEventCurrencyOneCodeSource(2948)</li>
     *   <li>UnderlyingComplexEventCurrencyTwoCodeSource(2949)</li>
     *   <li>BenchmarkCurveCurrencyCodeSource(2950)</li>
     *   <li>LegBenchmarkCurveCurrencyCodeSource(2951)</li>
     *   <li>AgreementCurrencyCodeSource(2952)</li>
     *   <li>LegAgreementCurrencyCodeSource(2953)</li>
     *   <li>FundingSourceCurrencyCodeSource(2954)</li>
     *   <li>PayCollectCurrencyCodeSource(2955)</li>
     *   <li>PostTradePaymentCurrencyCodeSource(2956)</li>
     *   <li>SettlPriceUnitOfMeasureCurrencyCodeSource(2960)</li>
     * </ul>
     */
    public static class CurrencyCodeSourceValues {

        public static final String CUSIP                               = "1";
        public static final String SEDOL                               = "2";
        public static final String ISINNumber                          = "4";
        public static final String ISOCurrencyCode                     = "6";
        public static final String FinancialInstrumentGlobalIdentifier = "S";
        public static final String DigitalTokenIdentifier              = "Y";

        private CurrencyCodeSourceValues() {
        }

    }

    /**
     * Values for CashSettlQuoteMethod(40027).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegCashSettlQuoteMethod(41351)</li>
     *   <li>UnderlyingCashSettlQuoteMethod(42048)</li>
     *   <li>LegReturnRateQuoteMethod(42544)</li>
     *   <li>ReturnRateQuoteMethod(42745)</li>
     *   <li>UnderlyingReturnRateQuoteMethod(43044)</li>
     * </ul>
     */
    public static class CashSettlQuoteMethodValues {

        public static final int Bid   = 0;
        public static final int Mid   = 1;
        public static final int Offer = 2;

        private CashSettlQuoteMethodValues() {
        }

    }

    /**
     * Values for CashSettlValuationMethod(40038).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegCashSettlValuationMethod(41361)</li>
     *   <li>UnderlyingCashSettlValuationMethod(42058)</li>
     * </ul>
     */
    public static class CashSettlValuationMethodValues {

        public static final int Market                = 0;
        public static final int Highest               = 1;
        public static final int AverageMarket         = 2;
        public static final int AverageHighest        = 3;
        public static final int BlendedMarket         = 4;
        public static final int BlendedHighest        = 5;
        public static final int AverageBlendedMarket  = 6;
        public static final int AverageBlendedHighest = 7;

        private CashSettlValuationMethodValues() {
        }

    }

    /**
     * Values for StreamType(40050).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegStreamType(40242)</li>
     *   <li>UnderlyingStreamType(40541)</li>
     * </ul>
     */
    public static class StreamTypeValues {

        public static final int PaymentCashSettlement = 0;
        public static final int PhysicalDelivery      = 1;

        private StreamTypeValues() {
        }

    }

    /**
     * Values for ProvisionType(40091).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegProvisionType(40449)</li>
     *   <li>UnderlyingProvisionType(42150)</li>
     * </ul>
     */
    public static class ProvisionTypeValues {

        public static final int MandatoryEarlyTermination = 0;
        public static final int OptionalEarlyTermination  = 1;
        public static final int Cancelable                = 2;
        public static final int Extendable                = 3;
        public static final int MutualEarlyTermination    = 4;
        public static final int Evergreen                 = 5;
        public static final int Callable                  = 6;
        public static final int Puttable                  = 7;

        private ProvisionTypeValues() {
        }

    }

    /**
     * Values for ProvisionDateTenorUnit(40097).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegProvisionDateTenorUnit(40455)</li>
     *   <li>UnderlyingProvisionDateTenorUnit(42155)</li>
     * </ul>
     */
    public static class ProvisionDateTenorUnitValues {

        public static final String Day   = "D";
        public static final String Week  = "Wk";
        public static final String Month = "Mo";
        public static final String Year  = "Yr";

        private ProvisionDateTenorUnitValues() {
        }

    }

    /**
     * Values for ProvisionCalculationAgent(40098).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ComplexEventCalculationAgent(2129)</li>
     *   <li>LegComplexEventCalculationAgent(2238)</li>
     *   <li>UnderlyingComplexEventCalculationAgent(2273)</li>
     *   <li>SettlRatePostponementCalculationAgent(40089)</li>
     *   <li>LegProvisionCalculationAgent(40456)</li>
     *   <li>UnderlyingSettlRatePostponementCalculationAgent(40663)</li>
     *   <li>LegSettlRatePostponementCalculationAgent(40906)</li>
     *   <li>UnderlyingProvisionCalculationAgent(42156)</li>
     * </ul>
     */
    public static class ProvisionCalculationAgentValues {

        public static final int ExercisingParty    = 0;
        public static final int NonExercisingParty = 1;
        public static final int MasterAgreeent     = 2;
        public static final int Supplement         = 3;

        private ProvisionCalculationAgentValues() {
        }

    }

    /**
     * Values for ProvisionOptionSinglePartyBuyerSide(40099).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ProvisionOptionSinglePartySellerSide(40100)</li>
     *   <li>LegProvisionOptionSinglePartyBuyerSide(40457)</li>
     *   <li>LegProvisionOptionSinglePartySellerSide(40458)</li>
     *   <li>UnderlyingProvisionOptionSinglePartyBuyerSide(42157)</li>
     *   <li>UnderlyingProvisionOptionSinglePartySellerSide(42158)</li>
     * </ul>
     */
    public static class ProvisionOptionSinglePartyBuyerSideValues {

        public static final int Buy  = 1;
        public static final int Sell = 2;

        private ProvisionOptionSinglePartyBuyerSideValues() {
        }

    }

    /**
     * Values for ProvisionCashSettlMethod(40108).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegProvisionCashSettlMethod(40466)</li>
     *   <li>UnderlyingProvisionCashSettlMethod(42166)</li>
     * </ul>
     */
    public static class ProvisionCashSettlMethodValues {

        public static final int CashPrice                    = 0;
        public static final int CashPriceAlternate           = 1;
        public static final int ParYieldCurveAdjusted        = 2;
        public static final int ZeroCouponYieldCurveAdjusted = 3;
        public static final int ParYieldCurveUnadjusted      = 4;
        public static final int CrossCurrency                = 5;
        public static final int CollateralizedPrice          = 6;

        private ProvisionCashSettlMethodValues() {
        }

    }

    /**
     * Values for ProvisionCashSettlQuoteType(40111).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegProvisionCashSettlQuoteType(40469)</li>
     *   <li>UnderlyingProvisionCashSettlQuoteType(42169)</li>
     * </ul>
     */
    public static class ProvisionCashSettlQuoteTypeValues {

        public static final int Bid                 = 0;
        public static final int Mid                 = 1;
        public static final int Offer               = 2;
        public static final int ExercisingPartyPays = 3;

        private ProvisionCashSettlQuoteTypeValues() {
        }

    }

    /**
     * Values for ProvisionOptionExerciseEarliestDateOffsetUnit(40126).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegProvisionOptionExerciseEarliestDateOffsetUnit(40479)</li>
     *   <li>OptionExerciseEarliestDateOffsetUnit(41121)</li>
     *   <li>LegOptionExerciseEarliestDateOffsetUnit(41496)</li>
     *   <li>UnderlyingOptionExerciseEarliestDateOffsetUnit(41825)</li>
     *   <li>UnderlyingProvisionOptionExerciseEarliestDateOffsetUnit(42117)</li>
     * </ul>
     */
    public static class ProvisionOptionExerciseEarliestDateOffsetUnitValues {

        public static final String Day   = "D";
        public static final String Week  = "Wk";
        public static final String Month = "Mo";
        public static final String Year  = "Yr";

        private ProvisionOptionExerciseEarliestDateOffsetUnitValues() {
        }

    }

    /**
     * Values for ProvisionOptionExerciseFixedDateType(40144).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegProvisionOptionExerciseFixedDateType(40497)</li>
     *   <li>UnderlyingProvisionOptionExerciseFixedDateType(42114)</li>
     * </ul>
     */
    public static class ProvisionOptionExerciseFixedDateTypeValues {

        public static final int Unadjusted = 0;
        public static final int Adjusted   = 1;

        private ProvisionOptionExerciseFixedDateTypeValues() {
        }

    }

    /**
     * Values for ProvisionCashSettlPaymentDateType(40173).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegProvisionCashSettlPaymentDateType(40475)</li>
     *   <li>UnderlyingProvisionCashSettlPaymentDateType(42101)</li>
     * </ul>
     */
    public static class ProvisionCashSettlPaymentDateTypeValues {

        public static final int Unadjusted = 0;
        public static final int Adjusted   = 1;

        private ProvisionCashSettlPaymentDateTypeValues() {
        }

    }

    /**
     * Values for ProtectionTermEventUnit(40196).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ComplexEventCreditEventUnit(41002)</li>
     *   <li>ComplexEventScheduleFrequencyUnit(41035)</li>
     *   <li>OptionExerciseFrequencyUnit(41123)</li>
     *   <li>OptionExerciseExpirationFrequencyUnit(41147)</li>
     *   <li>StreamCalculationCorrectionUnit(41248)</li>
     *   <li>StreamCommoditySettlPeriodFrequencyUnit(41296)</li>
     *   <li>LegComplexEventCreditEventUnit(41371)</li>
     *   <li>LegComplexEventScheduleFrequencyUnit(41404)</li>
     *   <li>LegOptionExerciseFrequencyUnit(41498)</li>
     *   <li>LegOptionExerciseExpirationFrequencyUnit(41522)</li>
     *   <li>LegProtectionTermEventUnit(41630)</li>
     *   <li>LegStreamCalculationCorrectionUnit(41645)</li>
     *   <li>LegStreamCommoditySettlPeriodFrequencyUnit(41693)</li>
     *   <li>UnderlyingComplexEventCreditEventUnit(41721)</li>
     *   <li>UnderlyingComplexEventScheduleFrequencyUnit(41754)</li>
     *   <li>UnderlyingOptionExerciseFrequencyUnit(41827)</li>
     *   <li>UnderlyingOptionExerciseExpirationFrequencyUnit(41851)</li>
     *   <li>UnderlyingStreamCalculationCorrectionUnit(41961)</li>
     *   <li>UnderlyingStreamCommoditySettlPeriodFrequencyUnit(42009)</li>
     *   <li>UnderlyingProtectionTermEventUnit(42082)</li>
     * </ul>
     */
    public static class ProtectionTermEventUnitValues {

        public static final String Day   = "D";
        public static final String Week  = "Wk";
        public static final String Month = "Mo";
        public static final String Year  = "Yr";

        private ProtectionTermEventUnitValues() {
        }

    }

    /**
     * Values for ProtectionTermEventDayType(40197).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingProtectionTermEventDayType(42083)</li>
     * </ul>
     */
    public static class ProtectionTermEventDayTypeValues {

        public static final int Business            = 0;
        public static final int Calendar            = 1;
        public static final int CommodityBusiness   = 2;
        public static final int CurrencyBusiness    = 3;
        public static final int ExchangeBusiness    = 4;
        public static final int ScheduledTradingDay = 5;

        private ProtectionTermEventDayTypeValues() {
        }

    }

    /**
     * Values for ProtectionTermEventQualifier(40200).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ComplexEventCreditEventQualifier(41006)</li>
     *   <li>LegComplexEventCreditEventQualifier(41375)</li>
     *   <li>LegProtectionTermEventQualifier(41634)</li>
     *   <li>UnderlyingComplexEventCreditEventQualifier(41725)</li>
     *   <li>UnderlyingProtectionTermEventQualifier(42086)</li>
     * </ul>
     */
    public static class ProtectionTermEventQualifierValues {

        public static final char RestructuringMultipleHoldingObligations = 'H';
        public static final char RestructuringMultipleCreditEventNotices = 'E';
        public static final char FloatingRateInterestShortfall           = 'C';

        private ProtectionTermEventQualifierValues() {
        }

    }

    /**
     * Values for PaymentType(40213).
     */
    public static class PaymentTypeValues {

        public static final int Brokerage                   = 0;
        public static final int UpfrontFee                  = 1;
        public static final int IndependentAmountCollateral = 2;
        public static final int PrincipalExchange           = 3;
        public static final int NovationTermination         = 4;
        public static final int EarlyTerminationProvision   = 5;
        public static final int CancelableProvision         = 6;
        public static final int ExtendibleProvision         = 7;
        public static final int CapRateProvision            = 8;
        public static final int FloorRateProvision          = 9;
        public static final int OptionPremium               = 10;
        public static final int SettlementPayment           = 11;
        public static final int CashSettl                   = 12;
        public static final int SecurityLending             = 13;
        public static final int Rebate                      = 14;
        public static final int Other                       = 99;

        private PaymentTypeValues() {
        }

    }

    /**
     * Values for PaymentPaySide(40214).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ComplexOptPayoutPaySide(2117)</li>
     *   <li>ComplexOptPayoutReceiveSide(2118)</li>
     *   <li>LegComplexOptPayoutPaySide(2220)</li>
     *   <li>LegComplexOptPayoutReceiveSide(2221)</li>
     *   <li>UnderlyingComplexOptPayoutPaySide(2261)</li>
     *   <li>UnderlyingComplexOptPayoutReceiveSide(2262)</li>
     *   <li>StreamPaySide(40052)</li>
     *   <li>StreamReceiveSide(40053)</li>
     *   <li>PaymentReceiveSide(40215)</li>
     *   <li>LegStreamPaySide(40244)</li>
     *   <li>LegStreamReceiveSide(40245)</li>
     *   <li>LegPaymentSchedulePaySide(40379)</li>
     *   <li>LegPaymentScheduleReceiveSide(40380)</li>
     *   <li>UnderlyingStreamPaySide(40543)</li>
     *   <li>UnderlyingStreamReceiveSide(40544)</li>
     *   <li>UnderlyingPaymentSchedulePaySide(40669)</li>
     *   <li>UnderlyingPaymentScheduleReceiveSide(40670)</li>
     *   <li>PaymentSchedulePaySide(40833)</li>
     *   <li>PaymentScheduleReceiveSide(40834)</li>
     *   <li>LegSettlMethodElectingPartySide(42391)</li>
     *   <li>SettlMethodElectingPartySide(42590)</li>
     *   <li>UnderlyingSettlMethodElectingPartySide(42887)</li>
     * </ul>
     */
    public static class PaymentPaySideValues {

        public static final int Buy  = 1;
        public static final int Sell = 2;

        private PaymentPaySideValues() {
        }

    }

    /**
     * Values for PaymentSettlStyle(40227).
     */
    public static class PaymentSettlStyleValues {

        public static final int Standard     = 0;
        public static final int Net          = 1;
        public static final int StandardfNet = 2;

        private PaymentSettlStyleValues() {
        }

    }

    /**
     * Values for PaymentStreamType(40738).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamType(40279)</li>
     *   <li>UnderlyingPaymentStreamType(40568)</li>
     * </ul>
     */
    public static class PaymentStreamTypeValues {

        public static final int Periodic       = 0;
        public static final int Initial        = 1;
        public static final int Single         = 2;
        public static final int Dividend       = 3;
        public static final int Interest       = 4;
        public static final int DividendReturn = 5;
        public static final int PriceReturn    = 6;
        public static final int TotalReturn    = 7;
        public static final int Variance       = 8;
        public static final int Correlation    = 9;

        private PaymentStreamTypeValues() {
        }

    }

    /**
     * Values for PaymentStreamDiscountType(40744).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamDiscountType(40285)</li>
     *   <li>UnderlyingPaymentStreamDiscountType(40574)</li>
     * </ul>
     */
    public static class PaymentStreamDiscountTypeValues {

        public static final int Standard = 0;
        public static final int FRA      = 1;

        private PaymentStreamDiscountTypeValues() {
        }

    }

    /**
     * Values for PaymentStreamCompoundingMethod(40747).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamCompoundingMethod(40288)</li>
     *   <li>UnderlyingPaymentStreamCompoundingMethod(40577)</li>
     *   <li>DividendCompoundingMethod(42254)</li>
     *   <li>LegDividendCompoundingMethod(42346)</li>
     *   <li>UnderlyingDividendCompoundingMethod(42835)</li>
     * </ul>
     */
    public static class PaymentStreamCompoundingMethodValues {

        public static final int None            = 0;
        public static final int Flat            = 1;
        public static final int Straight        = 2;
        public static final int SpreadExclusive = 3;

        private PaymentStreamCompoundingMethodValues() {
        }

    }

    /**
     * Values for PaymentStreamPaymentFrequencyUnit(40754).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamPaymentFrequencyUnit(40295)</li>
     *   <li>UnderlyingPaymentStreamPaymentFrequencyUnit(40584)</li>
     * </ul>
     */
    public static class PaymentStreamPaymentFrequencyUnitValues {

        public static final String Day   = "D";
        public static final String Week  = "Wk";
        public static final String Month = "Mo";
        public static final String Year  = "Yr";
        public static final String Term  = "T";

        private PaymentStreamPaymentFrequencyUnitValues() {
        }

    }

    /**
     * Values for PaymentStreamPaymentDateOffsetUnit(40760).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingStreamEffectiveDateOffsetUnit(40062)</li>
     *   <li>StreamTerminationDateOffsetUnit(40070)</li>
     *   <li>ProvisionCashSettlValueDateOffsetUnit(40120)</li>
     *   <li>ProvisionOptionExerciseStartDateOffsetUnit(40132)</li>
     *   <li>ProvisionOptionExpirationDateOffsetUnit(40150)</li>
     *   <li>ProvisionOptionRelevantUnderlyingDateOffsetUnit(40160)</li>
     *   <li>ProvisionCashSettlPaymentDateOffsetUnit(40167)</li>
     *   <li>LegStreamEffectiveDateOffsetUnit(40254)</li>
     *   <li>LegStreamTerminationDateOffsetUnit(40262)</li>
     *   <li>LegPaymentStreamPaymentDateOffsetUnit(40301)</li>
     *   <li>LegPaymentStreamInitialFixingDateOffsetUnit(40313)</li>
     *   <li>LegPaymentStreamFixingDateOffsetUnit(40320)</li>
     *   <li>LegPaymentStreamRateCutoffDateOffsetUnit(40324)</li>
     *   <li>LegPaymentStreamNonDeliverableFixingDatesOffsetUnit(40364)</li>
     *   <li>LegPaymentScheduleFixingDateOffsetUnit(40402)</li>
     *   <li>LegPaymentScheduleInterimExchangeDatesOffsetUnit(40411)</li>
     *   <li>LegProvisionOptionExerciseStartDateOffsetUnit(40485)</li>
     *   <li>LegProvisionOptionExpirationDateOffsetUnit(40503)</li>
     *   <li>LegProvisionOptionRelevantUnderlyingDateOffsetUnit(40513)</li>
     *   <li>LegProvisionCashSettlPaymentDateOffsetUnit(40520)</li>
     *   <li>LegProvisionCashSettlValueDateOffsetUnit(40530)</li>
     *   <li>UnderlyingStreamTerminationDateOffsetUnit(40553)</li>
     *   <li>UnderlyingPaymentStreamPaymentDateOffsetUnit(40590)</li>
     *   <li>UnderlyingPaymentStreamInitialFixingDateOffsetUnit(40602)</li>
     *   <li>UnderlyingPaymentStreamFixingDateOffsetUnit(40609)</li>
     *   <li>UnderlyingPaymentStreamRateCutoffDateOffsetUnit(40613)</li>
     *   <li>UnderlyingPaymentStreamNonDeliverableFixingDatesOffsetUnit(40653)</li>
     *   <li>UnderlyingPaymentScheduleFixingDateOffsetUnit(40692)</li>
     *   <li>UnderlyingPaymentScheduleInterimExchangeDatesOffsetUnit(40701)</li>
     *   <li>PaymentStreamInitialFixingDateOffsetUnit(40771)</li>
     *   <li>PaymentStreamFixingDateOffsetUnit(40778)</li>
     *   <li>PaymentStreamRateCutoffDateOffsetUnit(40782)</li>
     *   <li>PaymentStreamNonDeliverableFixingDatesOffsetUnit(40822)</li>
     *   <li>PaymentScheduleFixingDateOffsetUnit(40856)</li>
     *   <li>PaymentScheduleInterimExchangeDatesOffsetUnit(40865)</li>
     *   <li>StreamEffectiveDateOffsetUnit(40912)</li>
     *   <li>ComplexEventDateOffsetUnit(41023)</li>
     *   <li>OptionExerciseStartDateOffsetUnit(41127)</li>
     *   <li>OptionExerciseExpirationDateOffsetUnit(41145)</li>
     *   <li>PaymentDateOffsetUnit(41158)</li>
     *   <li>PaymentScheduleFixingFirstObservationDateOffsetUnit(41179)</li>
     *   <li>PaymentStreamFirstObservationDateOffsetUnit(41212)</li>
     *   <li>LegComplexEventDateOffsetUnit(41392)</li>
     *   <li>LegOptionExerciseStartDateOffsetUnit(41502)</li>
     *   <li>LegOptionExerciseExpirationDateOffsetUnit(41520)</li>
     *   <li>LegPaymentScheduleFixingFirstObservationDateOffsetUnit(41548)</li>
     *   <li>LegPaymentStreamFirstObservationDateOffsetUnit(41581)</li>
     *   <li>UnderlyingComplexEventDateOffsetUnit(41742)</li>
     *   <li>UnderlyingOptionExerciseStartDateOffsetUnit(41831)</li>
     *   <li>UnderlyingOptionExerciseExpirationDateOffsetUnit(41849)</li>
     *   <li>UnderlyingPaymentScheduleFixingFirstObservationDateOffsetUnit(41896)</li>
     *   <li>UnderlyingPaymentStreamFirstObservationDateOffsetUnit(41929)</li>
     *   <li>UnderlyingProvisionCashSettlPaymentDateOffsetUnit(42095)</li>
     *   <li>UnderlyingProvisionCashSettlValueDateOffsetUnit(42109)</li>
     *   <li>UnderlyingProvisionOptionExerciseStartDateOffsetUnit(42123)</li>
     *   <li>UnderlyingProvisionOptionExpirationDateOffsetUnit(42137)</li>
     *   <li>UnderlyingProvisionOptionRelevantUnderlyingDateOffsetUnit(42146)</li>
     *   <li>CashSettlDateOffsetUnit(42211)</li>
     *   <li>DividendAccrualPaymentDateOffsetUnit(42240)</li>
     *   <li>DividendFXTriggerDateOffsetUnit(42267)</li>
     *   <li>DividendPeriodValuationDateOffsetUnit(42284)</li>
     *   <li>DividendPeriodPaymentDateOffsetUnit(42290)</li>
     *   <li>LegCashSettlDateOffsetUnit(42303)</li>
     *   <li>LegDividendAccrualPaymentDateOffsetUnit(42332)</li>
     *   <li>LegDividendFXTriggerDateOffsetUnit(42359)</li>
     *   <li>LegDividendPeriodValuationDateOffsetUnit(42376)</li>
     *   <li>LegDividendPeriodPaymentDateOffsetUnit(42382)</li>
     *   <li>LegPaymentStreamCompoundingDatesOffsetUnit(42411)</li>
     *   <li>LegPaymentStreamCompoundingEndDateOffsetUnit(42424)</li>
     *   <li>LegPaymentStreamCompoundingStartDateOffsetUnit(42448)</li>
     *   <li>LegPaymentStreamFinalPricePaymentDateOffsetUnit(42456)</li>
     *   <li>LegPaymentStubEndDateOffsetUnit(42492)</li>
     *   <li>LegPaymentStubStartDateOffsetUnit(42501)</li>
     *   <li>LegReturnRateValuationDateOffsetUnit(42512)</li>
     *   <li>LegReturnRateValuationStartDateOffsetUnit(42517)</li>
     *   <li>LegReturnRateValuationEndDateOffsetUnit(42523)</li>
     *   <li>LegSettlMethodElectionDateOffsetUnit(42578)</li>
     *   <li>PaymentStreamCompoundingDatesOffsetUnit(42612)</li>
     *   <li>PaymentStreamCompoundingEndDateOffsetUnit(42625)</li>
     *   <li>PaymentStreamCompoundingStartDateOffsetUnit(42649)</li>
     *   <li>PaymentStreamFinalPricePaymentDateOffsetUnit(42657)</li>
     *   <li>PaymentStubEndDateOffsetUnit(42693)</li>
     *   <li>PaymentStubStartDateOffsetUnit(42702)</li>
     *   <li>ReturnRateValuationDateOffsetUnit(42713)</li>
     *   <li>ReturnRateValuationStartDateOffsetUnit(42718)</li>
     *   <li>ReturnRateValuationEndDateOffsetUnit(42724)</li>
     *   <li>SettlMethodElectionDateOffsetUnit(42781)</li>
     *   <li>UnderlyingCashSettlDateOffsetUnit(42794)</li>
     *   <li>UnderlyingDividendAccrualPaymentDateOffsetUnit(42821)</li>
     *   <li>UnderlyingDividendFXTriggerDateOffsetUnit(42848)</li>
     *   <li>UnderlyingDividendPeriodValuationDateOffsetUnit(42872)</li>
     *   <li>UnderlyingDividendPeriodPaymentDateOffsetUnit(42878)</li>
     *   <li>UnderlyingPaymentStreamCompoundingDatesOffsetUnit(42907)</li>
     *   <li>UnderlyingPaymentStreamCompoundingEndDateOffsetUnit(42920)</li>
     *   <li>UnderlyingPaymentStreamCompoundingStartDateOffsetUnit(42944)</li>
     *   <li>UnderlyingPaymentStreamFinalPricePaymentDateOffsetUnit(42952)</li>
     *   <li>UnderlyingPaymentStubEndDateOffsetUnit(42988)</li>
     *   <li>UnderlyingPaymentStubStartDateOffsetUnit(42997)</li>
     *   <li>UnderlyingReturnRateValuationDateOffsetUnit(43012)</li>
     *   <li>UnderlyingReturnRateValuationStartDateOffsetUnit(43017)</li>
     *   <li>UnderlyingReturnRateValuationEndDateOffsetUnit(43023)</li>
     *   <li>UnderlyingSettlMethodElectionDateOffsetUnit(43080)</li>
     * </ul>
     */
    public static class PaymentStreamPaymentDateOffsetUnitValues {

        public static final String Day   = "D";
        public static final String Week  = "Wk";
        public static final String Month = "Mo";
        public static final String Year  = "Yr";

        private PaymentStreamPaymentDateOffsetUnitValues() {
        }

    }

    /**
     * Values for PaymentStreamResetWeeklyRollConvention(40766).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamResetWeeklyRollConvention(40308)</li>
     *   <li>UnderlyingPaymentStreamResetWeeklyRollConvention(40597)</li>
     * </ul>
     */
    public static class PaymentStreamResetWeeklyRollConventionValues {

        public static final String Monday    = "MON";
        public static final String Tuesday   = "TUE";
        public static final String Wednesday = "WED";
        public static final String Thursday  = "THU";
        public static final String Friday    = "FRI";
        public static final String Saturday  = "SAT";
        public static final String Sunday    = "SUN";

        private PaymentStreamResetWeeklyRollConventionValues() {
        }

    }

    /**
     * Values for PaymentStreamRateIndexSource(40790).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ProvisionCashSettlQuoteSource(40112)</li>
     *   <li>LegPaymentStreamRateIndexSource(40332)</li>
     *   <li>LegPaymentStreamInflationIndexSource(40354)</li>
     *   <li>LegPaymentStubIndexSource(40425)</li>
     *   <li>LegPaymentStubIndex2Source(40439)</li>
     *   <li>LegProvisionCashSettlQuoteSource(40470)</li>
     *   <li>UnderlyingPaymentStreamRateIndexSource(40621)</li>
     *   <li>UnderlyingPaymentStreamInflationIndexSource(40643)</li>
     *   <li>UnderlyingPaymentStubIndexSource(40715)</li>
     *   <li>UnderlyingPaymentStubIndex2Source(40729)</li>
     *   <li>PaymentStreamInflationIndexSource(40812)</li>
     *   <li>PaymentStubIndexSource(40879)</li>
     *   <li>PaymentStubIndex2Source(40893)</li>
     *   <li>UnderlyingProvisionCashSettlQuoteSource(42102)</li>
     *   <li>PaymentStreamRateIndex2Source(43113)</li>
     *   <li>LegPaymentStreamRateIndex2Source(43117)</li>
     *   <li>UnderlyingPaymentStreamRateIndex2Source(43121)</li>
     * </ul>
     */
    public static class PaymentStreamRateIndexSourceValues {

        public static final int Bloomberg = 0;
        public static final int Reuters   = 1;
        public static final int Telerate  = 2;
        public static final int Other     = 99;

        private PaymentStreamRateIndexSourceValues() {
        }

    }

    /**
     * Values for PaymentStreamRateIndexCurveUnit(40791).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingIndexCurveUnit(2723)</li>
     *   <li>FloatingRateIndexCurveUnit(2730)</li>
     *   <li>LegPaymentStreamRateIndexCurveUnit(40333)</li>
     *   <li>LegPaymentStubIndexCurveUnit(40427)</li>
     *   <li>LegPaymentStubIndex2CurveUnit(40441)</li>
     *   <li>UnderlyingPaymentStreamRateIndexCurveUnit(40622)</li>
     *   <li>UnderlyingPaymentStubIndexCurveUnit(40717)</li>
     *   <li>UnderlyingPaymentStubIndex2CurveUnit(40731)</li>
     *   <li>PaymentStubIndexCurveUnit(40881)</li>
     *   <li>PaymentStubIndex2CurveUnit(40895)</li>
     *   <li>PaymentStreamRateIndex2CurveUnit(41195)</li>
     *   <li>LegPaymentStreamRateIndex2CurveUnit(41563)</li>
     *   <li>UnderlyingPaymentStreamRateIndex2CurveUnit(41911)</li>
     *   <li>DividendFloatingRateIndexCurveUnit(42220)</li>
     *   <li>LegDividendFloatingRateIndexCurveUnit(42314)</li>
     *   <li>LegPaymentStreamCompoundingRateIndexCurveUnit(42429)</li>
     *   <li>PaymentStreamCompoundingRateIndexCurveUnit(42630)</li>
     *   <li>UnderlyingDividendFloatingRateIndexCurveUnit(42803)</li>
     *   <li>UnderlyingPaymentStreamCompoundingRateIndexCurveUnit(42925)</li>
     *   <li>PaymentFloatingRateIndexCurveUnit(43100)</li>
     *   <li>PaymentFrequencyUnit(43103)</li>
     *   <li>PaymentRateResetFrequencyUnit(43105)</li>
     * </ul>
     */
    public static class PaymentStreamRateIndexCurveUnitValues {

        public static final String Day   = "D";
        public static final String Week  = "Wk";
        public static final String Month = "Mo";
        public static final String Year  = "Yr";

        private PaymentStreamRateIndexCurveUnitValues() {
        }

    }

    /**
     * Values for PaymentStreamRateSpreadPositionType(40795).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamRateSpreadPositionType(40337)</li>
     *   <li>LegPaymentScheduleRateSpreadPositionType(40386)</li>
     *   <li>LegPaymentStubIndexRateSpreadPositionType(40430)</li>
     *   <li>LegPaymentStubIndex2RateSpreadPositionType(40444)</li>
     *   <li>UnderlyingPaymentStreamRateSpreadPositionType(40626)</li>
     *   <li>UnderlyingPaymentScheduleRateSpreadPositionType(40676)</li>
     *   <li>UnderlyingPaymentStubIndexRateSpreadPositionType(40720)</li>
     *   <li>UnderlyingPaymentStubIndex2RateSpreadPositionType(40734)</li>
     *   <li>PaymentScheduleRateSpreadPositionType(40840)</li>
     *   <li>PaymentStubIndexRateSpreadPositionType(40884)</li>
     *   <li>PaymentStubIndex2RateSpreadPositionType(40898)</li>
     *   <li>DividendFloatingRateSpreadPositionType(42223)</li>
     *   <li>LegDividendFloatingRateSpreadPositionType(42317)</li>
     *   <li>LegPaymentStreamCompoundingRateSpreadPositionType(42432)</li>
     *   <li>PaymentStreamCompoundingRateSpreadPositionType(42633)</li>
     *   <li>UnderlyingDividendFloatingRateSpreadPositionType(42806)</li>
     *   <li>UnderlyingPaymentStreamCompoundingRateSpreadPositionType(42928)</li>
     * </ul>
     */
    public static class PaymentStreamRateSpreadPositionTypeValues {

        public static final int Short = 0;
        public static final int Long  = 1;

        private PaymentStreamRateSpreadPositionTypeValues() {
        }

    }

    /**
     * Values for PaymentStreamRateTreatment(40796).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamRateTreatment(40338)</li>
     *   <li>LegPaymentScheduleRateTreatment(40387)</li>
     *   <li>LegPaymentStubIndexRateTreatment(40431)</li>
     *   <li>LegPaymentStubIndex2RateTreatment(40445)</li>
     *   <li>UnderlyingPaymentStreamRateTreatment(40627)</li>
     *   <li>UnderlyingPaymentScheduleRateTreatment(40677)</li>
     *   <li>UnderlyingPaymentStubIndexRateTreatment(40721)</li>
     *   <li>UnderlyingPaymentStubIndex2RateTreatment(40735)</li>
     *   <li>PaymentScheduleRateTreatment(40841)</li>
     *   <li>PaymentStubIndexRateTreatment(40885)</li>
     *   <li>PaymentStubIndex2RateTreatment(40899)</li>
     *   <li>DividendFloatingRateTreatment(42224)</li>
     *   <li>LegDividendFloatingRateTreatment(42318)</li>
     *   <li>LegPaymentStreamCompoundingRateTreatment(42433)</li>
     *   <li>PaymentStreamCompoundingRateTreatment(42634)</li>
     *   <li>UnderlyingDividendFloatingRateTreatment(42807)</li>
     *   <li>UnderlyingPaymentStreamCompoundingRateTreatment(42929)</li>
     * </ul>
     */
    public static class PaymentStreamRateTreatmentValues {

        public static final int BondEquivalentYield = 0;
        public static final int MoneyMarketYield    = 1;

        private PaymentStreamRateTreatmentValues() {
        }

    }

    /**
     * Values for PaymentStreamCapRateBuySide(40798).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamCapRateBuySide(40340)</li>
     *   <li>LegPaymentStreamCapRateSellSide(40341)</li>
     *   <li>LegPaymentStubIndexCapRateBuySide(40433)</li>
     *   <li>LegPaymentStubIndexCapRateSellSide(40434)</li>
     *   <li>UnderlyingPaymentStreamCapRateBuySide(40629)</li>
     *   <li>UnderlyingPaymentStreamCapRateSellSide(40630)</li>
     *   <li>UnderlyingPaymentStubIndexCapRateBuySide(40723)</li>
     *   <li>UnderlyingPaymentStubIndexCapRateSellSide(40724)</li>
     *   <li>PaymentStreamCapRateSellSide(40799)</li>
     *   <li>PaymentStubIndexCapRateBuySide(40887)</li>
     *   <li>PaymentStubIndexCapRateSellSide(40888)</li>
     *   <li>DividendCapRateBuySide(42226)</li>
     *   <li>DividendCapRateSellSide(42227)</li>
     *   <li>ExtraordinaryDividendPartySide(42249)</li>
     *   <li>LegDividendCapRateBuySide(42320)</li>
     *   <li>LegDividendCapRateSellSide(42321)</li>
     *   <li>LegExtraordinaryDividendPartySide(42341)</li>
     *   <li>LegPaymentStreamCompoundingCapRateBuySide(42435)</li>
     *   <li>LegPaymentStreamCompoundingCapRateSellSide(42436)</li>
     *   <li>PaymentStreamCompoundingCapRateBuySide(42636)</li>
     *   <li>PaymentStreamCompoundingCapRateSellSide(42637)</li>
     *   <li>UnderlyingDividendCapRateBuySide(42809)</li>
     *   <li>UnderlyingDividendCapRateSellSide(42810)</li>
     *   <li>UnderlyingExtraordinaryDividendPartySide(42830)</li>
     *   <li>UnderlyingPaymentStreamCompoundingCapRateBuySide(42931)</li>
     *   <li>UnderlyingPaymentStreamCompoundingCapRateSellSide(42932)</li>
     * </ul>
     */
    public static class PaymentStreamCapRateBuySideValues {

        public static final int Buyer  = 1;
        public static final int Seller = 2;

        private PaymentStreamCapRateBuySideValues() {
        }

    }

    /**
     * Values for PaymentStreamFloorRateBuySide(40801).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamFloorRateBuySide(40343)</li>
     *   <li>LegPaymentStreamFloorRateSellSide(40344)</li>
     *   <li>LegPaymentStubIndexFloorRateBuySide(40436)</li>
     *   <li>LegPaymentStubIndexFloorRateSellSide(40437)</li>
     *   <li>UnderlyingPaymentStreamFloorRateBuySide(40632)</li>
     *   <li>UnderlyingPaymentStreamFloorRateSellSide(40633)</li>
     *   <li>UnderlyingPaymentStubIndexFloorRateBuySide(40726)</li>
     *   <li>UnderlyingPaymentStubIndexFloorRateSellSide(40727)</li>
     *   <li>PaymentStreamFloorRateSellSide(40802)</li>
     *   <li>PaymentStubIndexFloorRateBuySide(40890)</li>
     *   <li>PaymentStubIndexFloorRateSellSide(40891)</li>
     *   <li>DividendFloorRateBuySide(42229)</li>
     *   <li>DividendFloorRateSellSide(42230)</li>
     *   <li>LegDividendFloorRateBuySide(42323)</li>
     *   <li>LegDividendFloorRateSellSide(42324)</li>
     *   <li>LegPaymentStreamCompoundingFloorRateBuySide(42438)</li>
     *   <li>LegPaymentStreamCompoundingFloorRateSellSide(42439)</li>
     *   <li>PaymentStreamCompoundingFloorRateBuySide(42639)</li>
     *   <li>PaymentStreamCompoundingFloorRateSellSide(42640)</li>
     *   <li>UnderlyingDividendFloorRateBuySide(42812)</li>
     *   <li>UnderlyingDividendFloorRateSellSide(42813)</li>
     *   <li>UnderlyingPaymentStreamCompoundingFloorRateBuySide(42934)</li>
     *   <li>UnderlyingPaymentStreamCompoundingFloorRateSellSide(42935)</li>
     * </ul>
     */
    public static class PaymentStreamFloorRateBuySideValues {

        public static final int Buyer  = 1;
        public static final int Seller = 2;

        private PaymentStreamFloorRateBuySideValues() {
        }

    }

    /**
     * Values for PaymentStreamAveragingMethod(40806).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamAveragingMethod(40348)</li>
     *   <li>UnderlyingPaymentStreamAveragingMethod(40637)</li>
     *   <li>DividendAveragingMethod(42234)</li>
     *   <li>LegDividendAveragingMethod(42328)</li>
     *   <li>LegPaymentStreamCompoundingAveragingMethod(42443)</li>
     *   <li>PaymentStreamCompoundingAveragingMethod(42644)</li>
     *   <li>UnderlyingDividendAveragingMethod(42817)</li>
     *   <li>UnderlyingPaymentStreamCompoundingAveragingMethod(42939)</li>
     * </ul>
     */
    public static class PaymentStreamAveragingMethodValues {

        public static final int Unweighted = 0;
        public static final int Weighted   = 1;

        private PaymentStreamAveragingMethodValues() {
        }

    }

    /**
     * Values for PaymentStreamNegativeRateTreatment(40807).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamNegativeRateTreatment(40349)</li>
     *   <li>UnderlyingPaymentStreamNegativeRateTreatment(40638)</li>
     *   <li>DividendNegativeRateTreatment(42235)</li>
     *   <li>LegDividendNegativeRateTreatment(42329)</li>
     *   <li>LegPaymentStreamCompoundingNegativeRateTreatment(42444)</li>
     *   <li>PaymentStreamCompoundingNegativeRateTreatment(42645)</li>
     *   <li>UnderlyingDividendNegativeRateTreatment(42818)</li>
     *   <li>UnderlyingPaymentStreamCompoundingNegativeRateTreatment(42940)</li>
     * </ul>
     */
    public static class PaymentStreamNegativeRateTreatmentValues {

        public static final int ZeroInterestRateMethod     = 0;
        public static final int NegativeInterestRateMethod = 1;

        private PaymentStreamNegativeRateTreatmentValues() {
        }

    }

    /**
     * Values for PaymentStreamInflationLagUnit(40809).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamInflationLagUnit(40351)</li>
     *   <li>UnderlyingPaymentStreamInflationLagUnit(40640)</li>
     *   <li>PaymentScheduleFixingLagUnit(41177)</li>
     *   <li>PaymentStreamCalculationLagUnit(41210)</li>
     *   <li>LegPaymentScheduleFixingLagUnit(41546)</li>
     *   <li>LegPaymentStreamCalculationLagUnit(41579)</li>
     *   <li>UnderlyingPaymentScheduleFixingLagUnit(41894)</li>
     *   <li>UnderlyingPaymentStreamCalculationLagUnit(41927)</li>
     * </ul>
     */
    public static class PaymentStreamInflationLagUnitValues {

        public static final String Day   = "D";
        public static final String Week  = "Wk";
        public static final String Month = "Mo";
        public static final String Year  = "Yr";

        private PaymentStreamInflationLagUnitValues() {
        }

    }

    /**
     * Values for PaymentStreamInflationLagDayType(40810).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamInflationLagDayType(40352)</li>
     *   <li>UnderlyingPaymentStreamInflationLagDayType(40641)</li>
     *   <li>LegProtectionTermEventDayType(41631)</li>
     * </ul>
     */
    public static class PaymentStreamInflationLagDayTypeValues {

        public static final int Business            = 0;
        public static final int Calendar            = 1;
        public static final int CommodityBusiness   = 2;
        public static final int CurrencyBusiness    = 3;
        public static final int ExchangeBusiness    = 4;
        public static final int ScheduledTradingDay = 5;

        private PaymentStreamInflationLagDayTypeValues() {
        }

    }

    /**
     * Values for PaymentStreamInflationInterpolationMethod(40811).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamInflationInterpolationMethod(40353)</li>
     *   <li>UnderlyingPaymentStreamInflationInterpolationMethod(40642)</li>
     *   <li>LegMakeWholeInterpolationMethod(42398)</li>
     *   <li>LegPaymentStreamInterpolationMethod(42402)</li>
     *   <li>MakeWholeInterpolationMethod(42597)</li>
     *   <li>PaymentStreamInterpolationMethod(42603)</li>
     *   <li>UnderlyingMakeWholeInterpolationMethod(42894)</li>
     *   <li>UnderlyingPaymentStreamInterpolationMethod(42898)</li>
     * </ul>
     */
    public static class PaymentStreamInflationInterpolationMethodValues {

        public static final int None            = 0;
        public static final int LinearZeroYield = 1;

        private PaymentStreamInflationInterpolationMethodValues() {
        }

    }

    /**
     * Values for PaymentStreamFRADiscounting(40816).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamFRADiscounting(40358)</li>
     *   <li>UnderlyingPaymentStreamFRADiscounting(40647)</li>
     * </ul>
     */
    public static class PaymentStreamFRADiscountingValues {

        public static final int None = 0;
        public static final int ISDA = 1;
        public static final int AFMA = 2;

        private PaymentStreamFRADiscountingValues() {
        }

    }

    /**
     * Values for NonDeliverableFixingDateType(40827).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegNonDeliverableFixingDateType(40369)</li>
     *   <li>UnderlyingNonDeliverableFixingDateType(40658)</li>
     *   <li>LegPaymentStreamCompoundingDateType(42407)</li>
     *   <li>LegPaymentStreamFixingDateType(42461)</li>
     *   <li>LegReturnRateValuationDateType(42573)</li>
     *   <li>PaymentStreamCompoundingDateType(42608)</li>
     *   <li>PaymentStreamFixingDateType(42662)</li>
     *   <li>ReturnRateValuationDateType(42774)</li>
     *   <li>UnderlyingPaymentStreamCompoundingDateType(42903)</li>
     *   <li>UnderlyingPaymentStreamFixingDateType(42957)</li>
     *   <li>UnderlyingReturnRateValuationDateType(43073)</li>
     * </ul>
     */
    public static class NonDeliverableFixingDateTypeValues {

        public static final int Unadjusted = 0;
        public static final int Adjusted   = 1;

        private NonDeliverableFixingDateTypeValues() {
        }

    }

    /**
     * Values for PaymentScheduleType(40829).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentScheduleType(40375)</li>
     *   <li>UnderlyingPaymentScheduleType(40665)</li>
     * </ul>
     */
    public static class PaymentScheduleTypeValues {

        public static final int Notional                            = 0;
        public static final int CashFlow                            = 1;
        public static final int FXLinkedNotional                    = 2;
        public static final int FixedRate                           = 3;
        public static final int FutureValueNotional                 = 4;
        public static final int KnownAmount                         = 5;
        public static final int FloatingRateMultiplier              = 6;
        public static final int Spread                              = 7;
        public static final int CapRate                             = 8;
        public static final int FloorRate                           = 9;
        public static final int NonDeliverableSettlPaymentDates     = 10;
        public static final int NonDeliverableSettlCalculationDates = 11;
        public static final int NonDeliverableFXFixingDates         = 12;
        public static final int SettlPeriodNotnl                    = 13;
        public static final int SettlPeriodPx                       = 14;
        public static final int CalcPeriod                          = 15;
        public static final int DividendAccrualRateMultiplier       = 16;
        public static final int DividendAccrualRateSpread           = 17;
        public static final int DividendAccrualCapRate              = 18;
        public static final int DividendAccrualFloorRate            = 19;
        public static final int CompoundingRateMultiplier           = 20;
        public static final int CompoundingRateSpread               = 21;
        public static final int CompoundingCapRate                  = 22;
        public static final int CompoundingFloorRate                = 23;

        private PaymentScheduleTypeValues() {
        }

    }

    /**
     * Values for PaymentScheduleStepRelativeTo(40849).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentScheduleStepRelativeTo(40395)</li>
     *   <li>UnderlyingPaymentScheduleStepRelativeTo(40685)</li>
     * </ul>
     */
    public static class PaymentScheduleStepRelativeToValues {

        public static final int Initial  = 0;
        public static final int Previous = 1;

        private PaymentScheduleStepRelativeToValues() {
        }

    }

    /**
     * Values for PaymentStubType(40873).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentScheduleStubType(40376)</li>
     *   <li>LegPaymentStubType(40419)</li>
     *   <li>UnderlyingPaymentScheduleStubType(40666)</li>
     *   <li>UnderlyingPaymentStubType(40709)</li>
     *   <li>PaymentScheduleStubType(40830)</li>
     * </ul>
     */
    public static class PaymentStubTypeValues {

        public static final int Initial            = 0;
        public static final int Final              = 1;
        public static final int CompoundingInitial = 2;
        public static final int CompoundingFinal   = 3;

        private PaymentStubTypeValues() {
        }

    }

    /**
     * Values for PaymentStubLength(40874).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStubLength(40420)</li>
     *   <li>UnderlyingPaymentStubLength(40710)</li>
     * </ul>
     */
    public static class PaymentStubLengthValues {

        public static final int Short = 0;
        public static final int Long  = 1;

        private PaymentStubLengthValues() {
        }

    }

    /**
     * Values for PaymentStreamPaymentDateOffsetDayType(40920).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>UnderlyingStreamEffectiveDateOffsetDayType(40063)</li>
     *   <li>StreamTerminationDateOffsetDayType(40071)</li>
     *   <li>ProvisionCashSettlValueDateOffsetDayType(40121)</li>
     *   <li>ProvisionOptionExerciseStartDateOffsetDayType(40133)</li>
     *   <li>ProvisionOptionExpirationDateOffsetDayType(40151)</li>
     *   <li>ProvisionOptionRelevantUnderlyingDateOffsetDayType(40161)</li>
     *   <li>ProvisionCashSettlPaymentDateOffsetDayType(40168)</li>
     *   <li>LegStreamEffectiveDateOffsetDayType(40255)</li>
     *   <li>LegStreamTerminationDateOffsetDayType(40263)</li>
     *   <li>LegPaymentStreamPaymentDateOffsetDayType(40302)</li>
     *   <li>LegPaymentStreamInitialFixingDateOffsetDayType(40314)</li>
     *   <li>LegPaymentStreamFixingDateOffsetDayType(40321)</li>
     *   <li>LegPaymentStreamRateCutoffDateOffsetDayType(40325)</li>
     *   <li>LegPaymentStreamNonDeliverableFixingDatesOffsetDayType(40365)</li>
     *   <li>LegPaymentScheduleFixingDateOffsetDayType(40403)</li>
     *   <li>LegPaymentScheduleInterimExchangeDatesOffsetDayType(40412)</li>
     *   <li>LegProvisionOptionExerciseStartDateOffsetDayType(40486)</li>
     *   <li>LegProvisionOptionExpirationDateOffsetDayType(40504)</li>
     *   <li>LegProvisionOptionRelevantUnderlyingDateOffsetDayType(40514)</li>
     *   <li>LegProvisionCashSettlPaymentDateOffsetDayType(40521)</li>
     *   <li>LegProvisionCashSettlValueDateOffsetDayType(40531)</li>
     *   <li>UnderlyingStreamTerminationDateOffsetDayType(40554)</li>
     *   <li>UnderlyingPaymentStreamPaymentDateOffsetDayType(40591)</li>
     *   <li>UnderlyingPaymentStreamInitialFixingDateOffsetDayType(40603)</li>
     *   <li>UnderlyingPaymentStreamFixingDateOffsetDayType(40610)</li>
     *   <li>UnderlyingPaymentStreamRateCutoffDateOffsetDayType(40614)</li>
     *   <li>UnderlyingPaymentStreamNonDeliverableFixingDatesOffsetDayType(40654)</li>
     *   <li>UnderlyingPaymentScheduleFixingDateOffsetDayType(40693)</li>
     *   <li>UnderlyingPaymentScheduleInterimExchangeDatesOffsetDayType(40702)</li>
     *   <li>PaymentStreamInitialFixingDateOffsetDayType(40772)</li>
     *   <li>PaymentStreamFixingDateOffsetDayType(40779)</li>
     *   <li>PaymentStreamRateCutoffDateOffsetDayType(40783)</li>
     *   <li>PaymentStreamNonDeliverableFixingDatesOffsetDayType(40823)</li>
     *   <li>PaymentScheduleFixingDateOffsetDayType(40857)</li>
     *   <li>PaymentScheduleInterimExchangeDatesOffsetDayType(40866)</li>
     *   <li>StreamEffectiveDateOffsetDayType(40913)</li>
     *   <li>OptionExerciseStartDateOffsetDayType(41128)</li>
     *   <li>OptionExerciseExpirationDateOffsetDayType(41149)</li>
     *   <li>LegOptionExerciseStartDateOffsetDayType(41503)</li>
     *   <li>UnderlyingOptionExerciseStartDateOffsetDayType(41832)</li>
     *   <li>UnderlyingProvisionCashSettlPaymentDateOffsetDayType(42096)</li>
     *   <li>UnderlyingProvisionCashSettlValueDateOffsetDayType(42110)</li>
     *   <li>UnderlyingProvisionOptionExerciseStartDateOffsetDayType(42124)</li>
     *   <li>UnderlyingProvisionOptionExpirationDateOffsetDayType(42138)</li>
     *   <li>UnderlyingProvisionOptionRelevantUnderlyingDateOffsetDayType(42147)</li>
     *   <li>CashSettlDateOffsetDayType(42212)</li>
     *   <li>DividendAccrualPaymentDateOffsetDayType(42241)</li>
     *   <li>DividendFXTriggerDateOffsetDayType(42268)</li>
     *   <li>DividendPeriodValuationDateOffsetDayType(42285)</li>
     *   <li>DividendPeriodPaymentDateOffsetDayType(42291)</li>
     *   <li>LegCashSettlDateOffsetDayType(42304)</li>
     *   <li>LegDividendAccrualPaymentDateOffsetDayType(42333)</li>
     *   <li>LegDividendFXTriggerDateOffsetDayType(42360)</li>
     *   <li>LegDividendPeriodValuationDateOffsetDayType(42377)</li>
     *   <li>LegDividendPeriodPaymentDateOffsetDayType(42383)</li>
     *   <li>LegPaymentStreamCompoundingDatesOffsetDayType(42412)</li>
     *   <li>LegPaymentStreamCompoundingEndDateOffsetDayType(42425)</li>
     *   <li>LegPaymentStreamCompoundingStartDateOffsetDayType(42449)</li>
     *   <li>LegPaymentStreamFinalPricePaymentDateOffsetDayType(42457)</li>
     *   <li>LegPaymentStreamFirstObservationDateOffsetDayType(42464)</li>
     *   <li>LegPaymentStubEndDateOffsetDayType(42493)</li>
     *   <li>LegPaymentStubStartDateOffsetDayType(42502)</li>
     *   <li>LegReturnRateValuationDateOffsetDayType(42513)</li>
     *   <li>LegReturnRateValuationStartDateOffsetDayType(42518)</li>
     *   <li>LegReturnRateValuationEndDateOffsetDayType(42524)</li>
     *   <li>LegSettlMethodElectionDateOffsetDayType(42579)</li>
     *   <li>PaymentStreamCompoundingDatesOffsetDayType(42613)</li>
     *   <li>PaymentStreamCompoundingEndDateOffsetDayType(42626)</li>
     *   <li>PaymentStreamCompoundingStartDateOffsetDayType(42650)</li>
     *   <li>PaymentStreamFinalPricePaymentDateOffsetDayType(42658)</li>
     *   <li>PaymentStreamFirstObservationDateOffsetDayType(42665)</li>
     *   <li>PaymentStubEndDateOffsetDayType(42694)</li>
     *   <li>PaymentStubStartDateOffsetDayType(42703)</li>
     *   <li>ReturnRateValuationDateOffsetDayType(42714)</li>
     *   <li>ReturnRateValuationStartDateOffsetDayType(42719)</li>
     *   <li>ReturnRateValuationEndDateOffsetDayType(42725)</li>
     *   <li>SettlMethodElectionDateOffsetDayType(42782)</li>
     *   <li>UnderlyingCashSettlDateOffsetDayType(42795)</li>
     *   <li>UnderlyingDividendAccrualPaymentDateOffsetDayType(42822)</li>
     *   <li>UnderlyingDividendFXTriggerDateOffsetDayType(42849)</li>
     *   <li>UnderlyingDividendPeriodValuationDateOffsetDayType(42873)</li>
     *   <li>UnderlyingDividendPeriodPaymentDateOffsetDayType(42879)</li>
     *   <li>UnderlyingPaymentStreamCompoundingDatesOffsetDayType(42908)</li>
     *   <li>UnderlyingPaymentStreamCompoundingEndDateOffsetDayType(42921)</li>
     *   <li>UnderlyingPaymentStreamCompoundingStartDateOffsetDayType(42945)</li>
     *   <li>UnderlyingPaymentStreamFinalPricePaymentDateOffsetDayType(42953)</li>
     *   <li>UnderlyingPaymentStreamFirstObservationDateOffsetDayType(42960)</li>
     *   <li>UnderlyingPaymentStubEndDateOffsetDayType(42989)</li>
     *   <li>UnderlyingPaymentStubStartDateOffsetDayType(42998)</li>
     *   <li>UnderlyingReturnRateValuationDateOffsetDayType(43013)</li>
     *   <li>UnderlyingReturnRateValuationStartDateOffsetDayType(43018)</li>
     *   <li>UnderlyingReturnRateValuationEndDateOffsetDayType(43024)</li>
     *   <li>UnderlyingSettlMethodElectionDateOffsetDayType(43081)</li>
     * </ul>
     */
    public static class PaymentStreamPaymentDateOffsetDayTypeValues {

        public static final int Business            = 0;
        public static final int Calendar            = 1;
        public static final int CommodityBusiness   = 2;
        public static final int CurrencyBusiness    = 3;
        public static final int ExchangeBusiness    = 4;
        public static final int ScheduledTradingDay = 5;

        private PaymentStreamPaymentDateOffsetDayTypeValues() {
        }

    }

    /**
     * Values for BusinessDayConvention(40921).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>BusinessDayType(2581)</li>
     *   <li>UnderlyingStreamEffectiveDateBusinessDayConvention(40058)</li>
     *   <li>StreamTerminationDateBusinessDayConvention(40066)</li>
     *   <li>StreamCalculationPeriodBusinessDayConvention(40073)</li>
     *   <li>StreamFirstPeriodStartDateBusinessDayConvention(40076)</li>
     *   <li>ProvisionDateBusinessDayConvention(40093)</li>
     *   <li>ProvisionCashSettlValueDateBusinessDayConvention(40116)</li>
     *   <li>ProvisionOptionExerciseBusinessDayConvention(40123)</li>
     *   <li>ProvisionOptionExpirationDateBusinessDayConvention(40146)</li>
     *   <li>ProvisionOptionRelevantUnderlyingDateBusinessDayConvention(40156)</li>
     *   <li>ProvisionCashSettlPaymentDateBusinessDayConvention(40163)</li>
     *   <li>PaymentBusinessDayConvention(40220)</li>
     *   <li>LegStreamEffectiveDateBusinessDayConvention(40250)</li>
     *   <li>LegStreamTerminationDateBusinessDayConvention(40258)</li>
     *   <li>LegStreamCalculationPeriodBusinessDayConvention(40265)</li>
     *   <li>LegStreamFirstPeriodStartDateBusinessDayConvention(40268)</li>
     *   <li>LegPaymentStreamPaymentDateBusinessDayConvention(40292)</li>
     *   <li>LegPaymentStreamResetDateBusinessDayConvention(40304)</li>
     *   <li>LegPaymentStreamInitialFixingDateBusinessDayConvention(40310)</li>
     *   <li>LegPaymentStreamFixingDateBusinessDayConvention(40317)</li>
     *   <li>LegPaymentStreamNonDeliverableFixingDatesBusinessDayConvention(40360)</li>
     *   <li>LegPaymentScheduleFixingDateBusinessDayConvention(40399)</li>
     *   <li>LegPaymentScheduleInterimExchangeDatesBusinessDayConvention(40408)</li>
     *   <li>LegProvisionDateBusinessDayConvention(40451)</li>
     *   <li>LegProvisionOptionExerciseBusinessDayConvention(40476)</li>
     *   <li>LegProvisionOptionExpirationDateBusinessDayConvention(40499)</li>
     *   <li>LegProvisionOptionRelevantUnderlyingDateBusinessDayConvention(40509)</li>
     *   <li>LegProvisionCashSettlPaymentDateBusinessDayConvention(40516)</li>
     *   <li>LegProvisionCashSettlValueDateBusinessDayConvention(40526)</li>
     *   <li>UnderlyingStreamTerminationDateBusinessDayConvention(40549)</li>
     *   <li>UnderlyingStreamCalculationPeriodBusinessDayConvention(40556)</li>
     *   <li>UnderlyingStreamFirstPeriodStartDateBusinessDayConvention(40559)</li>
     *   <li>UnderlyingPaymentStreamPaymentDateBusinessDayConvention(40581)</li>
     *   <li>UnderlyingPaymentStreamResetDateBusinessDayConvention(40593)</li>
     *   <li>UnderlyingPaymentStreamInitialFixingDateBusinessDayConvention(40599)</li>
     *   <li>UnderlyingPaymentStreamFixingDateBusinessDayConvention(40606)</li>
     *   <li>UnderlyingPaymentStreamNonDeliverableFixingDatesBizDayConvention(40649)</li>
     *   <li>UnderlyingPaymentScheduleFixingDateBusinessDayCnvtn(40689)</li>
     *   <li>UnderlyingPaymentScheduleInterimExchangeDatesBizDayConvention(40698)</li>
     *   <li>PaymentStreamPaymentDateBusinessDayConvention(40751)</li>
     *   <li>PaymentStreamResetDateBusinessDayConvention(40762)</li>
     *   <li>PaymentStreamInitialFixingDateBusinessDayConvention(40768)</li>
     *   <li>PaymentStreamFixingDateBusinessDayConvention(40775)</li>
     *   <li>PaymentStreamNonDeliverableFixingDatesBusinessDayConvention(40818)</li>
     *   <li>PaymentScheduleFixingDateBusinessDayConvention(40853)</li>
     *   <li>PaymentScheduleInterimExchangeDatesBusinessDayConvention(40862)</li>
     *   <li>StreamEffectiveDateBusinessDayConvention(40908)</li>
     *   <li>LegBusinessDayConvention(40925)</li>
     *   <li>UnderlyingBusinessDayConvention(40964)</li>
     *   <li>ComplexEventDateBusinessDayConvention(41025)</li>
     *   <li>OptionExerciseBusinessDayConvention(41118)</li>
     *   <li>OptionExerciseExpirationDateBusinessDayConvention(41142)</li>
     *   <li>PaymentStreamPricingBusinessDayConvention(41217)</li>
     *   <li>PricingDateBusinessDayConvention(41233)</li>
     *   <li>StreamCommoditySettlDateBusinessDayConvention(41269)</li>
     *   <li>LegComplexEventDateBusinessDayConvention(41394)</li>
     *   <li>LegOptionExerciseBusinessDayConvention(41493)</li>
     *   <li>LegOptionExerciseExpirationDateBusinessDayConvention(41517)</li>
     *   <li>LegPaymentStreamPricingBusinessDayConvention(41586)</li>
     *   <li>LegPricingDateBusinessDayConvention(41610)</li>
     *   <li>LegStreamCommoditySettlDateBusinessDayConvention(41666)</li>
     *   <li>UnderlyingComplexEventDateBusinessDayConvention(41744)</li>
     *   <li>UnderlyingOptionExerciseBusinessDayConvention(41822)</li>
     *   <li>UnderlyingOptionExerciseExpirationDateBusinessDayConvention(41846)</li>
     *   <li>UnderlyingPaymentStreamPricingBusinessDayConvention(41934)</li>
     *   <li>UnderlyingPricingDateBusinessDayConvention(41950)</li>
     *   <li>UnderlyingStreamCommoditySettlDateBusinessDayConvention(41982)</li>
     *   <li>UnderlyingProvisionCashSettlPaymentDateBusinessDayConvention(42092)</li>
     *   <li>UnderlyingProvisionCashSettlValueDateBusinessDayConvention(42106)</li>
     *   <li>UnderlyingProvisionOptionExerciseBusinessDayConvention(42115)</li>
     *   <li>UnderlyingProvisionOptionExpirationDateBusinessDayConvention(42134)</li>
     *   <li>UnderlyingProvisionOptionRelevantUnderlyingDateBizDayConvention(42143)</li>
     *   <li>UnderlyingProvisionDateBusinessDayConvention(42152)</li>
     *   <li>CashSettlDateBusinessDayConvention(42208)</li>
     *   <li>DividendAccrualPaymeentDateBusinessDayConvention(42243)</li>
     *   <li>DividendFXTriggerDateBusinessDayConvention(42270)</li>
     *   <li>DividendPeriodBusinessDayConvention(42280)</li>
     *   <li>LegCashSettlDateBusinessDayConvention(42300)</li>
     *   <li>LegDividendAccrualPaymentDateBusinessDayConvention(42335)</li>
     *   <li>LegDividendFXTriggerDateBusinessDayConvention(42362)</li>
     *   <li>LegDividendPeriodBusinessDayConvention(42372)</li>
     *   <li>LegPaymentStreamCompoundingDatesBusinessDayConvention(42408)</li>
     *   <li>LegPaymentStubEndDateBusinessDayConvention(42489)</li>
     *   <li>LegPaymentStubStartDateBusinessDayConvention(42498)</li>
     *   <li>LegReturnRateValuationDateBusinessDayConvention(42529)</li>
     *   <li>LegSettlMethodElectionDateBusinessDayConvention(42575)</li>
     *   <li>PaymentStreamCompoundingDatesBusinessDayConvention(42609)</li>
     *   <li>PaymentStubEndDateBusinessDayConvention(42690)</li>
     *   <li>PaymentStubStartDateBusinessDayConvention(42699)</li>
     *   <li>ReturnRateValuationDateBusinessDayConvention(42730)</li>
     *   <li>SettlMethodElectionDateBusinessDayConvention(42778)</li>
     *   <li>UnderlyingCashSettlDateBusinessDayConvention(42791)</li>
     *   <li>UnderlyingDividendAccrualPaymentDateBusinessDayConvention(42824)</li>
     *   <li>UnderlyingDividendFXTriggerDateBusinessDayConvention(42851)</li>
     *   <li>UnderlyingDividendPeriodBusinessDayConvention(42868)</li>
     *   <li>UnderlyingPaymentStreamCompoundingDatesBusinessDayConvention(42904)</li>
     *   <li>UnderlyingPaymentStubEndDateBusinessDayConvention(42985)</li>
     *   <li>UnderlyingPaymentStubStartDateBusinessDayConvention(42994)</li>
     *   <li>UnderlyingReturnRateValuationDateBusinessDayConvention(43029)</li>
     *   <li>UnderlyingSettlMethodElectionDateBusinessDayConvention(43077)</li>
     * </ul>
     */
    public static class BusinessDayConventionValues {

        public static final int NotApplicable        = 0;
        public static final int None                 = 1;
        public static final int FollowingDay         = 2;
        public static final int FloatingRateNote     = 3;
        public static final int ModifiedFollowingDay = 4;
        public static final int PrecedingDay         = 5;
        public static final int ModifiedPrecedingDay = 6;
        public static final int NearestDay           = 7;

        private BusinessDayConventionValues() {
        }

    }

    /**
     * Values for DateRollConvention(40922).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>StreamCalculationRollConvention(40084)</li>
     *   <li>LegStreamCalculationRollConvention(40276)</li>
     *   <li>LegPaymentStreamPaymentRollConvention(40296)</li>
     *   <li>UnderlyingStreamCalculationRollConvention(40567)</li>
     *   <li>UnderlyingPaymentStreamPaymentRollConvention(40585)</li>
     *   <li>PaymentStreamPaymentRollConvention(40755)</li>
     *   <li>LegDateRollConvention(40926)</li>
     *   <li>UnderlyingDateRollConvention(40965)</li>
     *   <li>ComplexEventScheduleRollConvention(41036)</li>
     *   <li>OptionExerciseExpirationRollConvention(41148)</li>
     *   <li>LegComplexEventScheduleRollConvention(41405)</li>
     *   <li>LegOptionExerciseExpirationRollConvention(41523)</li>
     *   <li>UnderlyingComplexEventScheduleRollConvention(41755)</li>
     *   <li>UnderlyingOptionExerciseExpirationRollConvention(41852)</li>
     *   <li>LegPaymentStreamCompoundingRollConvention(42416)</li>
     *   <li>LegReturnRateValuationFrequencyRollConvention(42528)</li>
     *   <li>PaymentStreamCompoundingRollConvention(42617)</li>
     *   <li>ReturnRateValuationFrequencyRollConvention(42729)</li>
     *   <li>UnderlyingPaymentStreamCompoundingRollConvention(42912)</li>
     *   <li>UnderlyingReturnRateValuationFrequencyRollConvention(43028)</li>
     * </ul>
     */
    public static class DateRollConventionValues {

        public static final String FirstDay         = "1";
        public static final String SecondDay        = "2";
        public static final String ThirdDay         = "3";
        public static final String FourthDay        = "4";
        public static final String FifthDay         = "5";
        public static final String SixthDay         = "6";
        public static final String SeventhDay       = "7";
        public static final String EighthDay        = "8";
        public static final String NinthDay         = "9";
        public static final String TenthDay         = "10";
        public static final String EleventhDay      = "11";
        public static final String TwelvthDay       = "12";
        public static final String ThirteenthDay    = "13";
        public static final String ForteenthDay     = "14";
        public static final String FifteenthDay     = "15";
        public static final String SixteenthDay     = "16";
        public static final String SeventeenthDay   = "17";
        public static final String EighteenthDay    = "18";
        public static final String NineteenthDay    = "19";
        public static final String TwentiethDay     = "20";
        public static final String TwentyFirstDay   = "21";
        public static final String TwentySecondDay  = "22";
        public static final String TwentyThirdDay   = "23";
        public static final String TwentyFourthDay  = "24";
        public static final String TwentyFifthDay   = "25";
        public static final String TwentySixthDay   = "26";
        public static final String TwentySeventhDay = "27";
        public static final String TwentyEigthDa28y = "28";
        public static final String TwentyNinthDay   = "29";
        public static final String ThirtiethDay     = "30";
        public static final String EOM              = "EOM";
        public static final String FRN              = "FRN";
        public static final String IMM              = "IMM";
        public static final String IMMCAD           = "IMMCAD";
        public static final String IMMAUD           = "IMMAUD";
        public static final String IMMNZD           = "IMMNZD";
        public static final String SFE              = "SFE";
        public static final String NONE             = "NONE";
        public static final String TBILL            = "TBILL";
        public static final String MON              = "MON";
        public static final String TUE              = "TUE";
        public static final String WED              = "WED";
        public static final String THU              = "THU";
        public static final String FRI              = "FRI";
        public static final String SAT              = "SAT";
        public static final String SUN              = "SUN";

        private DateRollConventionValues() {
        }

    }

    /**
     * Values for PaymentSubType(40993).
     */
    public static class PaymentSubTypeValues {

        public static final int Initial      = 0;
        public static final int Intermediate = 1;
        public static final int Final        = 2;
        public static final int Prepaid      = 3;
        public static final int Postpaid     = 4;
        public static final int Variable     = 5;
        public static final int Fixed        = 6;
        public static final int Swap         = 7;
        public static final int Conditional  = 8;
        public static final int FixedRate    = 9;
        public static final int FloatingRate = 10;

        private PaymentSubTypeValues() {
        }

    }

    /**
     * Values for ComplexEventPeriodType(41011).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegComplexEventPeriodType(41380)</li>
     *   <li>UnderlyingComplexEventPeriodType(41730)</li>
     * </ul>
     */
    public static class ComplexEventPeriodTypeValues {

        public static final int AsianOut     = 0;
        public static final int AsianIn      = 1;
        public static final int BarrierCap   = 2;
        public static final int BarrierFloor = 3;
        public static final int KnockOut     = 4;
        public static final int KnockIn      = 5;

        private ComplexEventPeriodTypeValues() {
        }

    }

    /**
     * Values for ComplexEventDateOffsetDayType(41024).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ComplexEventCreditEventDayType(41003)</li>
     *   <li>OptionExerciseEarliestDateOffsetDayType(41119)</li>
     *   <li>PaymentStreamPricingDayType(41213)</li>
     *   <li>StreamCommoditySettlDayType(41274)</li>
     *   <li>LegComplexEventCreditEventDayType(41372)</li>
     *   <li>LegComplexEventDateOffsetDayType(41393)</li>
     *   <li>LegOptionExerciseEarliestDateOffsetDayType(41494)</li>
     *   <li>LegOptionExerciseExpirationDateOffsetDayType(41524)</li>
     *   <li>LegPaymentStreamPricingDayType(41582)</li>
     *   <li>LegStreamCommoditySettlDayType(41671)</li>
     *   <li>UnderlyingComplexEventCreditEventDayType(41722)</li>
     *   <li>UnderlyingComplexEventDateOffsetDayType(41743)</li>
     *   <li>UnderlyingOptionExerciseEarliestDateOffsetDayType(41823)</li>
     *   <li>UnderlyingOptionExerciseExpirationDateOffsetDayType(41853)</li>
     *   <li>UnderlyingPaymentStreamPricingDayType(41930)</li>
     *   <li>UnderlyingStreamCommoditySettlDayType(41987)</li>
     * </ul>
     */
    public static class ComplexEventDateOffsetDayTypeValues {

        public static final int Business            = 0;
        public static final int Calendar            = 1;
        public static final int CommodityBusiness   = 2;
        public static final int CurrencyBusiness    = 3;
        public static final int ExchangeBusiness    = 4;
        public static final int ScheduledTradingDay = 5;

        private ComplexEventDateOffsetDayTypeValues() {
        }

    }

    /**
     * Values for DeliveryScheduleType(41038).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDeliveryScheduleType(41409)</li>
     *   <li>UnderlyingDeliveryScheduleType(41757)</li>
     * </ul>
     */
    public static class DeliveryScheduleTypeValues {

        public static final int Notional             = 0;
        public static final int Delivery             = 1;
        public static final int PhysicalSettlPeriods = 2;

        private DeliveryScheduleTypeValues() {
        }

    }

    /**
     * Values for DeliveryScheduleToleranceType(41046).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DeliveryStreamToleranceType(41074)</li>
     *   <li>LegDeliveryScheduleToleranceType(41417)</li>
     *   <li>LegDeliveryStreamToleranceType(41445)</li>
     *   <li>UnderlyingDeliveryScheduleToleranceType(41765)</li>
     *   <li>UnderlyingDeliveryStreamToleranceType(41793)</li>
     * </ul>
     */
    public static class DeliveryScheduleToleranceTypeValues {

        public static final int Absolute   = 0;
        public static final int Percentage = 1;

        private DeliveryScheduleToleranceTypeValues() {
        }

    }

    /**
     * Values for DeliveryScheduleSettlFlowType(41049).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>StreamCommoditySettlFlowType(41292)</li>
     *   <li>LegDeliveryScheduleSettlFlowType(41420)</li>
     *   <li>LegStreamCommoditySettlFlowType(41689)</li>
     *   <li>UnderlyingDeliveryScheduleSettlFlowType(41768)</li>
     *   <li>UnderlyingStreamCommoditySettlFlowType(42005)</li>
     * </ul>
     */
    public static class DeliveryScheduleSettlFlowTypeValues {

        public static final int AllTimes   = 0;
        public static final int OnPeak     = 1;
        public static final int OffPeak    = 2;
        public static final int Base       = 3;
        public static final int BlockHours = 4;
        public static final int Other      = 5;

        private DeliveryScheduleSettlFlowTypeValues() {
        }

    }

    /**
     * Values for DeliveryScheduleSettlHolidaysProcessingInstruction(41050).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>StreamCommoditySettlHolidaysProcessingInstruction(41300)</li>
     *   <li>LegDeliveryScheduleSettlHolidaysProcessingInstruction(41421)</li>
     *   <li>LegStreamCommoditySettlHolidaysProcessingInstruction(41697)</li>
     *   <li>UnderlyingDeliveryScheduleSettlHolidaysProcessingInstruction(41769)</li>
     *   <li>UnderlyingStreamCommoditySettlHolidaysProcessingInstruction(42013)</li>
     * </ul>
     */
    public static class DeliveryScheduleSettlHolidaysProcessingInstructionValues {

        public static final int DoNotIncludeHolidays = 0;
        public static final int IncludeHolidays      = 1;

        private DeliveryScheduleSettlHolidaysProcessingInstructionValues() {
        }

    }

    /**
     * Values for DeliveryScheduleSettlDay(41052).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>StreamCommoditySettlDay(41284)</li>
     *   <li>LegDeliveryScheduleSettlDay(41423)</li>
     *   <li>LegStreamCommoditySettlDay(41681)</li>
     *   <li>UnderlyingDeliveryScheduleSettlDay(41771)</li>
     *   <li>UnderlyingStreamCommoditySettlDay(41997)</li>
     * </ul>
     */
    public static class DeliveryScheduleSettlDayValues {

        public static final int Monday      = 1;
        public static final int Tuesday     = 2;
        public static final int Wednesday   = 3;
        public static final int Thursday    = 4;
        public static final int Friday      = 5;
        public static final int Saturday    = 6;
        public static final int Sunday      = 7;
        public static final int AllWeekdays = 8;
        public static final int AllDays     = 9;
        public static final int AllWeekends = 10;

        private DeliveryScheduleSettlDayValues() {
        }

    }

    /**
     * Values for DeliveryScheduleSettlTimeType(41057).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDeliveryScheduleSettlTimeType(41428)</li>
     *   <li>StreamCommoditySettlTimeType(41588)</li>
     *   <li>UnderlyingDeliveryScheduleSettlTimeType(41776)</li>
     *   <li>LegStreamCommoditySettlTimeType(41935)</li>
     *   <li>UnderlyingStreamCommoditySettlTimeType(41936)</li>
     * </ul>
     */
    public static class DeliveryScheduleSettlTimeTypeValues {

        public static final int Hour      = 0;
        public static final int Timestamp = 1;

        private DeliveryScheduleSettlTimeTypeValues() {
        }

    }

    /**
     * Values for DeliveryStreamType(41058).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDeliveryStreamType(41429)</li>
     *   <li>UnderlyingDeliveryStreamType(41777)</li>
     * </ul>
     */
    public static class DeliveryStreamTypeValues {

        public static final int Periodic = 0;
        public static final int Initial  = 1;
        public static final int Single   = 2;

        private DeliveryStreamTypeValues() {
        }

    }

    /**
     * Values for DeliveryStreamDeliveryRestriction(41063).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDeliveryStreamDeliveryRestriction(41434)</li>
     *   <li>UnderlyingDeliveryStreamDeliveryRestriction(41782)</li>
     * </ul>
     */
    public static class DeliveryStreamDeliveryRestrictionValues {

        public static final int Firm         = 1;
        public static final int NonFirm      = 2;
        public static final int ForceMajeure = 3;
        public static final int SystemFirm   = 4;
        public static final int UnitFirm     = 5;

        private DeliveryStreamDeliveryRestrictionValues() {
        }

    }

    /**
     * Values for DeliveryStreamTitleTransferCondition(41069).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDeliveryStreamTitleTransferCondition(41440)</li>
     *   <li>UnderlyingDeliveryStreamTitleTransferCondition(41788)</li>
     * </ul>
     */
    public static class DeliveryStreamTitleTransferConditionValues {

        public static final int Transfers       = 0;
        public static final int DoesNotTransfer = 1;

        private DeliveryStreamTitleTransferConditionValues() {
        }

    }

    /**
     * Values for DeliveryStreamToleranceOptionSide(41075).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDeliveryStreamToleranceOptionSide(41446)</li>
     *   <li>UnderlyingDeliveryStreamToleranceOptionSide(41794)</li>
     * </ul>
     */
    public static class DeliveryStreamToleranceOptionSideValues {

        public static final int Buyer  = 1;
        public static final int Seller = 2;

        private DeliveryStreamToleranceOptionSideValues() {
        }

    }

    /**
     * Values for DeliveryStreamElectingPartySide(41080).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DeliveryStreamDeliveryContingentPartySide(41065)</li>
     *   <li>LegDeliveryStreamDeliveryContingentPartySide(41436)</li>
     *   <li>LegDeliveryStreamElectingPartySide(41451)</li>
     *   <li>UnderlyingDeliveryStreamDeliveryContingentPartySide(41784)</li>
     *   <li>UnderlyingDeliveryStreamElectingPartySide(41799)</li>
     * </ul>
     */
    public static class DeliveryStreamElectingPartySideValues {

        public static final int Buyer  = 0;
        public static final int Seller = 1;

        private DeliveryStreamElectingPartySideValues() {
        }

    }

    /**
     * Values for MarketDisruptionProvision(41087).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegMarketDisruptionProvision(41462)</li>
     *   <li>UnderlyingMarketDisruptionProvision(41859)</li>
     * </ul>
     */
    public static class MarketDisruptionProvisionValues {

        public static final int NotApplicable       = 0;
        public static final int Applicable          = 1;
        public static final int AsInMasterAgreement = 2;
        public static final int AsInConfirmation    = 3;

        private MarketDisruptionProvisionValues() {
        }

    }

    /**
     * Values for MarketDisruptionFallbackProvision(41088).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegMarketDisruptionFallbackProvision(41463)</li>
     *   <li>UnderlyingMarketDisruptionFallbackProvision(41860)</li>
     * </ul>
     */
    public static class MarketDisruptionFallbackProvisionValues {

        public static final int MasterAgreement = 0;
        public static final int Confirmation    = 1;

        private MarketDisruptionFallbackProvisionValues() {
        }

    }

    /**
     * Values for MarketDisruptionFallbackUnderlierType(41097).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegMarketDisruptionFallbackUnderlierType(41472)</li>
     *   <li>UnderlyingMarketDisruptionFallbackUnderlierType(41869)</li>
     * </ul>
     */
    public static class MarketDisruptionFallbackUnderlierTypeValues {

        public static final int Basket             = 0;
        public static final int Bond               = 1;
        public static final int Cash               = 2;
        public static final int Commodity          = 3;
        public static final int ConvertibleBond    = 4;
        public static final int Equity             = 5;
        public static final int ExchangeTradedFund = 6;
        public static final int Future             = 7;
        public static final int Index              = 8;
        public static final int Loan               = 9;
        public static final int Mortgage           = 10;
        public static final int MutualFund         = 11;

        private MarketDisruptionFallbackUnderlierTypeValues() {
        }

    }

    /**
     * Values for ExerciseConfirmationMethod(41111).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegExerciseConfirmationMethod(41486)</li>
     *   <li>UnderlyingExerciseConfirmationMethod(41815)</li>
     * </ul>
     */
    public static class ExerciseConfirmationMethodValues {

        public static final int NotRequired   = 0;
        public static final int NonElectronic = 1;
        public static final int Electronic    = 2;
        public static final int Unknown       = 3;

        private ExerciseConfirmationMethodValues() {
        }

    }

    /**
     * Values for OptionExerciseDateType(41139).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>OptionExerciseExpirationDateType(41154)</li>
     *   <li>PaymentStreamPaymentDateType(41222)</li>
     *   <li>PaymentStreamPricingDateType(41226)</li>
     *   <li>StreamCalculationPeriodDateType(41243)</li>
     *   <li>LegOptionExerciseDateType(41514)</li>
     *   <li>LegOptionExerciseExpirationDateType(41529)</li>
     *   <li>LegPaymentStreamPaymentDateType(41591)</li>
     *   <li>LegPaymentStreamPricingDateType(41595)</li>
     *   <li>LegStreamCalculationPeriodDateType(41640)</li>
     *   <li>UnderlyingOptionExerciseDateType(41843)</li>
     *   <li>UnderlyingOptionExerciseExpirationDateType(41858)</li>
     *   <li>UnderlyingPaymentStreamPaymentDateType(41939)</li>
     *   <li>UnderlyingPaymentStreamPricingDateType(41943)</li>
     *   <li>UnderlyingStreamCalculationPeriodDateType(41956)</li>
     * </ul>
     */
    public static class OptionExerciseDateTypeValues {

        public static final int Unadjusted = 0;
        public static final int Adjusted   = 1;

        private OptionExerciseDateTypeValues() {
        }

    }

    /**
     * Values for PaymentDateOffsetDayType(41159).
     */
    public static class PaymentDateOffsetDayTypeValues {

        public static final int Business  = 0;
        public static final int Calendar  = 1;
        public static final int Commodity = 2;
        public static final int Currency  = 3;
        public static final int Exchange  = 4;
        public static final int Scheduled = 5;

        private PaymentDateOffsetDayTypeValues() {
        }

    }

    /**
     * Values for PaymentForwardStartType(41160).
     */
    public static class PaymentForwardStartTypeValues {

        public static final int Prepaid  = 0;
        public static final int Postpaid = 1;
        public static final int Variable = 2;
        public static final int Fixed    = 3;

        private PaymentForwardStartTypeValues() {
        }

    }

    /**
     * Values for PaymentStreamSettlLevel(41199).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamSettlLevel(41568)</li>
     *   <li>UnderlyingPaymentStreamSettlLevel(41916)</li>
     * </ul>
     */
    public static class PaymentStreamSettlLevelValues {

        public static final int Average    = 0;
        public static final int Maximum    = 1;
        public static final int Minimum    = 2;
        public static final int Cumulative = 3;

        private PaymentStreamSettlLevelValues() {
        }

    }

    /**
     * Values for PaymentStreamRateSpreadType(41206).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>PaymentScheduleRateSpreadType(41169)</li>
     *   <li>LegPaymentScheduleRateSpreadType(41538)</li>
     *   <li>LegPaymentStreamRateSpreadType(41575)</li>
     *   <li>UnderlyingPaymentScheduleRateSpreadType(41886)</li>
     *   <li>UnderlyingPaymentStreamRateSpreadType(41923)</li>
     * </ul>
     */
    public static class PaymentStreamRateSpreadTypeValues {

        public static final int Absolute   = 0;
        public static final int Percentage = 1;

        private PaymentStreamRateSpreadTypeValues() {
        }

    }

    /**
     * Values for PaymentStreamPricingDayDistribution(41214).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>PaymentScheduleFixingDayDistribution(41174)</li>
     *   <li>LegPaymentScheduleFixingDayDistribution(41543)</li>
     *   <li>LegPaymentStreamPricingDayDistribution(41583)</li>
     *   <li>UnderlyingPaymentScheduleFixingDayDistribution(41891)</li>
     *   <li>UnderlyingPaymentStreamPricingDayDistribution(41931)</li>
     * </ul>
     */
    public static class PaymentStreamPricingDayDistributionValues {

        public static final int All         = 0;
        public static final int First       = 1;
        public static final int Last        = 2;
        public static final int Penultimate = 3;

        private PaymentStreamPricingDayDistributionValues() {
        }

    }

    /**
     * Values for PaymentStreamPricingDayOfWeek(41228).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>PaymentScheduleFixingDayOfWeek(41162)</li>
     *   <li>LegPaymentScheduleFixingDayOfWeek(41531)</li>
     *   <li>LegPaymentStreamPricingDayOfWeek(41597)</li>
     *   <li>UnderlyingPaymentScheduleFixingDayOfWeek(41879)</li>
     *   <li>UnderlyingPaymentStreamPricingDayOfWeek(41945)</li>
     * </ul>
     */
    public static class PaymentStreamPricingDayOfWeekValues {

        public static final int EveryDay  = 0;
        public static final int Monday    = 1;
        public static final int Tuesday   = 2;
        public static final int Wednesday = 3;
        public static final int Thursday  = 4;
        public static final int Friday    = 5;
        public static final int Saturday  = 6;
        public static final int Sunday    = 7;

        private PaymentStreamPricingDayOfWeekValues() {
        }

    }

    /**
     * Values for StreamCommodityNearbySettlDayUnit(41267).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegStreamCommodityNearbySettlDayUnit(41664)</li>
     *   <li>UnderlyingStreamCommodityNearbySettlDayUnit(41980)</li>
     * </ul>
     */
    public static class StreamCommodityNearbySettlDayUnitValues {

        public static final String Week  = "Wk";
        public static final String Month = "Mo";

        private StreamCommodityNearbySettlDayUnitValues() {
        }

    }

    /**
     * Values for StreamCommoditySettlDateRollUnit(41273).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegStreamCommoditySettlDateRollUnit(41670)</li>
     *   <li>UnderlyingStreamCommoditySettlDateRollUnit(41986)</li>
     * </ul>
     */
    public static class StreamCommoditySettlDateRollUnitValues {

        public static final String Day = "D";

        private StreamCommoditySettlDateRollUnitValues() {
        }

    }

    /**
     * Values for StreamCommodityDataSourceIDType(41282).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegStreamCommodityDataSourceIDType(41679)</li>
     *   <li>UnderlyingStreamCommodityDataSourceIDType(41995)</li>
     * </ul>
     */
    public static class StreamCommodityDataSourceIDTypeValues {

        public static final int City           = 0;
        public static final int Airport        = 1;
        public static final int WeatherStation = 2;
        public static final int WeatherIndex   = 3;

        private StreamCommodityDataSourceIDTypeValues() {
        }

    }

    /**
     * Values for StreamNotionalCommodityFrequency(41308).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>DeliveryScheduleNotionalCommodityFrequency(41042)</li>
     *   <li>LegDeliveryScheduleNotionalCommodityFrequency(41413)</li>
     *   <li>LegStreamNotionalCommodityFrequency(41705)</li>
     *   <li>UnderlyingDeliveryScheduleNotionalCommodityFrequency(41761)</li>
     *   <li>UnderlyingStreamNotionalCommodityFrequency(42021)</li>
     * </ul>
     */
    public static class StreamNotionalCommodityFrequencyValues {

        public static final int Term                 = 0;
        public static final int PerBusinessDay       = 1;
        public static final int PerCalculationPeriod = 2;
        public static final int PerSettlPeriod       = 3;
        public static final int PerCalendarDay       = 4;
        public static final int PerHour              = 5;
        public static final int PerMonth             = 6;

        private StreamNotionalCommodityFrequencyValues() {
        }

    }

    /**
     * Values for DeliveryStreamDeliveryPointSource(42192).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDeliveryStreamDeliveryPointSource(42194)</li>
     *   <li>UnderlyingDeliveryStreamDeliveryPointSource(42196)</li>
     * </ul>
     */
    public static class DeliveryStreamDeliveryPointSourceValues {

        public static final int Proprietary = 0;
        public static final int EIC         = 1;

        private DeliveryStreamDeliveryPointSourceValues() {
        }

    }

    /**
     * Values for CashSettlPriceDefault(42217).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegCashSettlPriceDefault(42309)</li>
     *   <li>UnderlyingCashSettlPriceDefault(42798)</li>
     * </ul>
     */
    public static class CashSettlPriceDefaultValues {

        public static final int Close = 0;
        public static final int Hedge = 1;

        private CashSettlPriceDefaultValues() {
        }

    }

    /**
     * Values for DividendEntitlementEvent(42246).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDividendEntitlementEvent(42338)</li>
     *   <li>UnderlyingDividendEntitlementEvent(42827)</li>
     * </ul>
     */
    public static class DividendEntitlementEventValues {

        public static final int ExDate     = 0;
        public static final int RecordDate = 1;

        private DividendEntitlementEventValues() {
        }

    }

    /**
     * Values for DividendAmountType(42247).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>ExtraordinaryDividendAmountType(42250)</li>
     *   <li>LegDividendAmountType(42339)</li>
     *   <li>LegExtraordinaryDividendAmountType(42342)</li>
     *   <li>UnderlyingDividendAmountType(42828)</li>
     *   <li>UnderlyingExtraordinaryDividendAmountType(42831)</li>
     * </ul>
     */
    public static class DividendAmountTypeValues {

        public static final int RecordAmount     = 0;
        public static final int ExAmount         = 1;
        public static final int PaidAmount       = 2;
        public static final int PerMasterConfirm = 3;

        private DividendAmountTypeValues() {
        }

    }

    /**
     * Values for NonCashDividendTreatment(42258).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegNonCashDividendTreatment(42350)</li>
     *   <li>UnderlyingNonCashDividendTreatment(42839)</li>
     * </ul>
     */
    public static class NonCashDividendTreatmentValues {

        public static final int PotentialAdjustment = 0;
        public static final int CashEquivalent      = 1;

        private NonCashDividendTreatmentValues() {
        }

    }

    /**
     * Values for DividendComposition(42259).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegDividendComposition(42351)</li>
     *   <li>UnderlyingDividendComposition(42840)</li>
     * </ul>
     */
    public static class DividendCompositionValues {

        public static final int EquityAmountReceiver = 0;
        public static final int CalculationAgent     = 1;

        private DividendCompositionValues() {
        }

    }

    /**
     * Values for PaymentStreamInterpolationPeriod(42604).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamInterpolationPeriod(42403)</li>
     *   <li>UnderlyingPaymentStreamInterpolationPeriod(42899)</li>
     * </ul>
     */
    public static class PaymentStreamInterpolationPeriodValues {

        public static final int Initial         = 0;
        public static final int InitialAndFinal = 1;
        public static final int Final           = 2;
        public static final int AnyPeriod       = 3;

        private PaymentStreamInterpolationPeriodValues() {
        }

    }

    /**
     * Values for PaymentStreamLinkStrikePriceType(42674).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamLinkStrikePriceType(42473)</li>
     *   <li>UnderlyingPaymentStreamLinkStrikePriceType(42969)</li>
     * </ul>
     */
    public static class PaymentStreamLinkStrikePriceTypeValues {

        public static final int Volatility = 0;
        public static final int Variance   = 1;

        private PaymentStreamLinkStrikePriceTypeValues() {
        }

    }

    /**
     * Values for PaymentStreamRealizedVarianceMethod(42679).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegPaymentStreamRealizedVarianceMethod(42478)</li>
     *   <li>UnderlyingPaymentStreamRealizedVarianceMethod(42974)</li>
     * </ul>
     */
    public static class PaymentStreamRealizedVarianceMethodValues {

        public static final int Previous = 0;
        public static final int Last     = 1;
        public static final int Both     = 2;

        private PaymentStreamRealizedVarianceMethodValues() {
        }

    }

    /**
     * Values for ProvisionBreakFeeElection(42707).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegProvisionBreakFeeElection(42506)</li>
     *   <li>UnderlyingProvisionBreakFeeElection(43002)</li>
     * </ul>
     */
    public static class ProvisionBreakFeeElectionValues {

        public static final int FlatFee                = 0;
        public static final int AmortizedFee           = 1;
        public static final int FundingFee             = 2;
        public static final int FlatAndFundingFee      = 3;
        public static final int AmortizedAndFundingFee = 4;

        private ProvisionBreakFeeElectionValues() {
        }

    }

    /**
     * Values for ReturnRateDateMode(42710).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegReturnRateDateMode(42509)</li>
     *   <li>UnderlyingReturnRateDateMode(43009)</li>
     * </ul>
     */
    public static class ReturnRateDateModeValues {

        public static final int PriceValuation    = 0;
        public static final int DividendValuation = 1;

        private ReturnRateDateModeValues() {
        }

    }

    /**
     * Values for ReturnRatePriceSequence(42736).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegReturnRatePriceSequence(42535)</li>
     *   <li>UnderlyingReturnRatePriceSequence(43035)</li>
     * </ul>
     */
    public static class ReturnRatePriceSequenceValues {

        public static final int Initial = 0;
        public static final int Interim = 1;
        public static final int Final   = 2;

        private ReturnRatePriceSequenceValues() {
        }

    }

    /**
     * Values for ReturnRateQuoteTimeType(42748).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegReturnRateQuoteTimeType(42547)</li>
     *   <li>LegReturnRateValuationTimeType(42555)</li>
     *   <li>ReturnRateValuationTimeType(42756)</li>
     *   <li>UnderlyingReturnRateQuoteTimeType(43047)</li>
     *   <li>UnderlyingReturnRateValuationTimeType(43055)</li>
     * </ul>
     */
    public static class ReturnRateQuoteTimeTypeValues {

        public static final int Open                            = 0;
        public static final int OfficialSettlPx                 = 1;
        public static final int Xetra                           = 2;
        public static final int Close                           = 3;
        public static final int DerivativesClose                = 4;
        public static final int High                            = 5;
        public static final int Low                             = 6;
        public static final int AsSpecifiedInMasterConfirmation = 7;

        private ReturnRateQuoteTimeTypeValues() {
        }

    }

    /**
     * Values for ReturnRateValuationPriceOption(42759).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegReturnRateValuationPriceOption(42558)</li>
     *   <li>UnderlyingReturnRateValuationPriceOption(43058)</li>
     * </ul>
     */
    public static class ReturnRateValuationPriceOptionValues {

        public static final int None         = 0;
        public static final int FuturesPrice = 1;
        public static final int OptionsPrice = 2;

        private ReturnRateValuationPriceOptionValues() {
        }

    }

    /**
     * Values for ReturnRatePriceBasis(42766).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegReturnRatePriceBasis(42565)</li>
     *   <li>UnderlyingReturnRatePriceBasis(43065)</li>
     * </ul>
     */
    public static class ReturnRatePriceBasisValues {

        public static final int Gross    = 0;
        public static final int Net      = 1;
        public static final int Accrued  = 2;
        public static final int CleanNet = 3;

        private ReturnRatePriceBasisValues() {
        }

    }

    /**
     * Values for ReturnRatePriceType(42769).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegReturnRatePriceType(42568)</li>
     *   <li>UnderlyingReturnRatePriceType(43068)</li>
     * </ul>
     */
    public static class ReturnRatePriceTypeValues {

        public static final int AbsoluteTerms        = 0;
        public static final int PercentageOfNotional = 1;

        private ReturnRatePriceTypeValues() {
        }

    }

    /**
     * Values for StreamNotionalAdjustments(42787).
     *
     * <p>The following fields also use these values:</p>
     * <ul>
     *   <li>LegStreamNotionalAdjustments(42586)</li>
     *   <li>UnderlyingStreamNotionalAdjustments(43086)</li>
     * </ul>
     */
    public static class StreamNotionalAdjustmentsValues {

        public static final int Execution            = 0;
        public static final int PortfolioRebalancing = 1;
        public static final int Standard             = 2;

        private StreamNotionalAdjustmentsValues() {
        }

    }

    /**
     * Values for BatchProcessMode(50002).
     */
    public static class BatchProcessModeValues {

        public static final int Update   = 0;
        public static final int Snapshot = 1;

        private BatchProcessModeValues() {
        }

    }

    private FIXLatestEnumerations() {
    }

}
