package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> mainPlayerGunRepository = mainPlayer.getGunRepository();

        //това са всички модели оръжия, които томи има
        Collection<Gun> tommyGuns = mainPlayerGunRepository.getModels();

        //това са всички, по които ще стреля
        //civilPlayers

        //опашки
        ArrayDeque<Gun> guns = new ArrayDeque<Gun>(tommyGuns);
        ArrayDeque<Player> players = new ArrayDeque<>(civilPlayers);

        //първия, по който ще стреляме
        Player player = players.poll();

        //първото оръжие
        Gun gun = guns.poll();

        while (player != null && gun != null) {
            //1 gun -> 1 player
            while (gun.canFire() || player.isAlive()) {
                int shot = gun.fire();
                player.takeLifePoints(shot);
            }

            //или не можем да стреляме повече, или нашия човек е каталясал
            //или взимаме ново оръжие
            //или взимаме нова мишена

            if (gun.canFire()) {
                player = players.poll();
            } else {
                gun = guns.poll();
            }
        }

        //минаваме през всички цивилни играчи и им взимаме оръжията
        for (Player civilPlayer : civilPlayers) {

            if (civilPlayer.isAlive()) {
                Repository<Gun> civilPlayerGunRepository = civilPlayer.getGunRepository();

                ArrayDeque<Gun> civilPlayerGuns = new ArrayDeque<>(civilPlayerGunRepository.getModels());
                Gun civilPlayerGun = civilPlayerGuns.poll();

                while (civilPlayerGun != null) {

                    while (civilPlayerGun.canFire() && mainPlayer.isAlive()) {
                        int shot = civilPlayerGun.fire();
                        mainPlayer.takeLifePoints(shot);
                    }

                    if (!mainPlayer.isAlive()) {
                        return;
                    }

                    civilPlayerGun = civilPlayerGuns.poll();
                }
            }
        }
    }
}
