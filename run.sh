echo "========================"
echo "== Downing Project"
echo "========================"
docker-compose down -v && \
if [[ $1 = "--build" ]]
then
    echo "====== Removing images ======"
    docker rmi basma_api_gateway:v1 || true && \
    echo "====== basma_api_gateway Removed"
    docker rmi basma_auth_service:v1 || true && \
    echo "====== basma_auth_service Removed"
    docker rmi basma_front_service:v1 || true && \
    echo "====== basma_front_service Removed"
    docker rmi basma_orders_service:v1 || true && \
    echo "====== basma_orders_service Removed"
    docker rmi basma_products_service:v1 || true && \
    echo "====== basma_products_service Removed"
    docker rmi basma_users_service:v1 || true && \
    echo "====== basma_products_service Removed"
    echo "====== Images removed ======"
fi
echo "========================"
echo "== Runing Project"
echo "========================"
docker-compose up -d
echo "========================"
echo "== Project is running successfully"
echo "========================"