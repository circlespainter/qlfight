package qlfight.qlapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchDetails {

    public final String publicId; // "2d9d94fe-2e32-11e5-9129-0242ac11001c"
    public final Boolean restarted; // "0"
    public final Integer avgAccuracy; // 31
    public final String scoreLimit; // "150"
    public final Integer tier; // "0"
    public final Boolean ranked; // "1"
    public final String exitMessage; // "Timelimit hit."
    public final String gameTypeFull; // "Duel"
    public final String playerId; // "801923"
    public final String gameTimeStamp; // "07/19/2015 11:21 AM"
    public final String tScore0; // "0"
    public final String tScore1; // "0"
    public final Boolean training; // "0"
    public final String mapNameShort; // "campgrounds"
    public final String gameType; // "duel"
    public final MiniStats mostDeaths;
    public final MiniStats damageTaken;
    public final MiniStats mostAccurate;
    public final Integer fragLimit; // "0"
    public final String lastTeamScorer; // "none"
    public final MiniStats mostFrags;
    public final String quadHog; // "0"
    public final Integer numPlayers; // "4"
    public final String gameTypeId; // ""
    public final Integer gameLength; // "600"
    public final Integer timeLimit; // "10"
    public final String oldPublicId; // "1"
    public final Scoreboard[] scoreboards;
    public final String ruleset; // "1"
    public final String mapName; // "Campgrounds"
    public final Boolean premium; // "0"
    public final String map; // "campgrounds"
    public final String serverId; // ""
    public final String mapId; // ""
    public final String serverRealm; // "quakelive"
    public final MiniStats leastDeaths;
    public final String qls; // "qls31"
    public final String firstScorer; // "Taake"
    public final String serverTitle; // "Taake"
    public final String lastScorer; // "Taake"
    public final Boolean aborted; // "0"
    public final Integer totalKills; // 17
    public final String owner; // "Taake"
    public final Integer captureLimit; // "8"
    public final MiniStats dmgDelivered;
    public final String gameTimestampNice; // "2 days"
    public final String gameLengthNice; // "10:00"
    public final String gameExpiresFull; // "08/15/2015 11:21 AM"

    public MatchDetails(@JsonProperty("PUBLIC_ID") String publicId,
                        @JsonProperty("RESTARTED") Boolean restarted,
                        @JsonProperty("AVG_ACC") Integer avgAccuracy,
                        @JsonProperty("SCORE_LIMIT") String scoreLimit,
                        @JsonProperty("TIER") Integer tier,
                        @JsonProperty("RANKED") Boolean ranked,
                        @JsonProperty("EXIT_MSG") String exitMessage,
                        @JsonProperty("GAME_TYPE_FULL") String gameTypeFull,
                        @JsonProperty("PLAYER_ID") String playerId,
                        @JsonProperty("GAME_TIMESTAMP") String gameTimeStamp,
                        @JsonProperty("TSCORE0") String tScore0,
                        @JsonProperty("TSCORE1") String tScore1,
                        @JsonProperty("TRAINING") Boolean training,
                        @JsonProperty("MAP_NAME_SHORT") String mapNameShort,
                        @JsonProperty("MOST_DEATHS") MiniStats mostDeaths,
                        @JsonProperty("GAME_TYPE") String gameType,
                        @JsonProperty("DMG_TAKEN") MiniStats damageTaken,
                        @JsonProperty("MOST_ACCURATE") MiniStats mostAccurate,
                        @JsonProperty("FRAG_LIMIT") Integer fragLimit,
                        @JsonProperty("LAST_TEAMSCORER") String lastTeamScorer,
                        @JsonProperty("MOST_FRAGS") MiniStats mostFrags,
                        @JsonProperty("QUADHOG") String quadHog,
                        @JsonProperty("NUM_PLAYERS") Integer numPlayers,
                        @JsonProperty("GAME_TYPE_ID") String gameTypeId,
                        @JsonProperty("GAME_LENGTH") Integer gameLength,
                        @JsonProperty("TIME_LIMIT") Integer timeLimit,
                        @JsonProperty("OLD_PUBLIC_ID") String oldPublicId,
                        @JsonProperty("SCOREBOARDS") Scoreboard[] scoreboards,
                        @JsonProperty("RULESET") String ruleset,
                        @JsonProperty("MAP_NAME") String mapName,
                        @JsonProperty("PREMIUM") Boolean premium,
                        @JsonProperty("MAP") String map,
                        @JsonProperty("SERVER_ID") String serverId,
                        @JsonProperty("MAP_ID") String mapId,
                        @JsonProperty("SERVER_REALM") String serverRealm,
                        @JsonProperty("LEAST_DEATHS") MiniStats leastDeaths,
                        @JsonProperty("QLS") String qls,
                        @JsonProperty("FIRST_SCORER") String firstScorer,
                        @JsonProperty("SERVER_TITLE") String serverTitle,
                        @JsonProperty("LAST_SCORER") String lastScorer,
                        @JsonProperty("ABORTED") Boolean aborted,
                        @JsonProperty("TOTAL_KILLS") Integer totalKills,
                        @JsonProperty("OWNER") String owner,
                        @JsonProperty("CAPTURE_LIMIT") Integer captureLimit,
                        @JsonProperty("DMG_DELIVERED") MiniStats dmgDelivered,
                        @JsonProperty("GAME_TIMESTAMP_NICE") String gameTimestampNice,
                        @JsonProperty("GAME_LENGTH_NICE") String gameLengthNice,
                        @JsonProperty("GAME_EXPIRES_FULL") String gameExpiresFull) {
        this.publicId = publicId;
        this.restarted = restarted;
        this.avgAccuracy = avgAccuracy;
        this.scoreLimit = scoreLimit;
        this.tier = tier;
        this.ranked = ranked;
        this.exitMessage = exitMessage;
        this.gameTypeFull = gameTypeFull;
        this.playerId = playerId;
        this.gameTimeStamp = gameTimeStamp;
        this.tScore0 = tScore0;
        this.tScore1 = tScore1;
        this.training = training;
        this.mapNameShort = mapNameShort;
        this.mostDeaths = mostDeaths;
        this.gameType = gameType;
        this.damageTaken = damageTaken;
        this.mostAccurate = mostAccurate;
        this.fragLimit = fragLimit;
        this.lastTeamScorer = lastTeamScorer;
        this.mostFrags = mostFrags;
        this.quadHog = quadHog;
        this.numPlayers = numPlayers;
        this.gameTypeId = gameTypeId;
        this.gameLength = gameLength;
        this.timeLimit = timeLimit;
        this.oldPublicId = oldPublicId;
        this.scoreboards = scoreboards;
        this.ruleset = ruleset;
        this.mapName = mapName;
        this.premium = premium;
        this.map = map;
        this.serverId = serverId;
        this.mapId = mapId;
        this.serverRealm = serverRealm;
        this.leastDeaths = leastDeaths;
        this.qls = qls;
        this.firstScorer = firstScorer;
        this.serverTitle = serverTitle;
        this.lastScorer = lastScorer;
        this.aborted = aborted;
        this.totalKills = totalKills;
        this.owner = owner;
        this.captureLimit = captureLimit;
        this.dmgDelivered = dmgDelivered;
        this.gameTimestampNice = gameTimestampNice;
        this.gameLengthNice = gameLengthNice;
        this.gameExpiresFull = gameExpiresFull;
    }

    public class MiniStats {
        public final Integer playerId; // 0
        public final String playerNick; // "Taake"
        public final String playerCountry; // "DE"
        public final Integer num; // 11
        public final String playerModel; // "doomdefault"

        public MiniStats(@JsonProperty("PLAYER_ID") Integer playerId,
                         @JsonProperty("PLAYER_NICK") String playerNick,
                         @JsonProperty("PLAYER_COUNTRY") String playerCountry,
                         @JsonProperty("NUM") Integer num,
                         @JsonProperty("PLAYER_MODEL") String playerModel) {
            this.playerId = playerId;
            this.playerNick = playerNick;
            this.playerCountry = playerCountry;
            this.num = num;
            this.playerModel = playerModel;
        }
    }

    public class Scoreboard {
        public final Integer rg; // 2
        public final Integer rl; // 6
        public final Integer gt; // 0
        public final Integer ng; // 0
        public final Integer cg; // 0
        public final Integer sg; // 0
        public final Integer bfg; // 0
        public final Integer gl; // 0
        public final Integer pg; // 0
        public final Integer hmg; // 0
        public final Integer pm; // 0
        public final Integer mg; // 0
        public final Integer lg; // 3

        public final Integer hmgA; // 0
        public final Integer sgA; // 0
        public final Integer glA; // 15
        public final Integer bfgA; // 0
        public final Integer rgA; // 31
        public final Integer cgA; // 0
        public final Integer pgA; // 7
        public final Integer lgA; // 35
        public final Integer rlA; // 35
        public final Integer pmA; // 0
        public final Integer ngA; // 0
        public final Integer gtA; // 0
        public final Integer mgA; // 36

        public final Integer bfgHits; // "0"
        public final Integer chainGunHits; // "0"
        public final Integer gauntletHits; // "0"
        public final Integer grenadeHits; // "2"
        public final Integer hmgHits; // "0"
        public final Integer lightningHits; // "220"
        public final Integer machineGunHits; // "4"
        public final Integer nailgunHits; // "0"
        public final Integer plasmaHits; // "1"
        public final Integer proxMineHits; // "0"
        public final Integer shotgunHits; // "0"
        public final Integer rocketHits; // "28"
        public final Integer railGunHits; // "5"

        public final Integer bfgShots; // "0"
        public final Integer chaingunShots; // "0"
        public final Integer gauntletShots; // "0"
        public final Integer grenadeShots; // "13"
        public final Integer hmgShots; // "0"
        public final Integer lightningShots; // "625"
        public final Integer machinegunShots; // "11"
        public final Integer nailgunShots; // "0"
        public final Integer plasmaShots; // "15"
        public final Integer proxyMineShots; // "0"
        public final Integer shotgunShots; // "0"
        public final Integer rocketShots; // "81"
        public final Integer railGunShots; // "16"

        public final Integer nailgunKills; // "0"
        public final Integer rocketKills; // "6"
        public final Integer railgunKills; // "2"
        public final Integer proxMineKills; // "0"
        public final Integer gauntletKills; // "0"
        public final Integer chaingunKills; // "0"
        public final Integer bfgKills; // "0"
        public final Integer plasmaKills; // "0"
        public final Integer machineGunKills; // "0"
        public final Integer hmgKills; // "0"
        public final Integer grenadeKills; // "0"
        public final Integer lightningKills; // "3"
        public final Integer shotGunKills; // "0"

        public final Float plasmaAccuracy; // "6.66667"
        public final Float shotgunAccuracy; // "0"
        public final Float machineGunAccuracy; // "36.3636"
        public final Float lightningAccuracy; // "35.2"
        public final Float railgunAccuracy; // "31.25"
        public final Float gauntletAccuracy; // "0"
        public final Float proxyMineAccuracy; // "0"
        public final Float rocketAccuracy; // "34.5679"
        public final Float chainGunAccuracy; // "0"
        public final Float hmgAccuracy; // "0"
        public final Float bfgAccuracy; // "0"
        public final Float nailGunAccuracy; // "0"
        public final Float grenadeAccuraxy; // "15.3846"

        public final Integer humiliation; // "0"
        public final Integer playTime; // 599
        public final Integer damageDealt; // "2986"
        public final String playerCountry; // "US"
        public final Integer deaths; // 6
        public final Integer score; // 11
        public final Integer impressive; // "0"
        public final Integer accuracy; // 34
        public final Integer kills; // 11
        public final Integer excellent; // "0"
        public final Integer damageTaken; // "2577"
        public final Integer rank; // "1"
        public final Integer hits; // "260"
        public final Integer shots; // "761"
        public final String playerClan; // "abc"
        public final String playerNick; // "Taake"
        public final String payerModel; // "sarge_default"

        public Scoreboard(@JsonProperty("BFG_HITS") Integer bfgHits,
                          @JsonProperty("HMG_SHOTS") Integer hmgShots,
                          @JsonProperty("NAILGUN_SHOTS") Integer nailgunShots,
                          @JsonProperty("NAILGUN_KILLS") Integer nailgunKills,
                          @JsonProperty("CHAINGUN_SHOTS") Integer chaingunShots,
                          @JsonProperty("PLASMA_ACCURACY") Float plasmaAccuracy,
                          @JsonProperty("BFG_SHOTS") Integer bfgShots,
                          @JsonProperty("RG") Integer rg,
                          @JsonProperty("RL") Integer rl,
                          @JsonProperty("ROCKET_KILLS") Integer rocketKills,
                          @JsonProperty("ACCURACY") Integer accuracy,
                          @JsonProperty("SHOTGUN_ACCURACY") Float shotgunAccuracy,
                          @JsonProperty("GT") Integer gt,
                          @JsonProperty("BFG") Integer bfg,
                          @JsonProperty("HMG_A") Integer hmgA,
                          @JsonProperty("SHOTGUN_HITS") Integer shotgunHits,
                          @JsonProperty("PROXMINE_KILLS") Integer proxMineKills,
                          @JsonProperty("GL") Integer gl,
                          @JsonProperty("KILLS") Integer kills,
                          @JsonProperty("SG_A") Integer sgA,
                          @JsonProperty("GAUNTLET_HITS") Integer gauntletHits,
                          @JsonProperty("EXCELLENT") Integer excellent,
                          @JsonProperty("GL_A") Integer glA,
                          @JsonProperty("NAILGUN_HITS") Integer nailgunHits,
                          @JsonProperty("RAILGUN_KILLS") Integer railgunKills,
                          @JsonProperty("DAMAGE_TAKEN") Integer damageTaken,
                          @JsonProperty("BFG_A") Integer bfgA,
                          @JsonProperty("LIGHTNING_ACCURACY") Float lightningAccuracy,
                          @JsonProperty("BFG_KILLS") Integer bfgKills,
                          @JsonProperty("PG") Integer pg,
                          @JsonProperty("HMG") Integer hmg,
                          @JsonProperty("PM") Integer pm,
                          @JsonProperty("PLAYER_CLAN") String playerClan,
                          @JsonProperty("PLAYER_NICK") String playerNick,
                          @JsonProperty("PLASMA_HITS") Integer plasmaHits,
                          @JsonProperty("GRENADE_SHOTS") Integer grenadeShots,
                          @JsonProperty("PLAYER_MODEL") String payerModel,
                          @JsonProperty("GAUNTLET_KILLS") Integer gauntletKills,
                          @JsonProperty("RG_A") Integer rgA,
                          @JsonProperty("MG") Integer mg,
                          @JsonProperty("GRENADE_HITS") Integer grenadeHits,
                          @JsonProperty("MG_A") Integer mgA,
                          @JsonProperty("RAILGUN_ACCURACY") Float railgunAccuracy,
                          @JsonProperty("PLASMA_KILLS") Integer plasmaKills,
                          @JsonProperty("SHOTGUN_SHOTS") Integer shotgunShots,
                          @JsonProperty("MACHINEGUN_SHOTS") Integer machinegunShots,
                          @JsonProperty("GAUNTLET_SHOTS") Integer gauntletShots,
                          @JsonProperty("CHAINGUN_KILLS") Integer chaingunKills,
                          @JsonProperty("RANK") Integer rank,
                          @JsonProperty("ROCKET_SHOTS") Integer rocketShots,
                          @JsonProperty("SHOTS") Integer shots,
                          @JsonProperty("GAUNTLET_ACCURACY") Float gauntletAccuracy,
                          @JsonProperty("LG_A") Integer lgA,
                          @JsonProperty("NG") Integer ng,
                          @JsonProperty("RL_A") Integer rlA,
                          @JsonProperty("LIGHTNING_SHOTS") Integer lightningShots,
                          @JsonProperty("PM_A") Integer pmA,
                          @JsonProperty("DEATHS") Integer deaths,
                          @JsonProperty("PROXMINE_ACCURACY") Float proxyMineAccuracy,
                          @JsonProperty("CG") Integer cg,
                          @JsonProperty("HITS") Integer hits,
                          @JsonProperty("NG_A") Integer ngA,
                          @JsonProperty("GT_A") Integer gtA,
                          @JsonProperty("LIGHTNING_HITS") Integer lightningHits,
                          @JsonProperty("MACHINEGUN_KILLS") Integer machineGunKills,
                          @JsonProperty("CHAINGUN_ACCURACY") Float chainGunAccuracy,
                          @JsonProperty("HUMILIATION") Integer humiliation,
                          @JsonProperty("RAILGUN_HITS") Integer railGunHits,
                          @JsonProperty("ROCKET_ACCURACY") Float rocketAccuracy,
                          @JsonProperty("PLASMA_SHOTS") Integer plasmaShots,
                          @JsonProperty("HMG_KILLS") Integer hmgKills,
                          @JsonProperty("PLAY_TIME") Integer playTime,
                          @JsonProperty("SG") Integer sg,
                          @JsonProperty("RAILGUN_SHOTS") Integer railGunShots,
                          @JsonProperty("MACHINEGUN_ACCURACY") Float machineGunAccuracy,
                          @JsonProperty("DAMAGE_DEALT") Integer damageDealt,
                          @JsonProperty("PROXMINE_SHOTS") Integer proxyMineShots,
                          @JsonProperty("CG_A") Integer cgA,
                          @JsonProperty("HMG_ACCURACY") Float hmgAccuracy,
                          @JsonProperty("LG") Integer lg,
                          @JsonProperty("PLAYER_COUNTRY") String playerCountry,
                          @JsonProperty("ROCKET_HITS") Integer rocketHits,
                          @JsonProperty("CHAINGUN_HITS") Integer chainGunHits,
                          @JsonProperty("SHOTGUN_KILLS") Integer shotGunKills,
                          @JsonProperty("BFG_ACCURACY") Float bfgAccuracy,
                          @JsonProperty("SCORE") Integer score,
                          @JsonProperty("GRENADE_ACCURACY") Float grenadeAccuraxy,
                          @JsonProperty("GRENADE_KILLS") Integer grenadeKills,
                          @JsonProperty("HMG_HITS") Integer hmgHits,
                          @JsonProperty("IMPRESSIVE") Integer impressive,
                          @JsonProperty("PG_A") Integer pgA,
                          @JsonProperty("NAILGUN_ACCURACY") Float nailGunAccuracy,
                          @JsonProperty("MACHINEGUN_HITS") Integer machineGunHits,
                          @JsonProperty("PROXMINE_HITS") Integer proxMineHits,
                          @JsonProperty("LIGHTNING_KILLS") Integer lightningKills) {
            this.bfgHits = bfgHits;
            this.hmgShots = hmgShots;
            this.nailgunShots = nailgunShots;
            this.nailgunKills = nailgunKills;
            this.chaingunShots = chaingunShots;
            this.plasmaAccuracy = plasmaAccuracy;
            this.bfgShots = bfgShots;
            this.rg = rg;
            this.rl = rl;
            this.rocketKills = rocketKills;
            this.accuracy = accuracy;
            this.shotgunAccuracy = shotgunAccuracy;
            this.gt = gt;
            this.bfg = bfg;
            this.hmgA = hmgA;
            this.shotgunHits = shotgunHits;
            this.proxMineKills = proxMineKills;
            this.gl = gl;
            this.kills = kills;
            this.sgA = sgA;
            this.gauntletHits = gauntletHits;
            this.excellent = excellent;
            this.glA = glA;
            this.nailgunHits = nailgunHits;
            this.railgunKills = railgunKills;
            this.damageTaken = damageTaken;
            this.bfgA = bfgA;
            this.lightningAccuracy = lightningAccuracy;
            this.bfgKills = bfgKills;
            this.pg = pg;
            this.hmg = hmg;
            this.pm = pm;
            this.playerClan = playerClan;
            this.playerNick = playerNick;
            this.plasmaHits = plasmaHits;
            this.grenadeShots = grenadeShots;
            this.payerModel = payerModel;
            this.gauntletKills = gauntletKills;
            this.rgA = rgA;
            this.mg = mg;
            this.grenadeHits = grenadeHits;
            this.mgA = mgA;
            this.railgunAccuracy = railgunAccuracy;
            this.plasmaKills = plasmaKills;
            this.shotgunShots = shotgunShots;
            this.machinegunShots = machinegunShots;
            this.gauntletShots = gauntletShots;
            this.chaingunKills = chaingunKills;
            this.rank = rank;
            this.rocketShots = rocketShots;
            this.shots = shots;
            this.gauntletAccuracy = gauntletAccuracy;
            this.lgA = lgA;
            this.ng = ng;
            this.rlA = rlA;
            this.lightningShots = lightningShots;
            this.pmA = pmA;
            this.deaths = deaths;
            this.proxyMineAccuracy = proxyMineAccuracy;
            this.cg = cg;
            this.hits = hits;
            this.ngA = ngA;
            this.gtA = gtA;
            this.lightningHits = lightningHits;
            this.machineGunKills = machineGunKills;
            this.chainGunAccuracy = chainGunAccuracy;
            this.humiliation = humiliation;
            this.railGunHits = railGunHits;
            this.rocketAccuracy = rocketAccuracy;
            this.plasmaShots = plasmaShots;
            this.hmgKills = hmgKills;
            this.playTime = playTime;
            this.sg = sg;
            this.railGunShots = railGunShots;
            this.machineGunAccuracy = machineGunAccuracy;
            this.damageDealt = damageDealt;
            this.proxyMineShots = proxyMineShots;
            this.cgA = cgA;
            this.hmgAccuracy = hmgAccuracy;
            this.lg = lg;
            this.playerCountry = playerCountry;
            this.rocketHits = rocketHits;
            this.chainGunHits = chainGunHits;
            this.shotGunKills = shotGunKills;
            this.bfgAccuracy = bfgAccuracy;
            this.score = score;
            this.grenadeAccuraxy = grenadeAccuraxy;
            this.grenadeKills = grenadeKills;
            this.hmgHits = hmgHits;
            this.impressive = impressive;
            this.pgA = pgA;
            this.nailGunAccuracy = nailGunAccuracy;
            this.machineGunHits = machineGunHits;
            this.proxMineHits = proxMineHits;
            this.lightningKills = lightningKills;
        }
    }

}
