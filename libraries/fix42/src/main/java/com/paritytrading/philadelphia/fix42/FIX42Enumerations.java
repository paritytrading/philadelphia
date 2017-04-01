package com.paritytrading.philadelphia.fix42;

/**
 * Enumerations for FIX 4.2.
 */
public class FIX42Enumerations {

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

        public static final String Cancel  = "C";
        public static final String New     = "N";
        public static final String Replace = "R";

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

        public static final String StayOnOfferSide                            = "0";
        public static final String NotHeld                                    = "1";
        public static final String Work                                       = "2";
        public static final String GoAlong                                    = "3";
        public static final String OverTheDay                                 = "4";
        public static final String Held                                       = "5";
        public static final String ParticipateDoNotInitiate                   = "6";
        public static final String StrictScale                                = "7";
        public static final String TryToScale                                 = "8";
        public static final String StayOnBidSide                              = "9";
        public static final String NoCross                                    = "A";
        public static final String OKToCross                                  = "B";
        public static final String CallFirst                                  = "C";
        public static final String PercentOfVolume                            = "D";
        public static final String DoNotIncrease                              = "E";
        public static final String DoNotReduce                                = "F";
        public static final String AllOrNone                                  = "G";
        public static final String InstitutionsOnly                           = "I";
        public static final String LastPeg                                    = "L";
        public static final String MidPricePeg                                = "M";
        public static final String NonNegotiable                              = "N";
        public static final String OpeningPeg                                 = "O";
        public static final String MarketPeg                                  = "P";
        public static final String PrimaryPeg                                 = "R";
        public static final String Suspend                                    = "S";
        public static final String FixedPegToLocalBestBidOrOfferAtTimeOfOrder = "T";
        public static final String CustomerDisplayInstruction                 = "U";
        public static final String Netting                                    = "V";
        public static final String PegToVWAP                                  = "W";

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

        public static final String CUSIP                       = "1";
        public static final String SEDOL                       = "2";
        public static final String QUIK                        = "3";
        public static final String ISINNumber                  = "4";
        public static final String RICCode                     = "5";
        public static final String ISOCurrencyCode             = "6";
        public static final String ISOCountryCode              = "7";
        public static final String ExchangeSymbol              = "8";
        public static final String ConsolidatedTapeAssociation = "9";

        private IDSourceValues() {
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

        public static final String Large  = "L";
        public static final String Medium = "M";
        public static final String Small  = "S";

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

        public static final char Market                = '1';
        public static final char Limit                 = '2';
        public static final char Stop                  = '3';
        public static final char StopLimit             = '4';
        public static final char MarketOnClose         = '5';
        public static final char WithOrWithout         = '6';
        public static final char LimitOrBetter         = '7';
        public static final char LimitWithOrWithout    = '8';
        public static final char OnBasis               = '9';
        public static final char OnClose               = 'A';
        public static final char LimitOnClose          = 'B';
        public static final char ForexMarket           = 'C';
        public static final char PreviouslyQuoted      = 'D';
        public static final char PreviouslyIndicated   = 'E';
        public static final char ForexLimit            = 'F';
        public static final char ForexSwap             = 'G';
        public static final char ForexPreviouslyQuoted = 'H';
        public static final char Funari                = 'I';
        public static final char Pegged                = 'P';

        private OrdTypeValues() {
        }

    }

    /**
     * Values for Rule80A(47).
     */
    public static class Rule80AValues {

        public static final char AgencySingleOrder                        = 'A';
        public static final char ShortExemptTransactionAType              = 'B';
        public static final char ProprietaryNonAlgo                       = 'C';
        public static final char ProgramOrderMember                       = 'D';
        public static final char ShortExemptTransactionForPrincipal       = 'E';
        public static final char ShortExemptTransactionWType              = 'F';
        public static final char ShortExemptTransactionIType              = 'H';
        public static final char IndividualInvestor                       = 'I';
        public static final char ProprietaryAlgo                          = 'J';
        public static final char AgencyAlgo                               = 'K';
        public static final char ShortExemptTransactionMemberAffliated    = 'L';
        public static final char ProgramOrderOtherMember                  = 'M';
        public static final char AgentForOtherMember                      = 'N';
        public static final char ProprietaryTransactionAffiliated         = 'O';
        public static final char Principal                                = 'P';
        public static final char TransactionNonMember                     = 'R';
        public static final char SpecialistTrades                         = 'S';
        public static final char TransactionUnaffiliatedMember            = 'T';
        public static final char AgencyIndexArb                           = 'U';
        public static final char AllOtherOrdersAsAgentForOtherMember      = 'W';
        public static final char ShortExemptTransactionMemberNotAffliated = 'X';
        public static final char AgencyNonAlgo                            = 'Y';
        public static final char ShortExemptTransactionNonMember          = 'Z';

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
        public static final char Undisclosed     = '7';
        public static final char Cross           = '8';
        public static final char CrossShort      = '9';

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

