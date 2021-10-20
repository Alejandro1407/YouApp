package sv.com.udb.services.authentication.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.security.jackson2.SecurityJackson2Modules;
import sv.com.udb.services.authentication.models.AbstractPrincipal;

public class OAuthProviderSecurityModule extends SimpleModule {
   public OAuthProviderSecurityModule() {
      super(OAuthProviderSecurityModule.class.getName(),
            new Version(1, 0, 0, null, null, null));
   }

   @Override
   public void setupModule(SetupContext context) {
      // SecurityJackson2Modules.enableDefaultTyping(context.getOwner());
      context.setMixInAnnotations(AbstractPrincipal.class,
            AbstractPrincipalMixin.class);
   }
}
