package ch.admin.bag.covidcode.authcodegeneration.service;

import ch.admin.bag.covidcode.authcodegeneration.api.TokenType;
import ch.admin.bag.covidcode.authcodegeneration.service.CustomTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.security.NoSuchAlgorithmException;

import static ch.admin.bag.covidcode.authcodegeneration.api.TokenType.CHECKIN_USERUPLOAD_TOKEN;
import static ch.admin.bag.covidcode.authcodegeneration.api.TokenType.DP3T_TOKEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class CustomTokenProviderTest {

    @Test
    void createToken() throws NoSuchAlgorithmException {

        CustomTokenProvider tokenProvider = new CustomTokenProvider();
        tokenProvider.init();

        ReflectionTestUtils.setField(tokenProvider, "issuer", "http://localhost:8113");
        ReflectionTestUtils.setField(tokenProvider, "tokenValidity", 300000);
        ReflectionTestUtils.setField(tokenProvider, "privateKey", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDT5jbu96Mf5UvkGrp3sj0Spoh0Cf664/ksSs5fOGM6ZFRh4IkjDRokfEu7nWbGSYftrfVLAatL1At+Jc+yEe29RKFzAHjatmLSCb59BtWoJAHa3+gPm2Essk2F93iAuRiWPVeJ3uz1fqPCYG9Gca65YSzOvlPUN7+Nih/0DeJOfrtq138c5Thv+YgJbzih1p2T+9iEZ9QqE77Xf0oNFJCpWcW8Fu2JKCHuDPYCjXdEHlONClHUskICqmheppsaSqdSIXxbj9ZylHUqTp/zLsL7m91Z0/Fy3ZUgYCKJSopCaWJSZJIq4YEM5OMwjArCB1/UZyWzARsdjj5j8cRYc+BdAgMBAAECggEARLKLNrgkM5AEJaSgtXOcpzJEZNJkujR0sO5jr605RlIGpWDFNQ7nXdLKPr4N9tUZ822Fa9bTsRbCzxf1GPcFC2p3qTAK/mVI7m1oS2Ju3D8oNsyGkKDARVxdE8SiVaEsnnCus60JR6HR94+KI91xVvpxK2m7Bb85I+sW5umlZ+rI59XgnP9q3EtOxnC4GQ/QfTjFIgAZHUJwzh0SZ+I2GPXLw9WkFGyxgW6wKaNQOUz/jjJyPNTl3jg0cW9kcHrviyHZK+IPVwQINj7JEzRZ5rCXBjEBE8ht1g1vu7QPQD1x7ZGCrjWAXfr01rNSJMPNEIi1CEaVbz63j6ewUVZV4QKBgQD7GNOnDorqimmGO+sJ6LV3DqrBa2TPCfclcgSiKBu+A/B1nBBLAsNVXN59BTtYHilj+Xhdt1cmOHBo9a0ZCrqHjU6xWyl9iOxh8rhpE0FZ/3g3aWM7aII+SyheMrFtfBh4XrvH5ZJLrzJiiGg+TDTuFApksmb6qf/SE+ZQFZNRaQKBgQDYCXKs051beqn1kHWVwTcb1UTqrTuclgnNZ3sPKjVwvGCqUIRsyWZOV8E7PFeU2F9Ek/3nvLw5pTY+F5Aq0Tfaxt3yS7nRhRfWLL4wMyezYrE/qPFN5L8bhejcuSjRieIWXQU8vMI0+YIIV45JmP44M9cjbcrkPuzvl2soY8+E1QKBgQCOC2NgM9feCmLbrvWta1mMel2agXhLryWCp1d7rBjVi0DyJ1EIPg3mMl0ieF0z4gwkJDI1QcwpMPBWT/SWH/2ZRRTpO9riyxx95GLx/hSQJvcI0bNzHhHfz4CMmTzJ5NOq9FxiHrp92iQ0nVnrNA0VSXz/rfSXhKfVXbCCSVJHUQKBgQCe+CzTMhCLvTKNiZSM8xW7PG8vBPRloB5scGYkXZnfcC7thLw9VOIcagS9swR7edB4pTHkMYSMIp9Mh4hFiZjBOy8c2U5N99L3fgsharMfFFN7lbSi7d0Wwq38pZ98uSqN7DsrW3bJBoUB4HPKgnMnJjZ8UpFG7WrqTxDCMtgEVQKBgFFFy9AypTsQgdQf1VWdUGX7uJ8TYTuhMVzcOThtQeuVnTEqp9gUyuarc6xOL2i7wD6cdnb48NhqJ66r/F8bxMAUMOaElrAo7IIZXfSJdpPVFMwGVz022lk//XdjA/VcJv5tNnBoKP29cRCkf6WU1SEdlyoVu/vzPNMGbNZMyt8s");

        String dp3tToken = tokenProvider.createToken("2020-08-15", "0", DP3T_TOKEN);
        String dp3tFakeToken = tokenProvider.createToken("2020-08-15", "1", DP3T_TOKEN);
        String checkInToken = tokenProvider.createToken("2020-08-15", "0", CHECKIN_USERUPLOAD_TOKEN);
        String checkInFakeToken = tokenProvider.createToken("2020-08-15", "1", CHECKIN_USERUPLOAD_TOKEN);

        assertNotNull(dp3tToken);
        assertNotNull(dp3tFakeToken);
        assertNotNull(checkInToken);
        assertNotNull(checkInFakeToken);

        // TODO Decode tokens and make some useful assertions here

        log.debug(dp3tToken);
        log.debug(checkInToken);
    }
}