        public static final char New                          = '0';
        public static final char Replace                      = '1';
        public static final char Cancel                       = '2';
        public static final char Preliminary                  = '3';
        public static final char Calculated                   = '4';
        public static final char CalculatedWithoutPreliminary = '5';

        private AllocTransTypeValues() {
        }

    }

    /**
     * Values for OpenClose(77).
     */
    public static class OpenCloseValues {

        public static final char Close = 'C';
        public static final char Open  = 'O';

        private OpenCloseValues() {
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
     * Values for CxlRejReason(102).
     */
    public static class CxlRejReasonValues {

        public static final int TooLateToCancel             = 0;
        public static final int UnknownOrder                = 1;
        public static final int BrokerCredit                = 2;
        public static final int OrderAlreadyInPendingStatus = 3;

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
        public static final char ReadyToTrade        = 'R';
        public static final char PortfolioShown      = 'S';
        public static final char ThroughTheDay       = 'T';
        public static final char Versus              = 'V';
        public static final char Indication          = 'W';
        public static final char CrossingOpportunity = 'X';
        public static final char AtTheMidpoint       = 'Y';
        public static final char PreOpen             = 'Z';

        private IOIQualifierValues() {
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
        public static final char Markup          = '8';
        public static final char ConsumptionTax  = '9';

        private MiscFeeTypeValues() {
        }

    }

    /**
     * Values for ExecType(150).
     */
    public static class ExecTypeValues {

        public static final char New            = '0';
        public static final char PartialFill    = '1';
        public static final char Fill           = '2';
        public static final char DoneForDay     = '3';
        public static final char Canceled       = '4';
        public static final char Replaced       = '5';
        public static final char PendingCancel  = '6';
        public static final char Stopped        = '7';
        public static final char Rejected       = '8';
        public static final char Suspended      = '9';
        public static final char PendingNew     = 'A';
        public static final char Calculated     = 'B';
        public static final char Expired        = 'C';
        public static final char Restated       = 'D';
        public static final char PendingReplace = 'E';

        private ExecTypeValues() {
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

        private SettlInstModeValues() {
        }

    }

    /**
     * Values for SettlInstTransType(163).
     */
    public static class SettlInstTransTypeValues {

        public static final char Cancel  = 'C';
        public static final char New     = 'N';
        public static final char Replace = 'R';

        private SettlInstTransTypeValues() {
        }

    }

    /**
     * Values for SettlInstSource(165).
     */
    public static class SettlInstSourceValues {

        public static final char BrokerCredit = '1';
        public static final char Institution  = '2';

        private SettlInstSourceValues() {
        }

    }

    /**
     * Values for SettlLocation(166).
     */
    public static class SettlLocationValues {

        public static final String CEDEL                     = "CED";
        public static final String DepositoryTrustCompany    = "DTC";
        public static final String EuroClear                 = "EUR";
        public static final String FederalBookEntry          = "FED";
        public static final String LocalMarketSettleLocation = "ISO Country Code";
        public static final String Physical                  = "PNY";
        public static final String ParticipantTrustCompany   = "PTC";

        private SettlLocationValues() {
        }

    }

    /**
     * Values for SecurityType(167).
     */
    public static class SecurityTypeValues {

        public static final String Wildcard                              = "?";
        public static final String BankersAcceptance                     = "BA";
        public static final String ConvertibleBond                       = "CB";
        public static final String CertificateOfDeposit                  = "CD";
        public static final String CollateralizedMortgageObligation      = "CMO";
        public static final String CorporateBond                         = "CORP";
        public static final String CommercialPaper                       = "CP";
        public static final String CorporatePrivatePlacement             = "CPP";
        public static final String CommonStock                           = "CS";
        public static final String FederalHousingAuthority               = "FHA";
        public static final String FederalHomeLoan                       = "FHL";
        public static final String FederalNationalMortgageAssociation    = "FN";
        public static final String ForeignExchangeContract               = "FOR";
        public static final String Future                                = "FUT";
        public static final String GovernmentNationalMortgageAssociation = "GN";
        public static final String TreasuriesAgencyDebenture             = "GOVT";
        public static final String IOETTEMortgage                        = "IET";
        public static final String MutualFund                            = "MF";
        public static final String MortgageInterestOnly                  = "MIO";
        public static final String MortgagePrincipalOnly                 = "MPO";
        public static final String MortgagePrivatePlacement              = "MPP";
        public static final String MiscellaneousPassThrough              = "MPT";
        public static final String MunicipalBond                         = "MUNI";
        public static final String NoSecurityType                        = "NONE";
        public static final String Option                                = "OPT";
        public static final String PreferredStock                        = "PS";
        public static final String RepurchaseAgreement                   = "RP";
        public static final String ReverseRepurchaseAgreement            = "RVRP";
        public static final String StudentLoanMarketingAssociation       = "SL";
        public static final String TimeDeposit                           = "TD";
        public static final String USTreasuryBillOld                     = "USTB";
        public static final String Warrant                               = "WAR";
        public static final String CatsTigersAndLions                    = "ZOO";

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

        private StandInstDbTypeValues() {
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
     */
    public static class PutOrCallValues {

        public static final int Put  = 0;
        public static final int Call = 1;

        private PutOrCallValues() {
        }

    }

    /**
     * Values for CoveredOrUncovered(203).
     */
    public static class CoveredOrUncoveredValues {

        public static final int Covered   = 0;
        public static final int Uncovered = 1;

        private CoveredOrUncoveredValues() {
        }

    }

    /**
     * Values for CustomerOrFirm(204).
     */
    public static class CustomerOrFirmValues {

        public static final int Customer = 0;
        public static final int Firm     = 1;

        private CustomerOrFirmValues() {
        }

    }

    /**
     * Values for AllocHandlInst(209).
     */
    public static class AllocHandlInstValues {

        public static final int Match           = 1;
        public static final int Forward         = 2;
        public static final int ForwardAndMatch = 3;

        private AllocHandlInstValues() {
        }

    }

    /**
     * Values for RoutingType(216).
     */
    public static class RoutingTypeValues {

        public static final int TargetFirm = 1;
        public static final int TargetList = 2;
        public static final int BlockFirm  = 3;
        public static final int BlockList  = 4;

        private RoutingTypeValues() {
        }

    }

    /**
     * Values for Benchmark(219).
     */
    public static class BenchmarkValues {

        public static final char CURVE        = '1';
        public static final char FiveYR       = '2';
        public static final char OLD5         = '3';
        public static final char TenYR        = '4';
        public static final char OLD10        = '5';
        public static final char ThirtyYR     = '6';
        public static final char OLD30        = '7';
        public static final char ThreeMOLIBOR = '8';
        public static final char SixMOLIBOR   = '9';

        private BenchmarkValues() {
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

        public static final char Bid                     = '0';
        public static final char Offer                   = '1';
        public static final char Trade                   = '2';
        public static final char IndexValue              = '3';
        public static final char OpeningPrice            = '4';
        public static final char ClosingPrice            = '5';
        public static final char SettlementPrice         = '6';
        public static final char TradingSessionHighPrice = '7';
        public static final char TradingSessionLowPrice  = '8';
        public static final char TradingSessionVWAPPrice = '9';

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

        public static final String Open             = "A";
        public static final String Closed           = "B";
        public static final String ExchangeBest     = "C";
        public static final String ConsolidatedBest = "D";
        public static final String Locked           = "E";
        public static final String Crossed          = "F";
        public static final String Depth            = "G";
        public static final String FastTrading      = "H";
        public static final String NonFirm          = "I";

        private QuoteConditionValues() {
        }

    }

    /**
     * Values for TradeCondition(277).
     */
    public static class TradeConditionValues {

        public static final String Cash                = "A";
        public static final String AveragePriceTrade   = "B";
        public static final String CashTrade           = "C";
        public static final String NextDay             = "D";
        public static final String Opening             = "E";
        public static final String IntradayTradeDetail = "F";
        public static final String Rule127Trade        = "G";
        public static final String Rule155Trade        = "H";
        public static final String SoldLast            = "I";
        public static final String NextDayTrade        = "J";
        public static final String Opened              = "K";
        public static final String Seller              = "L";
        public static final String Sold                = "M";
        public static final String StoppedStock        = "N";

        private TradeConditionValues() {
        }

    }

    /**
     * Values for MDUpdateAction(279).
     */
    public static class MDUpdateActionValues {

        public static final char New    = '0';
        public static final char Change = '1';
        public static final char Delete = '2';

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
     * Values for OpenCloseSettleFlag(286).
     */
    public static class OpenCloseSettleFlagValues {

        public static final char DailyOpen               = '0';
        public static final char SessionOpen             = '1';
        public static final char DeliverySettlementEntry = '2';

        private OpenCloseSettleFlagValues() {
        }

    }

    /**
     * Values for FinancialStatus(291).
     */
    public static class FinancialStatusValues {

        public static final char Bankrupt = '1';

        private FinancialStatusValues() {
        }

    }

    /**
     * Values for CorporateAction(292).
     */
    public static class CorporateActionValues {

        public static final char ExDividend     = 'A';
        public static final char ExDistribution = 'B';
        public static final char ExRights       = 'C';
        public static final char New            = 'D';
        public static final char ExInterest     = 'E';

        private CorporateActionValues() {
        }

    }

    /**
     * Values for QuoteAckStatus(297).
     */
    public static class QuoteAckStatusValues {

        public static final int Accepted                = 0;
        public static final int CancelForSymbol         = 1;
        public static final int CanceledForSecurityType = 2;
        public static final int CanceledForUnderlying   = 3;
        public static final int CanceledAll             = 4;
        public static final int Rejected                = 5;

        private QuoteAckStatusValues() {
        }

    }

    /**
     * Values for QuoteCancelType(298).
     */
    public static class QuoteCancelTypeValues {

        public static final int CancelForOneOrMoreSecurities = 1;
        public static final int CancelForSecurityType        = 2;
        public static final int CancelForUnderlyingSecurity  = 3;
        public static final int CancelAllQuotes              = 4;

        private QuoteCancelTypeValues() {
        }

    }

    /**
     * Values for QuoteRejectReason(300).
     */
    public static class QuoteRejectReasonValues {

        public static final int UnknownSymbol                = 1;
        public static final int Exchange                     = 2;
        public static final int QuoteRequestExceedsLimit     = 3;
        public static final int TooLateToEnter               = 4;
        public static final int UnknownQuote                 = 5;
        public static final int DuplicateQuote               = 6;
        public static final int InvalidBid                   = 7;
        public static final int InvalidPrice                 = 8;
        public static final int NotAuthorizedToQuoteSecurity = 9;

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

        private QuoteResponseLevelValues() {
        }

    }

    /**
     * Values for QuoteRequestType(303).
     */
    public static class QuoteRequestTypeValues {

        public static final int Manual    = 1;
        public static final int Automatic = 2;

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
     */
    public static class SecurityTradingStatusValues {

        public static final int OpeningDelay               =  1;
        public static final int MarketOnCloseImbalanceSell = 10;
        public static final int NoMarketImbalance          = 12;
        public static final int NoMarketOnCloseImbalance   = 13;
        public static final int ITSPreOpening              = 14;
        public static final int NewPriceIndication         = 15;
        public static final int TradeDisseminationTime     = 16;
        public static final int ReadyToTrade               = 17;
        public static final int NotAvailableForTrading     = 18;
        public static final int NotTradedOnThisMarket      = 19;
        public static final int TradingHalt                =  2;
        public static final int UnknownOrInvalid           = 20;
        public static final int Resume                     =  3;
        public static final int NoOpen                     =  4;
        public static final int PriceIndication            =  5;
        public static final int TradingRangeIndication     =  6;
        public static final int MarketImbalanceBuy         =  7;
        public static final int MarketImbalanceSell        =  8;
        public static final int MarketOnCloseImbalanceBuy  =  9;

        private SecurityTradingStatusValues() {
        }

    }

    /**
     * Values for HaltReason(327).
     */
    public static class HaltReasonValues {

        public static final char NewsDissemination     = 'D';
        public static final char OrderInflux           = 'E';
        public static final char OrderImbalance        = 'I';
        public static final char AdditionalInformation = 'M';
        public static final char NewsPending           = 'P';
        public static final char EquipmentChangeover   = 'X';

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
     * Values for TradSesMethod(338).
     */
    public static class TradSesMethodValues {

        public static final int Electronic = 1;
        public static final int OpenOutcry = 2;
        public static final int TwoParty   = 3;

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

        public static final int Halted   = 1;
        public static final int Open     = 2;
        public static final int Closed   = 3;
        public static final int PreOpen  = 4;
        public static final int PreClose = 5;

        private TradSesStatusValues() {
        }

    }

    /**
     * Values for MessageEncoding(347).
     */
    public static class MessageEncodingValues {

        public static final String EUCJP     = "EUC-JP";
        public static final String ISO2022JP = "ISO-2022-JP";
        public static final String ShiftJIS  = "Shift_JIS";
        public static final String UTF8      = "UTF-8";

        private MessageEncodingValues() {
        }

    }

    /**
     * Values for QuoteEntryRejectReason(368).
     */
    public static class QuoteEntryRejectReasonValues {

        public static final int UnknownSymbol                = 1;
        public static final int Exchange                     = 2;
        public static final int QuoteExceedsLimit            = 3;
        public static final int TooLateToEnter               = 4;
        public static final int UnknownQuote                 = 5;
        public static final int DuplicateQuote               = 6;
        public static final int InvalidBidAskSpread          = 7;
        public static final int InvalidPrice                 = 8;
        public static final int NotAuthorizedToQuoteSecurity = 9;

        private QuoteEntryRejectReasonValues() {
        }

    }

    /**
     * Values for SessionRejectReason(373).
     */
    public static class SessionRejectReasonValues {

        public static final int InvalidTagNumber                =  0;
        public static final int RequiredTagMissing              =  1;
        public static final int SendingTimeAccuracyProblem      = 10;
        public static final int InvalidMsgType                  = 11;
        public static final int TagNotDefinedForThisMessageType =  2;
        public static final int UndefinedTag                    =  3;
        public static final int TagSpecifiedWithoutAValue       =  4;
        public static final int ValueIsIncorrect                =  5;
        public static final int IncorrectDataFormatForValue     =  6;
        public static final int DecryptionProblem               =  7;
        public static final int SignatureProblem                =  8;
        public static final int CompIDProblem                   =  9;

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

        public static final int GTCorporateAction        = 0;
        public static final int GTRenewal                = 1;
        public static final int VerbalChange             = 2;
        public static final int RepricingOfOrder         = 3;
        public static final int BrokerOption             = 4;
        public static final int PartialDeclineOfOrderQty = 5;

        private ExecRestatementReasonValues() {
        }

    }

    /**
     * Values for BusinessRejectReason(380).
     */
    public static class BusinessRejectReasonValues {

        public static final int Other                             = 0;
        public static final int UnknownID                         = 1;
        public static final int UnknownSecurity                   = 2;
        public static final int UnsupportedMessageType            = 3;
        public static final int ApplicationNotAvailable           = 4;
        public static final int ConditionallyRequiredFieldMissing = 5;

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

        private DiscretionInstValues() {
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
     * Values for TradeType(418).
     */
    public static class TradeTypeValues {

        public static final char Agency          = 'A';
        public static final char VWAPGuarantee   = 'G';
        public static final char GuaranteedClose = 'J';
        public static final char RiskTrade       = 'R';

        private TradeTypeValues() {
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
     */
    public static class PriceTypeValues {

        public static final int Percentage  = 1;
        public static final int PerUnit     = 2;
        public static final int FixedAmount = 3;

        private PriceTypeValues() {
        }

    }

    /**
     * Values for GTBookingInst(427).
     */
    public static class GTBookingInstValues {

        public static final int BookOutAllTradesOnDayOfExecution          = 0;
        public static final int AccumulateUntilFilledOrExpired            = 1;
        public static final int AccumulateUntilVerballlyNotifiedOtherwise = 2;

        private GTBookingInstValues() {
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
     * Values for ListExecInstType(433).
     */
    public static class ListExecInstTypeValues {

        public static final char Immediate          = '1';
        public static final char WaitForInstruction = '2';

        private ListExecInstTypeValues() {
        }

    }

    /**
     * Values for CxlRejResponseTo(434).
     */
    public static class CxlRejResponseToValues {

        public static final char OrderCancelRequest        = '1';
        public static final char OrderCancel               = '2';
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

    private FIX42Enumerations() {
    }

}
